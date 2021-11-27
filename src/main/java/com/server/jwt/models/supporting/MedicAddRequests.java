package com.server.jwt.models.supporting;

import java.util.Set;

public class MedicAddRequests{
    private Integer medicId;

    //Usernames of patients
    private Set<Identifier> requests;

    public Integer getMedicId() {
        return medicId;
    }

    public void setMedicId(int medicId) {
        this.medicId = medicId;
    }

    public Set<Identifier> getRequests() {
        return requests;
    }

    public void setRequests(Set<Identifier> requests) {
        this.requests = requests;
    }
}
