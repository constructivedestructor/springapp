package com.example.springapp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "sales")
@NoArgsConstructor
@Getter
@Setter
public class SalesJPA {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sum")
    private float sum;

    @NotNull
    @Column(name = "date_income")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date date_income;

    @NotNull
    @Column(name = "date_sale")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date date_sale;

    public SalesJPA( float sum, Date date_income, Date date_sale) {
        this.sum = sum;
        this.date_income = date_income;
        this.date_sale = date_sale;
    }

    @Override
    public String toString() {
        return "SalesJPA{" +
                "id=" + id +
                ", sum=" + sum +
                ", date_income=" + date_income +
                ", date_sale=" + date_sale +
                '}';
    }
}
