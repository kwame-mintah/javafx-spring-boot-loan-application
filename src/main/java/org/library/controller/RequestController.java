package org.library.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.library.helper.Navigation;
import org.library.service.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    @FXML
    public TextField requestItemName;
    @FXML
    public TextArea requestReason;
    @FXML
    public Button submitRequest;

    @Autowired
    RequestService requestService;

    private final Navigation navigation;

    private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

    public RequestController(final Navigation navigation) {
        this.navigation = navigation;
    }

    /**
     * On load, display different item types that the user can select from, that can be used
     * when requesting for an item to be added to the system.
     *
     * @param location {@link URL}
     * @param resources {@link ResourceBundle}
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        requestChoices.setItems(FXCollections.observableArrayList(
                "Toy", "Book", "Video Game", "Dvd", "Other"
        ));
        logger.debug("Displaying {} choices to select from", requestChoices);
    }

    public void goHome(final ActionEvent actionEvent) {
        navigation.loadNextScene(actionEvent, LandingController.class);
    }

    public void goBrowse(final ActionEvent actionEvent) {
        navigation.loadNextScene(actionEvent, BrowseController.class);
    }

    public void goReturnItem(final ActionEvent actionEvent) {
        navigation.loadNextScene(actionEvent, ReturnController.class);
    }

    public void goRequestItem(final ActionEvent actionEvent) {
        navigation.loadNextScene(actionEvent, RequestController.class);
    }

    public void goToWelcome(final ActionEvent actionEvent) {
        navigation.loadNextScene(actionEvent, WelcomeController.class);
    }

    /**
     * Get text that has been input by the user and create a new database entry in,
     * the requested table of the application.
     */
    public void sendRequest() {
        final String requestedItemName = requestItemName.getText();
        final String requestedItemType = requestChoices.getSelectionModel().getSelectedItem();
        final String requestedItemReason = requestReason.getText();

        try {
            requestService.insertRequest(requestedItemName, requestedItemType, requestedItemReason);
            logger.debug("Clearing request fields, as entry to requested database was successful");
            requestItemName.clear();
            requestChoices.getSelectionModel().clearSelection();
            requestReason.clear();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Successfully logged item request");
            alert.setContentText(String.format("Your request for %s to be added, has been successfully logged.", requestedItemName));
            alert.showAndWait();
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failed to log request");
            alert.setContentText(String.format("Your request for %s to be added, failed to be logged. Please try again later.", requestedItemName));
            alert.showAndWait();
        }
    }
}
