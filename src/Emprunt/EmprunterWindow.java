package Emprunt;

import java.time.LocalDate;
import java.util.List;

import application.AbstractDAO;
import application.IDAO;
import Lecteur.ILecteurDAO;
import Lecteur.Lecteur;
import Lecteur.LecteurDAOImpl;
import Livres.ILivreDAO;
import Livres.Livre;
import Livres.LivreDAOImpl;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EmprunterWindow {




	EmpruntAddHandler addHandler = new EmpruntAddHandler(this);
	VBox root = new VBox();
	HBox buttonBox = new HBox();
	Scene scene = new Scene(root);
	Stage window = new Stage();
	Label titreFenetreLabel = new Label("Nouveau Emprunt");
	
    public ComboBox<Livre> livreComboBox = new ComboBox<>();
    public ComboBox<Lecteur> lecteurComboBox = new ComboBox<>();
    private DatePicker dateEmpruntPicker = new DatePicker();
    private DatePicker dateRetourPicker = new DatePicker();

    public ComboBox<Livre> getLivreComboBox() {
        return livreComboBox;
    }

    public ComboBox<Lecteur> getLecteurComboBox() {
        return lecteurComboBox;
    }

    public DatePicker getDateEmpruntPicker() {
        return dateEmpruntPicker;
    }

    public DatePicker getDateRetourPicker() {
        return dateRetourPicker;
    }
	
	Button ajouterEmpruntButton = new Button("Emprunter");
	Button annulerButton = new  Button("Annuler");
	  private <T> void populateComboBox(ComboBox<T> comboBox, IDAO<T> dao, String label) {
	        List<T> items = dao.getAll();
	        comboBox.getItems().addAll(items);
	        root.getChildren().addAll(new Label(label), comboBox);
	    }
	private void addNodesTowindow(){
		ILivreDAO IivreDAO = new LivreDAOImpl();
		ILecteurDAO ILecteurDAO = new LecteurDAOImpl();
		
		populateComboBox(livreComboBox, IivreDAO, "Livre:");
	    populateComboBox(lecteurComboBox,ILecteurDAO, "Lecteur:");

	    root.getChildren().addAll(new Label("Date d'emprunt:"), dateEmpruntPicker);
	    root.getChildren().addAll(new Label("Date de retour:"), dateRetourPicker);

		
		buttonBox.getChildren().addAll(ajouterEmpruntButton,annulerButton);
		root.getChildren().addAll(buttonBox);
	}
	
	private void initwindow(){
		window.setScene(scene);
		window.setWidth(800);
		window.setHeight(600);
		window.setTitle("Ajouter un Emprunt");
		window.initModality(Modality.APPLICATION_MODAL);
		
 	}
	private void addStylesToNodes() {
	    scene.getStylesheets().add("css/style.css");

	    root.getStyleClass().add("FormEmpruntFenetre");

	    titreFenetreLabel.setMinWidth(window.getWidth());
	    titreFenetreLabel.getStyleClass().add("labelFenetreTitre");


	    root.setSpacing(15);
	    buttonBox.setSpacing(20);
	}

	private void addEvents(){
	
		annulerButton.setOnAction(event->{
			window.close();
		});
		ajouterEmpruntButton.setOnAction(event->{
			System.out.println("ajouter Emprunt");
			addHandler.addClick();
			window.close();
		});
		window.setOnCloseRequest(event->{
			event.consume();
		});
	}
	public EmprunterWindow(){
		System.out.println("window");
		initwindow();
		addNodesTowindow();
		addStylesToNodes();
		addEvents();
		window.show();

	}
}
