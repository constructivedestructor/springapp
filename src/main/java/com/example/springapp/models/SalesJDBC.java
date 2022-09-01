package com.example.springapp.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SalesJDBC {
    private int id;
    private float sum;
    private Date date_income;
    private Date date_sale;

    public SalesJDBC(int id, float sum, Date date_income, Date date_sale) {
        this.id = id;
        this.sum = sum;
        this.date_income = date_income;
        this.date_sale = date_sale;
    }

    public SalesJDBC() {
    }

    @Override
    public String toString() {
        return "SalesJDBC{" +
                "id=" + id +
                ", sum=" + sum +
                ", date_income=" + date_income +
                ", date_sale=" + date_sale +
                '}';
    }
}
