package Livres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sun.org.apache.xpath.internal.functions.Function;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LivreListeFenetre {
	LivreListHandler handler = new LivreListHandler(this);
	Stage window = new Stage();
	VBox root = new VBox();
	Scene scene = new Scene(root);
	Label titreLabel = new Label("Liste des livres");
	TableColumn<Livre, Long> codeColumn = new TableColumn<Livre, Long>("Code");
	TableColumn<Livre, Long> ISBNColumn = new TableColumn<Livre, Long>("ISBN");
	TableColumn<Livre, String> TitreColumn = new TableColumn<Livre, String>("Titre");
	TableColumn<Livre, String> auteurColumn = new TableColumn<Livre, String>("Auteur");
	TableColumn<Livre, Double> totalColumn = new TableColumn<>("Total");

	TableView<Livre> livreTableView = new TableView<Livre>();
	ObservableList<Livre> livresObservableList =  FXCollections.observableArrayList();
	
	private void addColumnsToTableView(){
		livreTableView.getColumns().addAll(codeColumn,ISBNColumn,TitreColumn,auteurColumn,totalColumn);
		livreTableView.setItems(livresObservableList);
	}
	private void addNodesToPane(){
		root.getChildren().addAll(titreLabel,livreTableView);
	}



	private void addStylesToNodes(){
	    scene.getStylesheets().add("css/style.css");
	    root.getStyleClass().add("FormLivreFenetre");
	    titreLabel.setMinWidth(window.getWidth());
		titreLabel.getStyleClass().add("labelFenetreTitre");
		livreTableView.getStyleClass().add("table-row-cell");
		livreTableView.setMinHeight(500);
		

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
		totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
		totalColumn.setPrefWidth(100); 


	}
	private void initwindow(){
		window.setScene(scene);
		window.setWidth(800);
		window.setHeight(600);
		window.setTitle("Afficher la liste des livres");
		window.initModality(Modality.APPLICATION_MODAL);
		
		
 	}
	
	
	
	
	public LivreListeFenetre(){
		handler.setListWindow(this);
		System.out.println("Window");
		initwindow();
		addStylesToNodes();
		updateColumns();
		handler.updateLivreListWindows();
		addNodesToPane();
		addColumnsToTableView();
		window.show();
	}
}
	