package softuni.project.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import softuni.project.domain.entities.Landlord;
import softuni.project.domain.models.service.GuestServiceModel;
import softuni.project.domain.models.service.LandlordServiceModel;
import softuni.project.repository.LandlordRepository;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LandlordServiceImpl implements LandlordService {

    private final LandlordRepository landlordRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public LandlordServiceImpl(LandlordRepository landlordRepository, RoleService roleService, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.landlordRepository = landlordRepository;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public LandlordServiceModel registerUser(LandlordServiceModel landlordServiceModel) {
        this.roleService.seedRolesInDb();
        if (this.landlordRepository.count() == 0) {
            landlordServiceModel.setAuthorities(this.roleService.findAllRoles());
        } else {
            landlordServiceModel.setAuthorities(new LinkedHashSet<>());

            landlordServiceModel.getAuthorities().add(this.roleService.findByAuthority("ROLE_USER"));
        }


        Landlord user = this.modelMapper.map(landlordServiceModel, Landlord.class);
        user.setPassword(this.bCryptPasswordEncoder.encode(landlordServiceModel.getPassword()));

        return this.modelMapper.map(this.landlordRepository.saveAndFlush(user), LandlordServiceModel.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.landlordRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
    }

    @Override
    public LandlordServiceModel findUserByUserName(String username) {
        return this.landlordRepository.findByUsername(username)
                .map(u -> this.modelMapper.map(u, LandlordServiceModel.class))
                .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
    }

    @Override
    public LandlordServiceModel editUserProfile(LandlordServiceModel landlordServiceModel, String oldPassword) {
        Landlord user = this.landlordRepository.findByUsername(landlordServiceModel.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));

        if (!this.bCryptPasswordEncoder.matches(oldPassword, user.getPassword())) {
            throw new IllegalArgumentException("Incorrect password!");
        }

        user.setPassword(!"".equals(landlordServiceModel.getPassword()) ?
                this.bCryptPasswordEncoder.encode(landlordServiceModel.getPassword()) :
                user.getPassword());
        user.setEmail(landlordServiceModel.getEmail());

        return this.modelMapper.map(this.landlordRepository.saveAndFlush(user), LandlordServiceModel.class);
    }

    @Override
    public List<LandlordServiceModel> findAllUsers() {
        return this.landlordRepository.findAll()
                .stream().map(u -> this.modelMapper.map(u, LandlordServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void setUserRole(String id, String role) {
        Landlord user = this.landlordRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Incorrect id!"));

        LandlordServiceModel landlordServiceModel = this.modelMapper.map(user, LandlordServiceModel.class);
        landlordServiceModel.getAuthorities().clear();

        switch (role) {
            case "user":
                landlordServiceModel.getAuthorities().add(this.roleService.findByAuthority("ROLE_USER"));
                break;
            case "moderator":
                landlordServiceModel.getAuthorities().add(this.roleService.findByAuthority("ROLE_USER"));
                landlordServiceModel.getAuthorities().add(this.roleService.findByAuthority("ROLE_MODERATOR"));
                break;
            case "admin":
                landlordServiceModel.getAuthorities().add(this.roleService.findByAuthority("ROLE_USER"));
                landlordServiceModel.getAuthorities().add(this.roleService.findByAuthority("ROLE_MODERATOR"));
                landlordServiceModel.getAuthorities().add(this.roleService.findByAuthority("ROLE_ADMIN"));
                break;
        }

        this.landlordRepository.saveAndFlush(this.modelMapper.map(landlordServiceModel, Landlord.class));
    }


    @Override
    public List<GuestServiceModel> findAllApprovedGuests() {
        return null;
    }
}
