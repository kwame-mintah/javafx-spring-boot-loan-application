package org.library;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import org.library.controller.WelcomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class JavaFXApplication extends Application {
    private static final Logger logger = LoggerFactory.getLogger(JavaFXApplication.class);

    @Autowired
    private WelcomeController welcomeController;
    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void init() {
        SpringApplication.run(getClass()).getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void start(Stage stage) {
        logger.info("{} {}", welcomeController.getWelcomeMessage(), welcomeController);
        Parent parent = loadFxml("/fxml/welcome.fxml");
        stage.setScene(new Scene(parent));
        stage.show();
    }

    private Parent loadFxml(String view) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(view));
        loader.setControllerFactory(param -> welcomeController);
        try {
            loader.load();
        } catch (IOException ex) {
            logger.info("IOException while loading resource {}, caused by {}", view, ex.getMessage());
        }
        return loader.getRoot();
    }
}
