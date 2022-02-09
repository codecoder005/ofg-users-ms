package com.orgofarmsgroup.api.v1.users.request.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CreateUserRequestModel {
    @Email(message = "Invalid email.")
    private String workEmail;

    @NotNull
    @NotBlank
    @Pattern(regexp = "[0-9a-zA-Z]{5,}", message = "Auth string didn't meet complexity.")
    private String authString;

    @NotBlank
    @NotNull
    @Pattern(regexp = "[a-zA-Z ]{2,}", message = "first name should have alphabets and a space only")
    private String firstName;

    private String message;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
