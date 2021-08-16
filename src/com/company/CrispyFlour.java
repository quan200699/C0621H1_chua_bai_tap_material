package com.company;

import java.time.LocalDate;

public class CrispyFlour extends Material {
    private int quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(String id, String name, LocalDate createdDate, int cost, int quantity) {
        super(id, name, createdDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int getPrice() {
        return quantity * cost;
    }

    @Override
    public LocalDate getExpiredTime() {
        return createdDate.plusYears(1);
    }

    @Override
    public int getRealMoney() {
        LocalDate currentDate = LocalDate.now();
        int realMoney = (int) (getPrice() - getPrice() * 0.05);
        if (getExpiredTime().isAfter(currentDate.plusMonths(2))) {
            realMoney = (int) (realMoney - realMoney * 0.4);
        } else if (getExpiredTime().isAfter(currentDate.plusMonths(4))) {
            realMoney = (int) (realMoney - realMoney * 0.2);
        }
        return realMoney;
    }

    @Override
    public String toString() {
        return "CrispyFlour{" +
                "quantity=" + quantity +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", cost=" + cost +
                '}';
    }
}
