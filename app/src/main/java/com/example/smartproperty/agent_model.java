package com.example.smartproperty;

public class agent_model {
    private String name;
    private int profileImage;

    public agent_model(String name, int profileImage) {
        this.name = name;
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public int getProfileImage() {
        return profileImage;
    }
}
