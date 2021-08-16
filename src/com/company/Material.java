package com.company;

import java.time.LocalDate;

public abstract class Material implements Discount{
    protected String id;
    protected String name;
    protected LocalDate createdDate;
    protected int cost;

    public Material() {
    }

    public Material(String id, String name, LocalDate createdDate, int cost) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.cost = cost;
    }

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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public abstract int getPrice();

    public abstract LocalDate getExpiredTime();

    @Override
    public String toString() {
        return "Material{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", cost=" + cost +
                '}';
    }
}
