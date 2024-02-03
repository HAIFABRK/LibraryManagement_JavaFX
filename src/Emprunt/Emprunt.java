package Emprunt;
import java.sql.Date;
import java.time.LocalDate;

import Lecteur.Lecteur;
import Livres.Livre;




public class Emprunt {
	private long id_emp;
	Livre livre;
	Lecteur lecteur;
	Date dateEmprunt;
	Date dateRetour;
	
	public Emprunt(String titre, String nom,String prenom ,Date dateEmprunt, Date dateRetour) {
		this.livre = new Livre(titre);
		this.lecteur =new Lecteur(nom,prenom);
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
		}
	public Emprunt(Livre livre, Lecteur lecteur,Date dateEmprunt, Date dateRetour) {
		super();
		this.livre = livre;
		this.lecteur = lecteur;
		this.dateEmprunt = dateEmprunt;
		this.dateRetour = dateRetour;
	}
	public long getId_emp() {
		return id_emp;
	}
	public void setId_emp(long id_emp) {
		this.id_emp = id_emp;
	}
	public Livre getLivre() {
		return livre;
	}
	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	public Lecteur getLecteur() {
		return lecteur;
	}
	public void setLecteur(Lecteur lecteur) {
		this.lecteur = lecteur;
	}
	public String getDateEmprunt() {
		return dateEmprunt.toString();
	}
	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	public String getDateRetour() {
		return dateRetour.toString();
	}
	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}
	
	
}