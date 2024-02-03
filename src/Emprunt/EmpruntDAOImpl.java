package Emprunt;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Lecteur.ILecteurDAO;
import Lecteur.Lecteur;
import Lecteur.LecteurDAOImpl;
import Livres.ILivreDAO;
import Livres.Livre;
import Livres.LivreDAOImpl;
import application.AbstractDAO;

public class EmpruntDAOImpl extends AbstractDAO  implements IEmpruntDAO {
	
	
	@Override
	public void add(Emprunt emprunt){
	     PreparedStatement pst = null;
		   String sql = "INSERT INTO Emprunt(id_livre, id_lecteur, date_emprunt, date_retour) VALUES (?, ?, ?, ?)";

	        try {
	            pst = connection.prepareStatement(sql);
	            pst.setLong(1, emprunt.getLivre().getCode()); 
	            pst.setLong(2, emprunt.getLecteur().getCin()); 
	            pst.setDate(3, Date.valueOf(emprunt.getDateEmprunt()));
	            pst.setDate(4, Date.valueOf(emprunt.getDateRetour()));

	            System.out.println("Succès d'exécution de la requête");
	            pst.executeUpdate();
	        } catch (SQLException exp) {
	            System.out.println(exp.getMessage() );
    	
    	}
	        }
	@Override
	public void update(long id) {
	    PreparedStatement pst = null;
	    String sql = "UPDATE emprunt SET date_retour=CURRENT_DATE WHERE id_emprunt =?";

	    try {
	        pst = connection.prepareStatement(sql);
	        pst.setLong(1, id);
	        pst.executeUpdate();
	        System.out.println("Succès d'exécution de la requête");
	    } catch (SQLException exp) {
	        System.out.println(exp.getMessage());
	    
	    
	    }
	}


	@Override
	public List<Emprunt> getAll() {
	   	List<Emprunt> listEmprunt = new ArrayList<Emprunt>();
    	PreparedStatement pst=null;
    	ResultSet rs;
    	String sql = "select * from Emprunt";
    	try{
    	pst = connection.prepareStatement(sql);
    	System.out.println("succes d'execution de la requete");
    	rs=pst.executeQuery();
    	while(rs.next()){
    		ILivreDAO livreDAO = new LivreDAOImpl();
    		Livre livre = livreDAO.getOne(rs.getLong("id_livre"));
    		ILecteurDAO lecteurDAO = new LecteurDAOImpl();
            Lecteur lecteur = lecteurDAO.getOne(rs.getLong("id_lecteur"));
            Date dateEmprunt = rs.getDate("date_emprunt");
            Date dateRetour = rs.getDate("date_retour");
    		listEmprunt.add( new Emprunt(livre, lecteur,dateEmprunt,dateRetour ));
    	}
    	}catch(SQLException exp){
    		System.out.println(exp.getMessage());
    	}
    	return listEmprunt;
	}


}


