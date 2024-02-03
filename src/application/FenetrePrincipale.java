package application;
import Emprunt.RetournerWindow;
import Emprunt.EmprunterWindow;
import Lecteur.LecteurListeWindow;
import Lecteur.SearchLecteurWindow;
import Lecteur.DeleteLecteurWindow;
import Livres.DeleteLivreFenetre;
import Livres.FormLivreFenetre;
import Livres.LivreListeFenetre;
import Livres.SearchLivreFenetre;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Lecteur.FormLecteurWindow;
public class FenetrePrincipale extends Application {
	private BorderPane root = new BorderPane();
	private Scene scene = new Scene(root);

	MenuItem nouveauLivreItem = new MenuItem("Ajouter");
	MenuItem listLivreItem = new MenuItem("Afficher Liste");
	MenuItem supprimerLivreItem = new MenuItem("Supprimer");
	MenuItem rechercherLivreItem = new MenuItem("Rechercher");

	MenuItem nouveauLecteurItem = new MenuItem("Ajouter");
	MenuItem listLecteurItem = new MenuItem("Afficher Liste");
	MenuItem supprimerLecteurItem = new MenuItem("Supprimer");
	MenuItem rechercherLecteurItem = new MenuItem("Rechercher");

	MenuItem nouveauEmpruntItem = new MenuItem("Emprunter");
	MenuItem retourlivreItem = new MenuItem("Retour des livres");
	
	private void createMenu(){
		MenuBar menuBar = new MenuBar();
		Menu livreMenu = new Menu("Livres");
		Menu lecteurMenu = new Menu("Lecteurs");
		Menu empruntMenu = new Menu("Emprunts");


		livreMenu.getItems().addAll(nouveauLivreItem,listLivreItem,supprimerLivreItem,rechercherLivreItem);
		
		lecteurMenu.getItems().addAll(nouveauLecteurItem,listLecteurItem,supprimerLecteurItem,rechercherLecteurItem);
		
		empruntMenu.getItems().addAll(nouveauEmpruntItem,retourlivreItem);
		menuBar.getMenus().addAll(livreMenu,lecteurMenu,empruntMenu);
		root.setTop(menuBar);
	}
	
	private void addStylesToNodes(){
		scene.getStylesheets().add("css/style.css");
		root.getStyleClass().add("fenetrePrincipale");
	}
	
	private void addEvents(){
		nouveauEmpruntItem.setOnAction(event->{
			new EmprunterWindow();
		});
		retourlivreItem.setOnAction(event->{
			new RetournerWindow();
			});
		nouveauLivreItem.setOnAction(event->{
			new FormLivreFenetre();
		});
		listLivreItem.setOnAction(event->{
			new LivreListeFenetre();
		});
		supprimerLivreItem.setOnAction(event->{
			new DeleteLivreFenetre();
		});
		rechercherLivreItem.setOnAction(event->{
			new SearchLivreFenetre();
		});
		nouveauLecteurItem.setOnAction(event->{
			new FormLecteurWindow();
		});
		listLecteurItem.setOnAction(event->{
			new LecteurListeWindow();
		});
		supprimerLecteurItem.setOnAction(event->{
			new DeleteLecteurWindow();
		});
		rechercherLecteurItem.setOnAction(event->{
			new SearchLecteurWindow();
		});
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}
	
	@Override
	public void start(Stage window) throws Exception {
		createMenu();
		addEvents();
		addStylesToNodes();
		window.setScene(scene);
		window.setWidth(1100);
		window.setHeight(700);
		window.setTitle("Gestion d'une Bibliothèque");
		

		
		window.show();
		
	}

}
