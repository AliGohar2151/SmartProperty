package com.example.smartproperty;

public class projects_model {
    private String title;
    private String description;
    private int imageResId; // Resource ID for the image
    private String demand;
    private String location;
    private String type;

    public projects_model(String title, String description, int imageResId, String demand, String location,String type) {
        this.title = title;
        this.description = description;
        this.imageResId = imageResId;
        this.demand = demand;
        this.location = location;
        this.type=type;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }
    public  void setType(String type){
        this.type=type;
    }
}
