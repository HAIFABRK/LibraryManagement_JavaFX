package Lecteur;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LecteurAddHandler {
    ILecteurDAO ldao = new LecteurDAOImpl();
    FormLecteurWindow formLecteur = null;

    public LecteurAddHandler(FormLecteurWindow formLecteur) {
        this.formLecteur = formLecteur;
    }

    public void addClick() {
        try {
            long cin = Long.parseLong(formLecteur.cinTextField.getText());
            String nom = formLecteur.nomTextField.getText();
            String prenom = formLecteur.prenomTextField.getText();

            if (nom.isEmpty() || prenom.isEmpty()) {
                throw new IllegalArgumentException("Veuillez remplir tous les champs.");
            }

            Lecteur lecteur = new Lecteur(cin, nom, prenom);
            ldao.add(lecteur);
        } catch (NumberFormatException e) {
            showErrorAlert("Veuillez saisir un numéro CIN valide.");
        } catch (IllegalArgumentException e) {
            showErrorAlert(e.getMessage());
        } catch (Exception e) {
            showErrorAlert("Erreur lors de l'ajout du lecteur: " + e.getMessage());
        }
    }

    private void showErrorAlert(String errorMessage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur d'ajout de lecteur");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
}
