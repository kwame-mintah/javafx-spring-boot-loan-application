package org.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.library.helper.Navigation;
import org.library.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/fxml/browse.fxml")
public class BrowseController implements Initializable {
    private Stage stage;
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

    @Autowired
    ItemService itemService;

    private final Navigation navigation;

    private final FxWeaver fxWeaver;

    public BrowseController(final FxWeaver fxWeaver, final Navigation navigation) {
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
}
