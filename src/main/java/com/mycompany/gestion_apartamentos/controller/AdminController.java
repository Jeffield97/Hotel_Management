/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion_apartamentos.controller;

import com.mycompany.gestion_apartamentos.model.DAO.AdminDAO;
import com.mycompany.gestion_apartamentos.model.AdminUser;

/**
 *
 * @author jeffield
 */
public class AdminController {

    private AdminDAO adminUserDAO;

    public static AdminController instance;

    private AdminController() {
        adminUserDAO = new AdminDAO();
    }

    public static AdminController getInstance() {
        if (instance == null) {
            instance = new AdminController();
        }
        return instance;
    }

    public void saveOrUpdateAdminUser(AdminUser adminUser) {
        adminUserDAO.saveOrUpdateAdminUser(adminUser);
    }

    public boolean LoginUser(AdminUser adminUser) {
        AdminUser admin = adminUserDAO.login(adminUser.getUsername(), adminUser.getPassword());
        if (admin.getClass()== adminUser.getClass()) {
            return true;
        }
        return false;
    }

}
