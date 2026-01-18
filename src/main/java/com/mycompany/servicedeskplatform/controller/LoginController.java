package com.mycompany.servicedeskplatform.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.mycompany.servicedeskplatform.model.User;
import com.mycompany.servicedeskplatform.service.AuthService;

public class LoginController {

    private final AuthService authService = new AuthService();

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblError;

    @FXML
    private Button btnLogin;

    @FXML
    private void onLogin() {

        String username = txtUser.getText().trim();
        String password = txtPassword.getText().trim();

        if (username.isBlank() || password.isBlank()) {
            lblError.setText("User and Password are required");
            lblError.setVisible(true);
            return;
        }

        User user = authService.login(username, password);

        if (user == null) {
            lblError.setText("Invalid credentials");
            lblError.setVisible(true);
        } else {
            loadDashboard(username);
        }
    }

    private void loadDashboard(String username) {
        try {
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/mycompany/servicedeskplatform/view/dashboard.fxml")
            );

            Parent root = loader.load();

            DashboardController controller = loader.getController();
            controller.setUsername(username);

            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Service Desk Application");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
