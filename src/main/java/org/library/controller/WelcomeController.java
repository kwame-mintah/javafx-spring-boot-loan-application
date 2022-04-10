package org.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import org.library.helper.Navigation;
import org.library.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class WelcomeController implements Initializable {

    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @FXML
    public Label welcomeLabel;
    public Button login;
    public TextField usernameField;
    public PasswordField passwordField;
    public Label usernameErrorMessage;
    public Label passwordErrorMessage;

    @Autowired
    private GreetingService greetingService;

    private Navigation navigation;

    public WelcomeController(final Navigation navigation, final GreetingService greetingService) {
        this.navigation = navigation;
        this.greetingService = greetingService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        welcomeLabel.setText(greetingService.getWelcomeGreeting());
    }
    
    public String getWelcomeMessage() {
        return greetingService.getWelcomeGreeting();
    }

    /**
     * Check if the user credentials provided are correct
     * @param actionEvent
     * @throws Exception
     */
    public void processLogin(final ActionEvent actionEvent) throws Exception {
        // Get the user input for the login form
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty()){
            logger.debug("Username field is empty: {}", username);
            usernameErrorMessage.setText("Please enter a username to continue");
            usernameErrorMessage.setTextFill(Color.color(1, 0, 0));
        }
        if (password.isEmpty()){
            logger.debug("Password field is empty: {}", password);
            passwordErrorMessage.setText("Please enter a password to continue");
            passwordErrorMessage.setTextFill(Color.color(1, 0, 0));
        }

        if (greetingService.processLoginInfo(usernameField.getText(), passwordField.getText())){
            navigation.loadNextScene(actionEvent, "/fxml/landing.fxml");
        }
    }
}
