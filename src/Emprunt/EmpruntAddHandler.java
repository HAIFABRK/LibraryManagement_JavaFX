package Emprunt;

import java.sql.Date;
import java.time.LocalDate;

import Emprunt.EmprunterWindow;
import Emprunt.IEmpruntDAO;
import Emprunt.Emprunt;
import Emprunt.EmpruntDAOImpl;
import Lecteur.ILecteurDAO;
import Lecteur.Lecteur;
import Lecteur.LecteurDAOImpl;
import Livres.Livre;


public class EmpruntAddHandler {
IEmpruntDAO  ldao = new EmpruntDAOImpl();
EmprunterWindow empruntWindow=null;

public EmpruntAddHandler(EmprunterWindow formEmprunt){
	this.empruntWindow = formEmprunt;


}
public void addClick(){
    Livre selectedLivre = empruntWindow.getLivreComboBox().getValue();
    Lecteur selectedLecteur = empruntWindow.getLecteurComboBox().getValue();
    Date dateEmprunt =Date.valueOf( empruntWindow.getDateEmpruntPicker().getValue() );
    Date dateRetour = Date.valueOf( empruntWindow.getDateRetourPicker().getValue() );

    Emprunt nouvelEmprunt = new Emprunt(selectedLivre, selectedLecteur, dateEmprunt, dateRetour);
    ldao.add(nouvelEmprunt);
}

}
