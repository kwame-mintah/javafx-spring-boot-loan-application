package org.library.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import org.library.helper.Navigation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class RequestController implements Initializable {
    @FXML
    public Button landingScene;
    @FXML
    public Button browseScene;
    @FXML
    public Button logout;
    @FXML
    public Button returnItemScene;
    @FXML
    public Button requestItemScene;
    @FXML
    public ChoiceBox<String> requestChoices;

    private final Navigation navigation;

    private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

    private static final String WELCOME_FXML_PATH = "/fxml/welcome.fxml";
    private static final String LANDING_FXML_PATH = "/fxml/landing.fxml";
    private static final String RETURN_FXML_PATH = "/fxml/request.fxml";
    private static final String REQUEST_FXML_PATH = "/fxml/return.fxml";
    private static final String BROWSE_FXML_PATH = "/fxml/browse.fxml";

    public RequestController(){
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

    public void goReturnItem(final ActionEvent actionEvent) throws IOException {
        navigation.loadNextScene(actionEvent, RETURN_FXML_PATH);
    }

    public void goRequestItem(final ActionEvent actionEvent) throws IOException {
        navigation.loadNextScene(actionEvent, REQUEST_FXML_PATH);
    }

    public void goToWelcome(final ActionEvent actionEvent) throws IOException {
        navigation.loadNextScene(actionEvent, WELCOME_FXML_PATH);
    }

    public void avaliablechoices(final Event mouseEvent) {
        logger.debug("User action on this field was {}", mouseEvent.getEventType());
        requestChoices.setItems(FXCollections.observableArrayList(
                "Toys", "Books", "Video Game", "Dvd"
        ));
    }
}
