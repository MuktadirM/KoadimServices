package com.muktadir.koadimservices.Modules.Events.DataModel;

public class ServiceEvent_Data {
    private int id;
    private String Name;
    private String image;

    public ServiceEvent_Data(int id, String name, String image) {
        this.id = id;
        Name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getImage() {
        return image;
    }
}
