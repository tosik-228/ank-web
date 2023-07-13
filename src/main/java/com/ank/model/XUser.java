package com.ank.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@Data
public class XUser extends BaseEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    private LocalDateTime created;
    private LocalDateTime modified;

    @Column(name = "activation_code")
    private String activationCode;


    public XUser() {

        LocalDateTime date = LocalDateTime.now();
        super.id = UUID.randomUUID().toString();
        this.created = date;
        this.modified = date;
    }
}