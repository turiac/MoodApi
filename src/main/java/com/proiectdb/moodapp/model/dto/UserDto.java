package com.proiectdb.moodapp.model.dto;

import com.sun.istack.NotNull;

public class UserDto {
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private String matchingPassword;
}
