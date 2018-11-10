/*
 * Class Name:    FontSelector
 *
 * Author:        Your Name
 * Creation Date: Saturday, November 10 2018, 22:39
 * Last Modified: Saturday, November 10 2018, 22:39
 *
 * Class Description:
 *
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.ChoiceBox;

public class FontSelector extends Application //I KEEP FUCKING FORGETTING THIS
{
  public void start(Stage stage)
  {
    build(stage);
    stage.setTitle(getClass().getName());
    stage.show();
  }

    String fontFamily = "SANSERIF";
    String fontSize = "20px";
    String fontWeight = "NORMAL";
    String fontStyle = "NORMAL";


  public void build(Stage stage)
  {
    Label message = new Label("LET'S GET THAT BREAD");
    message.setStyle(getFontCSSRule(fontFamily, fontSize, fontWeight, fontStyle));

    RadioButton sansSerif = new RadioButton("Sans Serif");
    RadioButton serif = new RadioButton("Serif");
    RadioButton monoSpaced = new RadioButton("Monospaced");

    ToggleGroup group = new ToggleGroup();
    sansSerif.setToggleGroup(group);
    serif.setToggleGroup(group);
    monoSpaced.setToggleGroup(group);

    serif.setSelected(true);

    HBox fontFB = new HBox();
    fontFB.getChildren().addAll(sansSerif,serif, monoSpaced);
    fontFB.setStyle("-fx-spacing: 20; -fx-alignment: center");

    CheckBox boldCB = new CheckBox("Bold");
    boldCB.setSelected(false);

    CheckBox italicCB = new CheckBox("italic");
    italicCB.setSelected(false);

    ChoiceBox<String> sizeChoiceBox = new ChoiceBox<String>();
    sizeChoiceBox.getItems().addAll("10", "20", "30", "40", "50");
    sizeChoiceBox.setValue("20");
    Button displayBT = new Button("Display");
    displayBT.setOnAction((e) ->
    {
      RadioButton selectedRB = (RadioButton) group.getSelectedToggle();
      //set fontFB
      if(selectedRB == sansSerif)
      {
        fontFamily = "SANSERIF";
      }
      else if(selectedRB == serif)
      {
        fontFamily = "SERIF";
      }
      else if(selectedRB == monoSpaced)
      {
        fontFamily = "MONOSPACED";
      }

    //set weight
    fontWeight = boldCB.isSelected()? "BOLD" : "NORMAL";

    fontStyle = italicCB.isSelected()? "ITALIC" : "NORMAL";

    fontSize = sizeChoiceBox.getValue().trim();

    message.setStyle(getFontCSSRule(fontFamily, fontSize, fontWeight, fontStyle));
  });

    VBox root = new VBox();
    root.getChildren().addAll(fontFB, boldCB, italicCB, sizeChoiceBox, displayBT, message);
    root.setStyle("-fx-spacing: 20; -fx-allignment: center");

    Scene scene = new Scene(root, 400, 300);
    stage.setScene(scene);
  }

  public String getFontCSSRule(String fontFamily, String fontSize, String fontWeight, String fontStyle)
  {
    return "-fx-font-family: " + fontFamily + ";" +
           "-fx-font-size: " + fontSize + ";" +
           "-fx-font-weight " + fontWeight + ";" +
           "-fx-font-style" + fontStyle + ";";

  }

}
