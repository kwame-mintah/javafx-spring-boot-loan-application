package org.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.library.entity.ItemEntity;
import org.library.helper.Navigation;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
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
    @FXML
    public Button requestItemButton;
    @FXML
    public Button returnItemButton;
    @FXML
    public Label itemName;
    @FXML
    public Label itemDescription;
    @FXML
    public Label itemAvailableCount;
    @FXML
    public Label itemReleaseDate;
    @FXML
    public ImageView itemImage;

    private final Navigation navigation;

    public InspectController(final FxWeaver fxWeaver, final Navigation navigation) {
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

    /**
     * Using the selectedItems object, set the labels on to inspect scene accordingly,
     * additionally, if an image path has been provided in the image column the placeholder,
     * image will be replaced with the image and blendmode will be changed.
     *
     * @param selectedItem {@link ItemEntity}
     */
    @FXML
    public void setItemInformation(final List<ItemEntity> selectedItem) {
        itemName.setText(selectedItem.get(0).getName());
        itemDescription.setText(selectedItem.get(0).getDescription());
        itemAvailableCount.setText(String.valueOf(selectedItem.get(0).getAvailableCount()));
        itemReleaseDate.setText(String.valueOf(selectedItem.get(0).getReleaseDate()));
        if (!selectedItem.get(0).getImage().isEmpty() || selectedItem.get(0).getImage() != null) {
            itemImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/" + selectedItem.get(0).getImage()))));
            itemImage.setBlendMode(BlendMode.SRC_OVER);
        }
    }
}
