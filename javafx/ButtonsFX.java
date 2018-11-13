/*
 * Class Name:    ButtonsFX
 *
 * Author:        Your Name
 * Creation Date: Saturday, November 10 2018, 18:48 
 * Last Modified: Saturday, November 10 2018, 18:48
 * 
 * Class Description:
 *
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
public class ButtonsFX extends Application
{
    public void start(Stage stage)
    {
        build(stage);
        stage.setTitle(getClass().getName());
        stage.show();
    }

    public void build(Stage stage)
    {    
        
       Label breadLabel = new Label("Would you like to get that bread?");
        
        Button breadButton = new Button("LET'S GET IT!");

        VBox root = new VBox(breadLabel, breadButton);
        root.setStyle("-fx-allignment: center");
        
        //root.getChildren().add(breadLabel,breadButton);
        
        breadButton.setStyle("-fx-font:50 ARIAL");
        breadLabel.setStyle("-fx-font: 40 ARIAL");
        Scene scene = new Scene(root, 700 , 300);
        stage.setScene(scene);
    }
}

