package com.orgofarmsgroup.api.v1.users.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;

    @Column(name = "work_email", nullable = false, unique = true)
    private String workEmail;

    @Column(name = "auth_string", nullable = false)
    private String authString;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_mod_time_date", columnDefinition = "datetime default current_timestamp")
    private Timestamp lastModTimeDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getAuthString() {
        return authString;
    }

    public void setAuthString(String authString) {
        this.authString = authString;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
