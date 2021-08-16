package com.company;

import java.time.LocalDate;

public class Meat extends Material {
    private double weight;

    public Meat() {
    }

    public Meat(String id, String name, LocalDate createdDate, int cost, double weight) {
        super(id, name, createdDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public int getPrice() {
        return (int) (cost * weight);
    }

    @Override
    public LocalDate getExpiredTime() {
        return createdDate.plusDays(7);
    }

    @Override
    public int getRealMoney() {
        LocalDate currentDate = LocalDate.now();
        int realMoney = (int) (getPrice() - getPrice() * 0.1);
        if (getExpiredTime().isAfter(currentDate.plusDays(3))) {
            realMoney = (int) (realMoney - realMoney * 0.5);
        } else if (getExpiredTime().isAfter(currentDate.plusDays(5))) {
            realMoney = (int) (realMoney - realMoney * 0.3);
        }
        return realMoney;
    }

    @Override
    public String toString() {
        return "Meat{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", cost=" + cost +
                ", weight=" + weight +
                '}';
    }
}
