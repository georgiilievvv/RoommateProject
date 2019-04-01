package softuni.project.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "landlords")
public class Landlord extends BaseUser {

    private String roommateGender;
    private String conditions;
    private List<Guest> approvedRoommates;

    public Landlord() {
    }

    @Column(name = "roommate_gender")
    public String getRoommateGender() {
        return roommateGender;
    }

    public void setRoommateGender(String roommateGender) {
        this.roommateGender = roommateGender;
    }

    @Column(name = "conditions")
    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    @ManyToMany(targetEntity = Guest.class)
    @JoinTable(
            name = "approved_roommates_landlord_approvals",
            joinColumns = @JoinColumn(name = "landlord_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roommates_id", referencedColumnName = "id")
    )
    public List<Guest> getApprovedRoommates() {
        return approvedRoommates;
    }

    public void setApprovedRoommates(List<Guest> approvedRoommates) {
        this.approvedRoommates = approvedRoommates;
    }
}
