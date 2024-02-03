package Livres;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LivreAddHandler {
ILivreDAO  ldao = new LivreDAOImpl();
FormLivreFenetre formLivre=null;
public LivreAddHandler(FormLivreFenetre formLivre){
	this.formLivre = formLivre;
}
public void addClick() {
    try {
        String titre = formLivre.titreTextField.getText();
        String auteur = formLivre.auteurTextField.getText();
        long isbn = Long.parseLong(formLivre.ISBNTextField.getText());

     
        if (titre.isEmpty() || auteur.isEmpty()) {
            showErrorAlert("Veuillez remplir les champs Titre et Auteur.");
            return; 
        }

        Livre livre = new Livre(0, titre, auteur, isbn);
        ldao.add(livre);
        showInfoAlert("Livre ajouté avec succès!");
    } catch (NumberFormatException e) {
        showErrorAlert("Veuillez saisir un numéro ISBN valide.");
    } catch (Exception e) {
        showErrorAlert("Erreur lors de l'ajout du livre: " + e.getMessage());
    }
}

private void showErrorAlert(String errorMessage) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText(null);
    alert.setContentText(errorMessage);
    alert.showAndWait();
}

private void showInfoAlert(String message) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Opération réussie");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}

}
