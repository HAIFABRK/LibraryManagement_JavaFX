package Livres;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FormLivreFenetre {
	LivreAddHandler addHandler = new LivreAddHandler(this);
	VBox root = new VBox();
	HBox buttonBox = new HBox();
	Scene scene = new Scene(root);
	Stage window = new Stage();
	Label titreFenetreLabel = new Label("Nouveau livre");
	
	Label titreLabel = new Label("Titre:");
	TextField titreTextField = new TextField();
	
	Label ISBNLabel = new Label("ISBN:");
	TextField ISBNTextField = new TextField();
	
	Label auteurLabel = new Label("Auteur:");
	TextField auteurTextField = new TextField();
	
	Button ajouterLivreButton = new Button("Ajouter");
	Button annulerButton = new  Button("Annuler");
	
	private void addNodesTowindow(){
		root.getChildren().add(titreFenetreLabel);
		root.getChildren().addAll(titreLabel,titreTextField);
		root.getChildren().addAll(auteurLabel,auteurTextField);
		root.getChildren().addAll(ISBNLabel,ISBNTextField);
		buttonBox.getChildren().addAll(ajouterLivreButton,annulerButton);
		root.getChildren().addAll(buttonBox);
	}
	
	private void initwindow(){
		window.setScene(scene);
		window.setWidth(800);
		window.setHeight(600);
		window.setTitle("Ajouter un livre");
		window.initModality(Modality.APPLICATION_MODAL);
		
 	}
	private void addStylesToNodes() {
	    scene.getStylesheets().add("css/style.css");

	    root.getStyleClass().add("FormLivreFenetre");

	    titreFenetreLabel.setMinWidth(window.getWidth());
	    titreFenetreLabel.getStyleClass().add("labelFenetreTitre");
	    titreLabel.getStyleClass().add("labelForm");
	    ISBNLabel.getStyleClass().add("labelForm");
	    auteurLabel.getStyleClass().add("labelForm");

	    root.setSpacing(15);
	    buttonBox.setSpacing(20);
	}

	private void addEvents(){
		annulerButton.setOnAction(event->{
			window.close();
		});
		ajouterLivreButton.setOnAction(event->{
			//System.out.println("ajouter livre");
			addHandler.addClick();
			window.close();
		});
		window.setOnCloseRequest(event->{
			event.consume();
		});
	}
	public FormLivreFenetre(){
		System.out.println("window");
		initwindow();
		addNodesTowindow();
		addStylesToNodes();
		addEvents();
		window.show();

	}
}
