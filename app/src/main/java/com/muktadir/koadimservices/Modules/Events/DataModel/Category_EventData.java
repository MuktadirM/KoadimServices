package com.muktadir.koadimservices.Modules.Events.DataModel;

import java.util.List;

public class Category_EventData {
    private int id;
    private String Name;
    private List<ServiceEvent_Data> ServiceHome;

    public Category_EventData(int id, String name, List<ServiceEvent_Data> serviceHome) {
        this.id = id;
        Name = name;
        ServiceHome = serviceHome;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public List<ServiceEvent_Data> getServiceHome() {
        return ServiceHome;
    }
}
