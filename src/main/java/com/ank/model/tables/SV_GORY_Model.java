package com.ank.model.tables;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "sv_gori")
@Data
public class SV_GORY_Model {

    @Id
    public long id;

    @Column(name = "name")
    private String name;

    @Column(name = "counter_el")
    private String counter_el;

    @Column(name = "old")
    private int old;

    @Column(name = "new1")
    private int new1;

    @Column(name = "result")
    private int result;

    @Column(name = "withoutVAT")
    private double withoutVAT;

    @Column(name = "withVAT")
    private double withVAT;


    @Column (name = "counter_water")
    private String counter_water;

    @Column(name = "old_water")
    private int old_water;

    @Column(name = "new1_water")
    private int new1_water;

    @Column(name = "result_water")
    private int result_water;

    @Column(name = "withoutVAT_water")
    private double withoutVAT_water;

    @Column(name = "withVAT_water")
    private double withVAT_water;

}