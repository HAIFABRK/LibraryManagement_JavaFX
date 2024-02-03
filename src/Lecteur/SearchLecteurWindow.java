package Lecteur;

import java.awt.Insets;
import java.util.List;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SearchLecteurWindow {
	VBox root = new VBox();
    HBox searchBox = new HBox(10);

    LecteurSearchHandler searchHandler = new LecteurSearchHandler(this);
    Scene scene = new Scene(root);
	Stage window = new Stage();

  
	Label titreLabel = new Label("Rechercher des Lecteurs");
    Button searchButton = new Button("Rechercher");

      
        TableColumn<Lecteur, Long> cinColumn = new TableColumn<>("Cin");
        TableColumn<Lecteur, String> nomColumn = new TableColumn<>("Nom");
        TableColumn<Lecteur, String> prenomColumn = new TableColumn<>("Prenom");

        TextField cinField = new TextField();
        TextField nomField = new TextField();
        TextField prenomField = new TextField();

        
    	TableView<Lecteur> LecteurTableView = new TableView<Lecteur>();
    	ObservableList<Lecteur> LecteursObservableList =  FXCollections.observableArrayList();
    	
    	private void addColumnsToTableView(){
            LecteurTableView.getColumns().addAll(cinColumn, nomColumn, prenomColumn);
    		LecteurTableView.setItems(LecteursObservableList);
    	}
    	
    	
    	  private void search() {
    	        long cinSearch = Integer.valueOf(cinField.getText() );
    	        String nomSearch = nomField.getText().toLowerCase();

    	        List<Lecteur> searchResults = searchHandler.search(cinSearch, nomSearch);

    	        if (searchResults.isEmpty()) {
    	            showNoResultsMessage();
    	        } else {
    	            LecteursObservableList.setAll(searchResults);
    	        }
    	    }

    	    private void showNoResultsMessage() {
    
    	        Platform.runLater(() -> System.out.println("Aucun Lecteur trouvé pour les critères de recherche."));
    	    }
        
    	private Button createSearchButton() {
    	    Button searchButton = new Button("Rechercher");
    	    searchButton.setOnAction(event -> search());
    	    return searchButton;
    	}
       
    	private void addNodesToPane(){
    		 root.getChildren().addAll(searchBox, LecteurTableView);
    		  searchBox.getChildren().addAll(new Label("Cin:"), cinField, new Label("Nom:"), nomField, createSearchButton());
}

        
        private void addStylesToNodes(){
    	    scene.getStylesheets().add("css/style.css");
    	    root.getStyleClass().add("FormLecteurWindow");
    	    titreLabel.setMinWidth(window.getWidth());
    		titreLabel.getStyleClass().add("labelWindowTitre");
    		LecteurTableView.getStyleClass().add("table-row-cell");
    		LecteurTableView.setMinHeight(500);
    		 root.setSpacing(10);

    	}
        

    	private void updateColumns(){
        	cinColumn.setCellValueFactory(new PropertyValueFactory("Cin"));
        	cinColumn.setPrefWidth(80);
        	nomColumn.setCellValueFactory(new PropertyValueFactory("Nom"));
        	nomColumn.setPrefWidth(300);
         	prenomColumn.setCellValueFactory(new PropertyValueFactory("Prenom"));
         	prenomColumn.setPrefWidth(300);

    	}


	private void initwindow(){
		window.setScene(scene);
		window.setWidth(1000);
		window.setHeight(400);
		window.setTitle("Rechercher des Lecteurs");
		window.initModality(Modality.APPLICATION_MODAL);
		
		
 	}

    public SearchLecteurWindow() {
		searchHandler.setListSearchWindow(this);
		System.out.println("Window");
		initwindow();
		addStylesToNodes();
		updateColumns();
		addNodesToPane();
		addColumnsToTableView();
		window.show();
	}
    }

