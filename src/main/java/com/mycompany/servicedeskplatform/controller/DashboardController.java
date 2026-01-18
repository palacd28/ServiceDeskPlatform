/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.servicedeskplatform.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 *
 * @author palac
 */
public class DashboardController {
    
    @FXML
    private Label lblWelcome;
    
    public void setUsername(String username){
        lblWelcome.setText("Welcome: " + username);
    }
}
