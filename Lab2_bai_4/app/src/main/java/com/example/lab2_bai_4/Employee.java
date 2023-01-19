package com.example.lab2_bai_4;

public abstract class Employee {
    private String id;
    private String name;
    private boolean manager = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return name;
    }

    public void setFullName(String name) {
        this.name = name;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean isManager) {
        this.manager = isManager;
    }

    public abstract double TinhLuong();
    @Override
    public String toString() {
        return this.id+" - "+this.name;
    }
}
