package com.server.jwt.entity;

import com.server.jwt.models.supporting.Identifier;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MedicalPractitioner {

    @Id
    private int medicId;
    private String medicNumberOfPractice;

@OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name="medicUsername", referencedColumnName="userName")
private User medicUsername;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "DOCTOR_USER",
            joinColumns = {
                    @JoinColumn(name = "DOCTOR_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "USER_ID")
            }
    )
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }
    public User getMedicUsername() {
        return medicUsername;
    }

    public void setMedicUsername(User medicUsername) {
        this.medicUsername = medicUsername;
    }

    public int getMedicId() {
        return medicId;
    }

    public void setMedicId(int medicId) {
        this.medicId = medicId;
    }

    public String getMedicNumberOfPractice() {
        return medicNumberOfPractice;
    }

    public void setMedicNumberOfPractice(String medicNumberOfPractice) {
        this.medicNumberOfPractice = medicNumberOfPractice;
    }
}
