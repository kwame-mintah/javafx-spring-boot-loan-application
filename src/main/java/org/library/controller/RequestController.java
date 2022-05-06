package org.library.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.library.helper.Navigation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/fxml/request.fxml")
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

    private final FxWeaver fxWeaver;

    private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

    public RequestController(final FxWeaver fxWeaver, final Navigation navigation) {
        this.fxWeaver = fxWeaver;
        this.navigation = navigation;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //
    }

    public void goHome(final ActionEvent actionEvent) throws IOException {
        navigation.loadNextScene(actionEvent, LandingController.class);
    }

    public void goBrowse(final ActionEvent actionEvent) throws IOException {
        navigation.loadNextScene(actionEvent, BrowseController.class);
    }

    public void goReturnItem(final ActionEvent actionEvent) throws IOException {
        navigation.loadNextScene(actionEvent, ReturnController.class);
    }

    public void goRequestItem(final ActionEvent actionEvent) throws IOException {
        navigation.loadNextScene(actionEvent, RequestController.class);
    }

    public void goToWelcome(final ActionEvent actionEvent) throws IOException {
        navigation.loadNextScene(actionEvent, WelcomeController.class);
    }

    public void avaliablechoices(final Event mouseEvent) {
        logger.debug("User action on this field was {}", mouseEvent.getEventType());
        requestChoices.setItems(FXCollections.observableArrayList(
                "Toys", "Books", "Video Game", "Dvd"
        ));
    }
}
