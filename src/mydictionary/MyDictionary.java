package mydictionary;

import assets.Assets;
import ui.MainController;
import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Mohammad Dehghan
 */
public class MyDictionary extends Application {

    public static Stage stage;
    public static StackPane root;

    public static Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = MainController.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainController.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        root.getChildren().clear();
        root.getChildren().addAll(page);
        return (Initializable) loader.getController();
    }

    private Parent createContent() {
        try {
            MainController mc = (MainController) replaceSceneContent("Main.fxml");
        } catch (Exception ex) {
            //Notify.createAlert(ex.getClass().getName() + ": " + ex.getMessage(), Alert.AlertType.ERROR);
        }
        return root;
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        root = new StackPane();
        primaryStage.setTitle("دیکشنری من");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(Assets.class.getResource("divice-logo-58-58.png").toExternalForm()));
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
