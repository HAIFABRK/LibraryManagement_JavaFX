package Lecteur;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class FormLecteurWindow {

	LecteurAddHandler addHandler = new LecteurAddHandler(this);
	VBox root = new VBox();
	HBox buttonBox = new HBox();
	Scene scene = new Scene(root);
	Stage window = new Stage();
	Label titreFenetreLabel = new Label("Nouveau Lecteur");
	
	Label cinLabel = new Label("Cin:");
	TextField cinTextField = new TextField();
	
	Label nomLabel = new Label("Nom:");
	TextField nomTextField = new TextField();
	
	Label prenomLabel = new Label("Prenom:");
	TextField prenomTextField = new TextField();
	

	
	Button ajouterLecteurButton = new Button("Ajouter");
	Button annulerButton = new  Button("Annuler");
	
	private void addNodesTowindow(){
		root.getChildren().add(titreFenetreLabel);
		root.getChildren().addAll(cinLabel,cinTextField);
		root.getChildren().addAll(nomLabel,nomTextField);
		root.getChildren().addAll(prenomLabel,prenomTextField);

		buttonBox.getChildren().addAll(ajouterLecteurButton,annulerButton);
		root.getChildren().addAll(buttonBox);
	}
	
	private void initwindow(){
		window.setScene(scene);
		window.setWidth(800);
		window.setHeight(600);
		window.setTitle("Ajouter un Lecteur");
		window.initModality(Modality.APPLICATION_MODAL);
		
 	}
	private void addStylesToNodes() {
	    scene.getStylesheets().add("css/style.css");

	    root.getStyleClass().add("FormLecteurFenetre");

	    titreFenetreLabel.setMinWidth(window.getWidth());
	    titreFenetreLabel.getStyleClass().add("labelFenetreTitre");
	    cinLabel.getStyleClass().add("labelForm");
	    nomLabel.getStyleClass().add("labelForm");
	    prenomLabel.getStyleClass().add("labelForm");

	    root.setSpacing(15);
	    buttonBox.setSpacing(20);
	}

	private void addEvents(){
		annulerButton.setOnAction(event->{
			window.close();
		});
		ajouterLecteurButton.setOnAction(event->{
			System.out.println("ajouter Lecteur");
			addHandler.addClick();
			window.close();
		});
		window.setOnCloseRequest(event->{
			event.consume();
		});
	}
	public FormLecteurWindow(){
		System.out.println("window");
		initwindow();
		addNodesTowindow();
		addStylesToNodes();
		addEvents();
		window.show();

	}
}
