package com.ank.model.tables;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "sv_gori_elektrichestvo")
@Data
public class SvGoriEl {

    @Id
    protected int id;

    @Column(name = "name")
    private String name;

    @Column(name = "schetchik")
    private int schetchik;

    @Column(name = "old")
    private int old;

    @Column(name = "new1")
    private int new1;

    @Column(name = "result")
    private int result;

    @Column (name = "withoutVAT")
    private double withoutVAT;

    @Column (name = "withVAT")
    private double withVAT;

}
