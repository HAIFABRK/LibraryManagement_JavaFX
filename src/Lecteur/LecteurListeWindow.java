package Lecteur;
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
public class LecteurListeWindow {

	LecteurListHandler handler = new LecteurListHandler(this);
	Stage window = new Stage();
	VBox root = new VBox();
	Scene scene = new Scene(root);
	Label titreLabel = new Label("Liste des Lecteurs");
	TableColumn<Lecteur, Long> cinColumn = new TableColumn<Lecteur, Long>("Cin");
	TableColumn<Lecteur, String> nomColumn = new TableColumn<Lecteur, String>("Nom");
	TableColumn<Lecteur, String> prenomColumn = new TableColumn<Lecteur, String>("Prenom");


	TableView<Lecteur> LecteurTableView = new TableView<Lecteur>();
	ObservableList<Lecteur> LecteursObservableList =  FXCollections.observableArrayList();
	
	private void addColumnsToTableView(){
		LecteurTableView.getColumns().addAll(cinColumn,nomColumn,prenomColumn);
		LecteurTableView.setItems(LecteursObservableList);
	}
	private void addNodesToPane(){
		root.getChildren().addAll(titreLabel,LecteurTableView);
	}



	private void addStylesToNodes(){
	    scene.getStylesheets().add("css/style.css");
	    root.getStyleClass().add("FormLecteurFenetre");
	    titreLabel.setMinWidth(window.getWidth());
		titreLabel.getStyleClass().add("labelFenetreTitre");
		LecteurTableView.getStyleClass().add("table-row-cell");
		LecteurTableView.setMinHeight(500);
	}
	private void updateColumns(){
		cinColumn.setCellValueFactory(new PropertyValueFactory("Cin"));
		cinColumn.setPrefWidth(150);
		nomColumn.setCellValueFactory(new PropertyValueFactory("Nom"));
		nomColumn.setPrefWidth(150);
		prenomColumn.setCellValueFactory(new PropertyValueFactory("Prenom"));
		prenomColumn.setPrefWidth(150);
	

	}
	private void initwindow(){
		window.setScene(scene);
		window.setWidth(800);
		window.setHeight(600);
		window.setTitle("Afficher la liste des Lecteurs");
		window.initModality(Modality.APPLICATION_MODAL);
		
		
 	}
	
	
	
	
	public LecteurListeWindow(){
		handler.setListWindow(this);
		System.out.println("Window");
		initwindow();
		addStylesToNodes();
		updateColumns();
		handler.updateLecteurListWindows();
		addNodesToPane();
		addColumnsToTableView();
		window.show();
	}
}
	