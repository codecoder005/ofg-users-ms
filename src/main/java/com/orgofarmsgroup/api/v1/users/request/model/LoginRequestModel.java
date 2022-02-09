package com.orgofarmsgroup.api.v1.users.request.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class LoginRequestModel {
    private String userId;

    @Email(message = "Invalid email Id.")
    private String emailId;

    @NotNull(message = "auth string can not be null.")
    @NotBlank(message = "auth string can not be empty.")
    @Pattern(regexp = "[a-zA-Z0-9]{5,}")
    private String authString;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAuthString() {
        return authString;
    }

    public void setAuthString(String authString) {
        this.authString = authString;
    }
}
