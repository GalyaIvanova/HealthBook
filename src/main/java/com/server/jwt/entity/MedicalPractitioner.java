package com.server.jwt.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MedicalPractitioner {

    @Id
    private int medicId;
    private String medicNumberOfPractice;
    private String medicUsername;

//TODO medicUsername and userName relation


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
    public String getMedicUsername() {
        return medicUsername;
    }

    public void setMedicUsername(String medicUsername) {
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
