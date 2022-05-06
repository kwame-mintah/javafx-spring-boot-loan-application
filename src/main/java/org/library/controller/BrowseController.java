package org.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
    public ListView<String> itemTypes;
    @FXML
    public ListView<String> itemNames;

    @Autowired
    ItemService itemService;

    private final Navigation navigation;

    private final FxWeaver fxWeaver;

    String[] placeHolderItems = {"Type 1", "Type 2", "Type 3"};
    String[] placeHolderItemsNames = {"Cool Item 1", "Cool Item 2", "Cool Item 3"};

    public BrowseController(final FxWeaver fxWeaver, final Navigation navigation) {
        this.fxWeaver = fxWeaver;
        this.navigation = navigation;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemTypes.getItems().addAll(placeHolderItems);
        itemNames.getItems().addAll(placeHolderItemsNames);
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
