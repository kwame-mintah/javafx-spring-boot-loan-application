package org.library.controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;

@ExtendWith(ApplicationExtension.class)
class WelcomeControllerTest extends ApplicationTest {

    private Button button;

    @Override
    public void start(Stage stage) {
        button = new Button("Login");
        button.setOnAction(actionEvent -> button.setText("Logged in!"));
        stage.setScene(new Scene(new StackPane(button), 100, 100));
        stage.show();
    }

    @Test
    @DisplayName("Test that login button updates, when clicked.")
    void verifyLoginButtonTextChanges() {
        clickOn(".button");
        FxAssert.verifyThat(".button", LabeledMatchers.hasText("Login"));
    }
}