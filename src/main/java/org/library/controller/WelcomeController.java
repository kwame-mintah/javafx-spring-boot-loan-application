package org.library.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.library.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class WelcomeController implements Initializable {
    @FXML
    public Label welcomeLabel;
    @Autowired
    private GreetingService greetingService;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        welcomeLabel.setText(greetingService.getWelcomeGreeting());
    }
    public String getWelcomeMessage() {
        return greetingService.getWelcomeGreeting();
    }
}
