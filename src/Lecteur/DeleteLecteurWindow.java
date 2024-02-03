package Lecteur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sun.org.apache.xpath.internal.functions.Function;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DeleteLecteurWindow {

	LecteurDeleteHandler deleteHandler = new LecteurDeleteHandler(this);
	Stage window = new Stage();
	VBox root = new VBox();
	HBox buttonBox = new HBox();

	Scene scene = new Scene(root);
	Button supprimerButton = new  Button("Supprimer");
	Label titreLabel = new Label("Supprimer des Lecteurs");
	TableColumn<Lecteur, Long> cinColumn = new TableColumn<Lecteur, Long>("Cin");
	TableColumn<Lecteur, String> nomColumn = new TableColumn<Lecteur, String>("Nom");
	TableColumn<Lecteur, String> prenomColumn = new TableColumn<Lecteur, String>("Prenom");
	TableColumn<Lecteur, Button> supprimerColumn = new TableColumn<>("Spprimer");

	TableView<Lecteur> LecteurTableView = new TableView<Lecteur>();
	ObservableList<Lecteur> LecteursObservableList =  FXCollections.observableArrayList();
	
	private void addColumnsToTableView(){
		LecteurTableView.getColumns().addAll(cinColumn,nomColumn,prenomColumn,supprimerColumn);
		LecteurTableView.setItems(LecteursObservableList);
	}
	private void addNodesToPane(){
		root.getChildren().addAll(titreLabel,LecteurTableView);
		buttonBox.getChildren().addAll(supprimerButton);
		//root.getChildren().addAll(supprimerButton);
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
		cinColumn.setPrefWidth(80);
		nomColumn.setCellValueFactory(new PropertyValueFactory("Nom"));
		nomColumn.setPrefWidth(80);
		prenomColumn.setCellValueFactory(new PropertyValueFactory("Prenom"));
		prenomColumn.setPrefWidth(300);

	    supprimerColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(createDeleteButton(param.getValue())));
		       


		}
	private Button createDeleteButton(Lecteur Lecteur) {
	    Button deleteButton = new Button("Supprimer");
	    deleteButton.setOnAction(event -> {
	    	deleteHandler.deleteClick(Lecteur);
	        LecteursObservableList.remove(Lecteur);

	    });
	    return deleteButton;
	}

	
	private void initwindow(){
		window.setScene(scene);
		window.setWidth(1000);
		window.setHeight(600);
		window.setTitle("Supprimer des Lecteurs");
		window.initModality(Modality.APPLICATION_MODAL);
		
		
 	}

	
	public DeleteLecteurWindow(){
		deleteHandler.setListDeleteWindow(this);
		System.out.println("Window");
		initwindow();
		addStylesToNodes();
		updateColumns();
		deleteHandler.updateLecteurDeleteWindows();
		addNodesToPane();
		addColumnsToTableView();
		window.show();
	}
}
	