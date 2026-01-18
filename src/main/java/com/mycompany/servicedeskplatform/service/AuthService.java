/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.servicedeskplatform.service;

import com.mycompany.servicedeskplatform.model.User;

/**
 *
 * @author palac
 */
public class AuthService {

    public User login(String username, String password) {

        //1. Simulation (No BD)
        if ("Administrator".equals(username) && "Admin1234".equals(password)) {
            return new User(username, "Administrator");
        }

        if ("Agent".equals(username) && "Agent1234".equals(password)) {
            return new User(username, "Agent");
        }

        // Invalid login
        return null;
    }

}
