/*
 * Class Name:    CatalogFX
 *
 * Author:        Your Name
 * Creation Date: Monday, November 12 2018, 20:49 
 * Last Modified: Monday, November 12 2018, 20:49
 * 
 * Class Description:
 *
 */
import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.text.*;

import java.util.*;

public class CatalogFX extends Application
{
    private static final String DATA_FILE_NAME = "MusicCatalog.dat";
    private MusicCatalogDS catalogDS = new MusicCatalogDS();



    //Declare all textfields at above the workspace
    private TextArea displayTextArea = new TextArea();
    private TextField idTextField = new TextField();
    private TextField nameTextField = new TextField();
    private TextField genreTextField = new TextField();
    private TextField isCompilationTextField = new TextField();
    private TextField trackCountTextField = new TextField();
    
    public void start(Stage stage) throws Exception
    {
        build(stage);
        stage.setTitle(getClass().getName());
        stage.show();

        Thread.currentThread().setUncaughtExceptionHandler((thread, exception) ->
        {
            System.out.println("Error" + exception);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("ERROR " + exception);
            alert.showAndWait();
        });
    }

    public void build(Stage stage) throws Exception
    {
        //Creating a text area
        displayTextArea.setMaxWidth(200);
        displayTextArea.setMaxHeight(200);

        //Creating a label with supplied text
        Label idLabel = new Label("ID: ");
        idTextField = new TextField();
        HBox idHBox = new HBox();
        idHBox.getChildren().addAll(idLabel,idTextField);

        Label nameLabel = new Label("name: ");
        HBox nameHBox = new HBox();
        idHBox.getChildren().addAll(nameLabel, nameTextField);

        Label genreLabel = new Label("genre: ");
        genreTextField = new TextField();
        HBox genreHBox = new HBox();
        genreHBox.getChildren().addAll(genreLabel, genreTextField);

        Label isCompilationLabel = new Label("is Compilation: ");
        isCompilationTextField = new TextField();
        HBox isCompilationHBox = new HBox();
        isCompilationHBox.getChildren().addAll(isCompilationLabel, isCompilationTextField);

        Label trackCountLabel = new Label("TrackCount: ");
        trackCountTextField = new TextField();
        HBox trackCountHBox = new HBox();
        trackCountHBox.getChildren().addAll(trackCountLabel, trackCountTextField);

        //Creating Buttons
        Button loadDataButton = new Button("Load Data");
        Button displayAlbumsButton = new Button("Display albums");
        Button searchAlbumsButton = new Button("Search Album");
        Button addAlbumButton = new Button("Add Album");
        Button removeAlbumButton = new Button("Remove Album");
        Button saveDataButton = new Button("Save data");

        //Making a FlowPane ButtonPane
        FlowPane buttonsPane = new FlowPane();
        buttonsPane.getChildren().addAll(loadDataButton, displayAlbumsButton, searchAlbumsButton,
        addAlbumButton, removeAlbumButton, saveDataButton);
        
        
        //Create a VBox root to contain text area, work area and operation buttons
        VBox root = new VBox();
        root.getChildren().addAll(displayTextArea, idHBox, nameHBox, genreHBox, 
        isCompilationHBox, trackCountHBox, buttonsPane); //DON'T FORGET TO ADD ALL BUTTONS PANE AND ALL HBOX's
        root.setStyle("-fx-allignment: centre; -fx-font-size: 20; -fx-spacing: 20");
        
        //Create scene object
        Scene scene = new Scene(root, 600, 500);
        stage.setScene(scene);

        //Set the scene
        //stage.setScene(scene);

        //Adding behaviors for the buttons

        //load data
        loadDataButton.setOnAction((e) -> loadData(DATA_FILE_NAME));

        //display albums
        displayAlbumsButton.setOnAction((e) -> displayAlbums());

        //search album
        searchAlbumsButton.setOnAction((e) -> searchAlbum());

        //add album
        addAlbumButton.setOnAction((e) -> addAlbum());

        //remove album
        removeAlbumButton.setOnAction((e) -> removeAlbum());

        //save data
        saveDataButton.setOnAction((e) -> saveData(DATA_FILE_NAME));

        //Then code all the methods for the behaviors
    }

    private void loadData(String fileName)
    {
        try
        {
            catalogDS.loadData(fileName);
            System.out.println("\nLOAD DATA:\n" + catalogDS); // to verify

            //HANDLING ERRORS IN JAVA UI
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Data has been successfully loaded from" + DATA_FILE_NAME);
            alert.show(); //or showAndWait();
        }
        catch(Exception exception)
        {
            throw new RuntimeException(exception.getMessage());

        }

    }

    private void displayAlbums()
    {
        List<MusicAlbum> list = catalogDS.getAll();
        String lines = "";
        for(MusicAlbum album: list)
        {
            lines += album.toString() + "\n";
        }

        displayTextArea.setText(lines);
    }

    private void searchAlbum()
    {
        String id = idTextField.getText();
        MusicAlbum album = catalogDS.get(id);

        nameTextField.setText(album.getName());
        genreTextField.setText(album.getGenre() + "");
        isCompilationTextField.setText(album.isCompilation() + " ");
        trackCountTextField.setText(album.getTrackCount() + "");
    }
    
    private void addAlbum()
    {
        String id = idTextField.getText().trim();
        String name = nameTextField.getText().trim();
        String genre = genreTextField.getText().trim();
        boolean isCompilation = Boolean.parseBoolean(isCompilationTextField.getText().trim());
        int trackCount = Integer.parseInt(trackCountTextField.getText().trim());
    

        try
        {
            MusicAlbum album = new MusicAlbum(id, name, genre, isCompilation, trackCount);
            // System.out.println(">>> " + album);

            // Get confirmation from the user
            //
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure youu want to add this album?");
            Optional answer = alert.showAndWait(); 	// not show()

            // add album only when the user says "OK"
            if(answer.isPresent() & answer.get() == ButtonType.OK)
            {
                catalogDS.add(album);
            }
        }
        catch(Exception exception)
        {
            throw new RuntimeException(exception.getMessage());
        }

        System.out.println("\nADD PRODUCT:\n" + catalogDS); // to check
    }

    
	private void removeAlbum()
	{
		String id = idTextField.getText().trim();

		try
		{
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setContentText("Are you sure youu want to add this album?");
			Optional answer = alert.showAndWait(); 	// not show()

			if(answer.isPresent() & answer.get() == ButtonType.OK)
			{
				catalogDS.remove(id);
			}
		}
		catch(Exception exception)
		{
			throw new RuntimeException(exception.getMessage());
		}

		System.out.println("\nRemove album " + id + "\n" + catalogDS); // to check
	}

    private void saveData(String fileName)
	{
		try
		{
			catalogDS.saveData(fileName);

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("Data has been successfully saved to " + DATA_FILE_NAME);
			alert.show(); // or showAndWait()
		}
		catch(Exception exception)
		{
			throw new RuntimeException(exception.getMessage());
        }
    }

}

