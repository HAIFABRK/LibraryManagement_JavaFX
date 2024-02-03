package Livres;

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

public class SearchLivreFenetre {
	VBox root = new VBox();
    HBox searchBox = new HBox(10);

    LivreSearchHandler searchHandler = new LivreSearchHandler(this);
    Scene scene = new Scene(root);
	Stage window = new Stage();

  
	Label titreLabel = new Label("Rechercher des livres");
    Button searchButton = new Button("Rechercher");

      
        TableColumn<Livre, Long> codeColumn = new TableColumn<>("Code");
        TableColumn<Livre, Long> ISBNColumn = new TableColumn<>("ISBN");
        TableColumn<Livre, String> TitreColumn = new TableColumn<>("Titre");
        TableColumn<Livre, String> auteurColumn = new TableColumn<>("Auteur");

        TextField titreField = new TextField();
        TextField auteurField = new TextField();
        
    	TableView<Livre> livreTableView = new TableView<Livre>();
    	ObservableList<Livre> livresObservableList =  FXCollections.observableArrayList();
    	
    	private void addColumnsToTableView(){
            livreTableView.getColumns().addAll(codeColumn, ISBNColumn, TitreColumn, auteurColumn);
    		livreTableView.setItems(livresObservableList);
    	}
    	
    	
    	  private void search() {
    	        String titreSearch = titreField.getText().toLowerCase();
    	        String auteurSearch = auteurField.getText().toLowerCase();

    	        List<Livre> searchResults = searchHandler.search(titreSearch, auteurSearch);

    	        if (searchResults.isEmpty()) {
    	            showNoResultsMessage();
    	        } else {
    	            livresObservableList.setAll(searchResults);
    	        }
    	    }

    	    private void showNoResultsMessage() {
    
    	        Platform.runLater(() -> System.out.println("Aucun livre trouvé pour les critères de recherche."));
    	    }
        
    	private Button createSearchButton() {
    	    Button searchButton = new Button("Rechercher");
    	    searchButton.setOnAction(event -> search());
    	    return searchButton;
    	}
       
    	private void addNodesToPane(){
    		 root.getChildren().addAll(searchBox, livreTableView);
    		  searchBox.getChildren().addAll(new Label("Titre:"), titreField, new Label("Auteur:"), auteurField, createSearchButton());
}

        
        private void addStylesToNodes(){
    	    scene.getStylesheets().add("css/style.css");
    	    root.getStyleClass().add("FormLivreFenetre");
    	    titreLabel.setMinWidth(window.getWidth());
    		titreLabel.getStyleClass().add("labelFenetreTitre");
    		livreTableView.getStyleClass().add("table-row-cell");
    		livreTableView.setMinHeight(500);
    		 root.setSpacing(10);

    	}
        
       
       

    	private void updateColumns(){
    		codeColumn.setCellValueFactory(new PropertyValueFactory("Code"));
    		codeColumn.setPrefWidth(80);
    		ISBNColumn.setCellValueFactory(new PropertyValueFactory("ISBN"));
    		ISBNColumn.setPrefWidth(80);
    		TitreColumn.setCellValueFactory(new PropertyValueFactory("Titre"));
    		TitreColumn.setPrefWidth(300);
    		auteurColumn.setCellValueFactory(new PropertyValueFactory("Auteur"));
    		auteurColumn.setPrefWidth(230);
    	
    	}

 
	
	private void initwindow(){
		window.setScene(scene);
		window.setWidth(1000);
		window.setHeight(400);
		window.setTitle("Rechercher des livres");
		window.initModality(Modality.APPLICATION_MODAL);
		
		
 	}

    public SearchLivreFenetre() {
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

