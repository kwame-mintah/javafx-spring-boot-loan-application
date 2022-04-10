package org.library.helper;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
public class Navigation {

    /**
     * Load the FXML file and set the next scene to be shown,
     * will replace current window.
     *
     * @param actionEvent required to get current scene
     * @param fxml location of fxml file
     * @throws IOException
     */
    public void loadNextScene(final ActionEvent actionEvent, final String fxml) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}
