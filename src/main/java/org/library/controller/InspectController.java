package org.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.library.helper.Navigation;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/fxml/inspect.fxml")
public class InspectController implements Initializable {
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

    private final Navigation navigation;

    private final FxWeaver fxWeaver;

    public InspectController(final FxWeaver fxWeaver, final Navigation navigation) {
        this.fxWeaver = fxWeaver;
        this.navigation = navigation;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //
    }

    public void goToWelcome(final ActionEvent actionEvent) throws IOException {
        navigation.loadNextScene(actionEvent, WelcomeController.class);
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

    public void goHome(final ActionEvent actionEvent) throws IOException {
        navigation.loadNextScene(actionEvent, LandingController.class);
    }
}
