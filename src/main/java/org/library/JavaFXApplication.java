package org.library;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.library.controller.WelcomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFXApplication extends Application {
    private static final Logger logger = LoggerFactory.getLogger(JavaFXApplication.class);
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        this.applicationContext = new SpringApplicationBuilder()
                .sources(LibrarySystemApplication.class)
                .run(args);
    }

    @Override
    public void start(Stage stage) {
        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(WelcomeController.class);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        logger.info("Loaded {}", WelcomeController.class);
    }

    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }
}
