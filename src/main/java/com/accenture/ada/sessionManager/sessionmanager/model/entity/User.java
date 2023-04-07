package com.accenture.ada.sessionManager.sessionmanager.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String companyCode;

}
