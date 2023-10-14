/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion_apartamentos.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

/**
 *
 * @author jeffield
 */
@Entity
@Table(name = "AdminUser")
public class AdminUser {
    @Id
    private int id;
    private String username;
    private String password;

    public AdminUser() {
    }

    public AdminUser(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public AdminUser(String username, String password){
        this.username= username;
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
