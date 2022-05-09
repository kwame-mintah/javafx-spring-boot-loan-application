package org.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import net.rgielen.fxweaver.core.FxmlView;
import org.library.dto.ItemDto;
import org.library.entity.BorrowedEntity;
import org.library.entity.ItemEntity;
import org.library.helper.Navigation;
import org.library.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

@Component
@FxmlView("/fxml/return.fxml")
public class ReturnController implements Initializable {
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
    public Button returnItem;
    @FXML
    public Button requestItemExtension;
    @FXML
    public Label itemDescription;
    @FXML
    public Label itemName;
    @FXML
    public ImageView itemImage;
    @FXML
    public Tab returnItemTab;
    @FXML
    public TabPane borrowedTabPane;

    @Autowired
    ItemService itemService;

    private final Navigation navigation;

    public ReturnController(final Navigation navigation) {
        this.navigation = navigation;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<BorrowedEntity> allItems = itemService.getAllBorrowedItems();
        Optional<ItemEntity> getItemInfo;
        if (!allItems.isEmpty()) {
            borrowedTabPane.getTabs().clear();
            for (BorrowedEntity allItem : allItems) {
                getItemInfo = itemService.findById(allItem.getItemId());
                if (getItemInfo.isPresent()){
                    createNewTabForItems(getItemInfo);
                }
            }
        } else {
            itemName.setText("No items to return");
            itemDescription.setText("No items to return");
            borrowedTabPane.setDisable(true);
            requestItemExtension.setDisable(true);
            returnItem.setDisable(true);
        }
    }

    private void createNewTabForItems(final Optional<ItemEntity> itemsBorrowedInfo) {
        if (itemsBorrowedInfo.isPresent()){
            FlowPane pane = new FlowPane();
            ItemDto itemDto = itemsBorrowedInfo.get();
            ImageView image = new ImageView(new Image(Objects.requireNonNull(getClass()
                    .getResourceAsStream("/images/" + itemDto.getImage())),
                    300, 300, false, false));
            Tab tab = new Tab(itemDto.getName());
            pane.getChildren().addAll(image);
            tab.setContent(pane);
            borrowedTabPane.getTabs().add(tab);
        }
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

    public void removeItemFromAccount() {
        Tab selectedItem = borrowedTabPane.getSelectionModel().getSelectedItem();
        itemService.returnItem(selectedItem.getText());
        selectedItem.setDisable(true);
    }

    public void requestExtension() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Extension Requested");
        alert.setContentText(String.format("Successfully requested extension for %s",
                borrowedTabPane.getSelectionModel().getSelectedItem().getText()));
        alert.showAndWait();
    }
}
