//	Resize the stage window and observe the effect

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class BMI extends Application
{
	public void start(Stage stage)
	{
		build(stage);
		stage.setTitle(getClass().getName());
		stage.show();
	}

	public void build(Stage stage)
	{
		// Define controls
		Label header = new Label("BMI Calculator");
		header.setStyle("-fx-font-size: 40");

		Label heightLB = new Label("Enter your height (in cm): ");
		TextField heightTF = new TextField();

		Label weightLB = new Label("Enter your weight (in kg): ");
		TextField weightTF = new TextField();

		Button calculateBT = new Button("Calculate BMI");

		Label bmiLB = new Label("Your BMI will be displayed here");

		calculateBT.setOnAction(e ->
			{
				double height = Double.parseDouble(heightTF.getText().trim())/100;
				int weight = Integer.parseInt(weightTF.getText().trim());
				double bmi = weight / (height * height);
				bmiLB.setText("Your bmi is: " + String.format("%.2f", bmi));
			});

		TextArea infoTA = new TextArea();
		infoTA.appendText(
			"A BMI of 18.5 to 25 may indicate optimal weight\n" +
			"A BMI lower than 18.5 suggests the person is underweight\n" +
			"A BMI above 25 may indicate the person is overweight\n" +
			"A BMI above 30 suggests the person is obese");

		// Define layout

		HBox h1 = new HBox();
		HBox h2 = new HBox();
		HBox h3 = new HBox();
		HBox h4 = new HBox();
		HBox h5 = new HBox();
		HBox h6 = new HBox();

		VBox root = new VBox();

		h1.getChildren().addAll(header);
		h2.getChildren().addAll(heightLB, heightTF);
		h3.getChildren().addAll(weightLB, weightTF);
		h4.getChildren().addAll(calculateBT);
		h5.getChildren().addAll(bmiLB);
		h6.getChildren().addAll(infoTA);

		root.getChildren().addAll(h1, h2,h3, h4, h5, h6);

		//	Set scene and stage
		Scene scene = new Scene(root, 300, 400);
		stage.setScene(scene);
	}
}
