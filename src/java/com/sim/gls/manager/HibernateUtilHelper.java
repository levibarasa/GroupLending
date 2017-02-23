/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sim.gls.manager;

import org.hibernate.SessionFactory;

/**
 *
 * @author Levi
 */
public class HibernateUtilHelper {
     public HibernateUtilHelper()
    {
        
    }
    
    public SessionFactory getGLSHU()
    {
        return HibernateUtil.getSessionFactory();
    } 
}
