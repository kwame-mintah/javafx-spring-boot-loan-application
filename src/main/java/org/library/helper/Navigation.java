package org.library.helper;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.library.controller.InspectController;
import org.library.entity.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Navigation {
    private final FxWeaver fxWeaver;
    @Autowired
    @Lazy
    InspectController inspectController;

    public Navigation(final FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    /**
     * Load the FXML file and set the next scene to be shown,
     * will replace current window.
     *
     * @param actionEvent required to get current scene
     * @param controller the controller for the scene
     */
    public void loadNextScene(final ActionEvent actionEvent, Class<?> controller) {
        Parent parent = fxWeaver.loadView(controller);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Load the FXML file and set the next scene to be shown,
     * this method also updates labels and images present on the
     * {@link InspectController} scene.
     *
     * @param actionEvent required to get current scene
     * @param controller the controller for the scene
     * @param selectedItem {@link ItemEntity}
     */
    public void inspectItemScene(final MouseEvent actionEvent, Class<?> controller, final List<ItemEntity> selectedItem) {
        Parent parent = fxWeaver.loadView(controller);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        inspectController.setItemInformation(selectedItem);
        stage.show();
    }
}
