package com.muktadir.koadimservices.Modules.Home.DataModel;

import java.util.List;

public class CategoryHome_Data  {
    private int id;
    private String Name;
    private List<ServiceHome_data> ServiceHome;

    public CategoryHome_Data(int id, String name) {
        this.id = id;
        Name = name;
    }

    public CategoryHome_Data(int id, String name, List<ServiceHome_data> serviceHome) {
        this.id = id;
        Name = name;
        ServiceHome = serviceHome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<ServiceHome_data> getServiceHome() {
        return ServiceHome;
    }

    public void setServiceHome(List<ServiceHome_data> serviceHome) {
        ServiceHome = serviceHome;
    }
}
