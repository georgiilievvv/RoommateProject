package softuni.project.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "guests")
public class Guest extends BaseUser {

    private String preferences;
    private List<Landlord> landlord_approvals;
    private List<Apartment> marked_Apartments;
    private List<House> marked_Houses;

    public Guest() {
    }

    @Column(name = "preferences")
    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    @ManyToMany(targetEntity = Landlord.class, mappedBy = "approvedRoommates")
    public List<Landlord> getLandlord_approvals() {
        return landlord_approvals;
    }

    public void setLandlord_approvals(List<Landlord> landlord_approvals) {
        this.landlord_approvals = landlord_approvals;
    }

    @OneToMany(targetEntity = Apartment.class)
    @JoinColumn(name = "apartments_id", referencedColumnName = "id")
    public List<Apartment> getMarked_Apartments() {
        return marked_Apartments;
    }

    public void setMarked_Apartments(List<Apartment> marked_Apartments) {
        this.marked_Apartments = marked_Apartments;
    }

    @OneToMany(targetEntity = House.class)
    @JoinColumn(name = "houses_id", referencedColumnName = "id")
    public List<House> getMarked_Houses() {
        return marked_Houses;
    }

    public void setMarked_Houses(List<House> marked_Houses) {
        this.marked_Houses = marked_Houses;
    }
}
