package com.ank.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {

    @Id
    protected Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}
