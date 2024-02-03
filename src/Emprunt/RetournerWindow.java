package Emprunt;

import java.sql.Date;
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

public class RetournerWindow {
	RetournerLivreHandler handler = new RetournerLivreHandler(this);
	Stage window = new Stage();
	VBox root = new VBox();
	HBox buttonBox = new HBox();

	Scene scene = new Scene(root);
	Button retournerButton = new  Button("Retourner");
	Label titreLabel = new Label("Supprimer des Emprunts");
	TableColumn<Emprunt, Long> livreColumn = new TableColumn<Emprunt, Long>("Livre");
	TableColumn<Emprunt, Long> lecteurColumn = new TableColumn<Emprunt, Long>("Lecteur");
	TableColumn<Emprunt, Date> dateEmpruntColumn = new TableColumn<Emprunt, Date>("Date Emprunt");
	TableColumn<Emprunt, Date> dateRetourColumn = new TableColumn<Emprunt, Date>("Date Retour");
	TableColumn<Emprunt, Button> retournerColumn = new TableColumn<>("Retourner");

	TableView<Emprunt> EmpruntTableView = new TableView<Emprunt>();
	ObservableList<Emprunt> EmpruntsObservableList =  FXCollections.observableArrayList();
	
	private void addColumnsToTableView(){
		EmpruntTableView.getColumns().addAll(livreColumn,lecteurColumn,dateEmpruntColumn,dateRetourColumn,retournerColumn);
		EmpruntTableView.setItems(EmpruntsObservableList);
	}
	private void addNodesToPane(){
		root.getChildren().addAll(titreLabel,EmpruntTableView);
		buttonBox.getChildren().addAll(retournerButton);
		//root.getChildren().addAll(supprimerButton);
	}


	private void addStylesToNodes(){
	    scene.getStylesheets().add("css/style.css");
	    root.getStyleClass().add("FormEmpruntFenetre");
	    titreLabel.setMinWidth(window.getWidth());
		titreLabel.getStyleClass().add("labelFenetreTitre");
		EmpruntTableView.getStyleClass().add("table-row-cell");
		EmpruntTableView.setMinHeight(500);
		

	}

	private void updateColumns(){
		livreColumn.setCellValueFactory(new PropertyValueFactory("Livre"));
		livreColumn.setPrefWidth(80);
		lecteurColumn.setCellValueFactory(new PropertyValueFactory("Lecteur"));
		lecteurColumn.setPrefWidth(80);
		dateEmpruntColumn.setCellValueFactory(new PropertyValueFactory("dateEmprunt"));
		dateEmpruntColumn.setPrefWidth(300);
		dateRetourColumn.setCellValueFactory(new PropertyValueFactory("dateRetour"));
		dateRetourColumn.setPrefWidth(230);
	
		retournerColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(createDeleteButton(param.getValue())));
	
		}
	private Button createDeleteButton(Emprunt emprunt) {
	    Button retournerButton = new Button("Retourner");
	    retournerButton.setOnAction(event -> {
	    	handler.retournerClick(emprunt);
			//handler.updateEmpruntDeleteWindows();

	 	    });
	    return retournerButton;
	}

	
	private void initwindow(){
		window.setScene(scene);
		window.setWidth(1000);
		window.setHeight(600);
		window.setTitle("Retourner des livres");
		window.initModality(Modality.APPLICATION_MODAL);
		
		
 	}
	

	
	
	
	
	
	public RetournerWindow(){
		handler.setListDeleteWindow(this);
		System.out.println("Window");
		initwindow();
		addStylesToNodes();
		updateColumns();
		handler.updateEmpruntDeleteWindows();
		addNodesToPane();
		addColumnsToTableView();
		window.show();
	}
}
	