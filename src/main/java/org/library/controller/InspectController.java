package org.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import net.rgielen.fxweaver.core.FxmlView;
import org.library.dto.ItemDto;
import org.library.entity.ItemEntity;
import org.library.helper.Navigation;
import org.library.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public Label itemName;
    @FXML
    public Label itemDescription;
    @FXML
    public Label itemAvailableCount;
    @FXML
    public Label itemReleaseDate;
    @FXML
    public ImageView itemImage;

    @Autowired
    ItemService itemService;

    private final Navigation navigation;

    public InspectController(final Navigation navigation) {
        this.navigation = navigation;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //
    }

    public void goToWelcome(final ActionEvent actionEvent) {
        navigation.loadNextScene(actionEvent, WelcomeController.class);
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

    public void goHome(final ActionEvent actionEvent) {
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
        ItemDto itemDto = selectedItem.get(0);
        itemName.setText(itemDto.getName());
        itemDescription.setText(itemDto.getDescription());
        itemAvailableCount.setText(String.valueOf(itemDto.getAvailableCount()));
        itemReleaseDate.setText(String.valueOf(itemDto.getReleaseDate()));
        if (!selectedItem.get(0).getImage().isEmpty() || selectedItem.get(0).getImage() != null) {
            itemImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/" + itemDto.getImage()))));
            itemImage.setBlendMode(BlendMode.SRC_OVER);
        }
    }

    /**
     * Change the items' availability count, when a user decides to request the item.
     * Makes a call to the database to update the availability count.
     */
    public void reduceAvailabilityCount() {
        if (itemAvailableCount.getText().equals("0")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Item unavailable");
            alert.setContentText("Item is not available to be borrowed");
            alert.showAndWait();
            requestItemButton.setDisable(true);
            requestItemButton.setText("Item is not available to be borrowed");
        } else {
            itemService.deductAvailableCount(itemName.getText());
            requestItemButton.setDisable(true);
            requestItemButton.setText("Successfully added to your account");
            itemAvailableCount.setText(String.valueOf(itemService.findByItemName(itemName.getText()).get(0).getAvailableCount()));
        }
    }
}
