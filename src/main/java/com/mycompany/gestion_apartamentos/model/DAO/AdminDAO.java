/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestion_apartamentos.model.DAO;

import com.mycompany.gestion_apartamentos.model.AdminUser;
import com.mycompany.gestion_apartamentos.model.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author jeffield
 */
public class AdminDAO {

    public void saveOrUpdateAdminUser(AdminUser adminUser) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(adminUser);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public AdminUser login(String user, String password) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            // Consulta para buscar un usuario con el nombre de usuario y contraseña proporcionados
            String hql = "FROM AdminUser WHERE username = :nombreUsuario AND password = :contrasena";
            Query query = session.createQuery(hql);
            query.setParameter("nombreUsuario", user);
            query.setParameter("contrasena", password);
            AdminUser usuario = (AdminUser)query.uniqueResult();
            transaction.commit();
            System.out.println("USUARIO "+ usuario.getUsername() +" "+ usuario.getId());
            return usuario;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        } 
        finally{
//            session.close();
System.out.println("Operacion terminada!!!");
        }
    }
}
