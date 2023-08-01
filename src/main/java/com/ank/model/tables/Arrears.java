package com.ank.model.tables;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "arrears")
@Data
public class Arrears {
    @Id
    public long id;

    @Column(name = "name")
    private String name;

    @Column(name = "period")
    private String period;

    @Column(name = "rent")
    private double rent;

    @Column(name = "communal_apartment")
    private double communal_apartment;

    @Column(name = "result")
    private double result;


}
