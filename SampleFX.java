/*
 * Class Name:    SampleFX
 *
 * Author:        Your Name
 * Creation Date: Saturday, November 10 2018, 11:21 
 * Last Modified: Saturday, November 10 2018, 11:21
 * 
 * Class Description:
 *
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.VBox;

public class SampleFX extends Application
{
 
    public void start(Stage stage) 
    {
        build(stage); //Building the stage always comes first
        stage.setTitle(getClass().getName());
        stage.show();
    }
    
    public void build(Stage stage) 
    {
        //Define controls and layout
        VBox root = new VBox();

        //Set scene and stage
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);

    }
}