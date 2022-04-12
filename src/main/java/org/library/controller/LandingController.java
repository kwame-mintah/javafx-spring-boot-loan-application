package org.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.library.helper.Navigation;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class LandingController implements Initializable {
    @FXML
    public Button landingScene;
    @FXML
    public Button browseScene;
    @FXML
    public Button logout;

    private final Navigation navigation;

    private static final String WELCOME_FXML_PATH = "/fxml/welcome.fxml";
    private static final String LANDING_FXML_PATH = "/fxml/landing.fxml";
    private static final String BROWSE_FXML_PATH = "/fxml/browse.fxml";

    public LandingController() {
        this.navigation = new Navigation();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //
    }

    public void goHome(final ActionEvent actionEvent) throws IOException {
        navigation.loadNextScene(actionEvent, LANDING_FXML_PATH);
    }

    public void goBrowse(final ActionEvent actionEvent) throws IOException {
        navigation.loadNextScene(actionEvent, BROWSE_FXML_PATH);
    }

    public void goToWelcome(final ActionEvent actionEvent) throws IOException {
        navigation.loadNextScene(actionEvent, WELCOME_FXML_PATH);
    }
}
