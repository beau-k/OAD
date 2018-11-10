/*
 * Class Name:    BlindSampleFX
 *
 * Author:        Your Name
 * Creation Date: Saturday, November 10 2018, 15:10 
 * Last Modified: Saturday, November 10 2018, 15:10
 * 
 * Class Description:
 *
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class BlindSampleFX extends Application
{
    public void start(Stage stage)
    {
        build(stage);
        stage.setTitle(getClass().getName());
        stage.show(); //IMPORTANT
    }

    //set the stage and scene
    public void build(Stage stage)
    {
        //CREATE VBOX
        VBox root = new VBox();
        //CREATE SCENE OBJECT
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        
        
    }

}

