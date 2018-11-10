/*
 * Class Name:    HelloFX
 *
 * Author:        Your Name
 * Creation Date: Saturday, November 10 2018, 14:45 
 * Last Modified: Saturday, November 10 2018, 14:45
 * 
 * Class Description:
 *
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
public class HelloFX extends Application
{
    //Building the stage
    public void start(Stage stage)
    {
        build(stage);
        stage.setTitle(getClass().getName());
        stage.show();
    }
    //Adding to the stage
    public void build(Stage stage)
    {
        Label messageLabel = new Label("Let's Get that Bread!");
        messageLabel.setStyle("-fx-font: 100 CALIBIRI");

        VBox root = new VBox();
        root.getChildren().add(messageLabel);

        root.setStyle("-fx-allignment: center");
        /* To add elements to VBox
        root.getChildren().addAll(element1, element2) */

        //Setting the scene and stage
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);

    }
}

