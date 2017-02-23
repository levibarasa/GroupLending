/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sim.gls.manager;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Levi
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    
    static
    {
        try
        {
            sessionFactory = new AnnotationConfiguration().configure("gl.cfg.xml").buildSessionFactory();
        } 
        catch (HibernateException ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
