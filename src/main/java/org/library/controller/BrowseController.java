package org.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.library.entity.ItemEntity;
import org.library.helper.Navigation;
import org.library.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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

    private static final Logger logger = LoggerFactory.getLogger(BrowseController.class);

    String[] placeHolderItems = {"Type 1", "Type 2", "Type 3"};
    String[] placeHolderItemsNames = {"Cool Item 1", "Cool Item 2", "Cool Item 3"};

    public BrowseController(final FxWeaver fxWeaver, final Navigation navigation) {
        this.navigation = navigation;
    }

    /**
     * On scene load fetch all items from the library database, this will
     * be displayed back to the user to be able to select from.
     *
     * Change listener is attached to the itemTypes, if a user selects one the results
     * displayed will only show items of that type.
     *
     * @param location {@link URL}
     * @param resources {@link ResourceBundle}
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<ItemEntity> allItems = itemService.getAllItems();
        if (!allItems.isEmpty()) {
            for (ItemEntity allItem : allItems) {
                itemNames.getItems().add(allItem.getName());
                itemTypes.getItems().add(allItem.getType());
            }
        } else {
            logger.warn("Unable to get items as allItems is empty, displaying placeholder values");
            itemNames.getItems().addAll(placeHolderItemsNames);
            itemTypes.getItems().addAll(placeHolderItems);
        }

        itemTypes.getSelectionModel().selectedItemProperty().addListener((arg0, arg1, arg2) -> {
            List<ItemEntity> allItemsByType = itemService.findByItemType(itemTypes.getSelectionModel().getSelectedItem());
            itemNames.getItems().clear();
            for (ItemEntity allItem : allItemsByType) {
                itemNames.getItems().add(allItem.getName());
            }
        });
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

    /**
     * On mouse select event on any of the items returned, will make a call to
     * display the item in more detail, such as image, description, availability.
     * @param mouseEvent {@link MouseEvent}
     */
    public void goToInspectItem(final MouseEvent mouseEvent) {
        List<ItemEntity> selectedItem = itemService.findByItemName(itemNames.getSelectionModel().getSelectedItem());
        navigation.inspectItemScene(mouseEvent, InspectController.class, selectedItem);
    }
}
