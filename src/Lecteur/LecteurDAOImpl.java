package Lecteur;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.AbstractDAO;

public class LecteurDAOImpl extends AbstractDAO  implements ILecteurDAO {
	
	
	@Override
	public void add(Lecteur Lecteur){
	   	PreparedStatement pst=null;
    	String sql = "insert into lecteur(cin, nom, prenom) values(?,?,?)";
    	try{
    	pst = connection.prepareStatement(sql);
    	pst.setLong(1, Lecteur.getCin());
    	pst.setString(2, Lecteur.getNom());
    	pst.setString(3, Lecteur.getPrenom());
    
    	
    	System.out.println("succes d'execution de la requete");
    	pst.execute();
    	}catch(SQLException exp){
    		System.out.println(exp.getMessage());
    	}		
    	}
	
	@Override
	public void delete(long id){
	   	PreparedStatement pst=null;
    	String sql = "delete from lecteur where cin=?";
    	try{
    	pst = connection.prepareStatement(sql);
    	pst.setLong(1, id);
    	System.out.println("succes d'execution de la requete");
    	pst.executeUpdate();
    	}catch(SQLException exp){
    		System.out.println(exp.getMessage());
    	}
	}
	
	@Override
	public Lecteur getOne(long id){
    	PreparedStatement pst=null;
    	ResultSet rs;
    	String sql = "select * from lecteur where cin=?";
    	try{
    	pst = connection.prepareStatement(sql);
    	pst.setLong(1, id);
    	System.out.println("succes d'execution de la requete");
    	rs=pst.executeQuery();
    	if(rs.next()){
    		return new Lecteur(rs.getLong("cin"), rs.getString("nom"),rs.getString("prenom") );
    	}
    	
    	}catch(SQLException exp){
    		System.out.println(exp.getMessage());
    	}
    	return null;
	}




	@Override
	public List<Lecteur> getAll() {
	   	List<Lecteur> listLecteur = new ArrayList<Lecteur>();
    	PreparedStatement pst=null;
    	ResultSet rs;
    	String sql = "select * from lecteur";
    	try{
    	pst = connection.prepareStatement(sql);
    	System.out.println("succes d'execution de la requete");
    	rs=pst.executeQuery();
    	while(rs.next()){
    		listLecteur.add( new Lecteur(rs.getLong("cin"), rs.getString("nom"),rs.getString("prenom") ));
    	}
    	}catch(SQLException exp){
    		System.out.println(exp.getMessage());
    	}
    	return listLecteur;
	}


	@Override
	public List<Lecteur> getAll(String nom) {
	   	List<Lecteur> listLecteur = new ArrayList<Lecteur>();
    	PreparedStatement pst=null;
    	ResultSet rs;
    	String sql = "select * from lecteur where nom like ?";
    	try{
    	pst = connection.prepareStatement(sql);
    	pst.setString(1,nom+"%");
    	System.out.println("succes d'execution de la requete");
    	rs=pst.executeQuery();
    	while(rs.next()){
    		listLecteur.add( new Lecteur(rs.getLong("cin"), rs.getString("nom"),rs.getString("prenom") ));
    	}
    	}catch(SQLException exp){
    		System.out.println(exp.getMessage());
    	}
    	return listLecteur;
	}

	public List<Lecteur> search(long cin, String nom) {
	    List<Lecteur> listLecteur = new ArrayList<>();
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    String sql = "SELECT * FROM lecteur WHERE cin LIKE ? AND nom LIKE ?";

	    try {
	        pst = connection.prepareStatement(sql);
	        pst.setString(1, "%" + cin + "%");
	        pst.setString(2, "%" + nom + "%");

	        System.out.println("Success executing the query");
	        rs = pst.executeQuery();

	        while (rs.next()) {
	            listLecteur.add(new Lecteur(rs.getLong("cin"), rs.getString("nom"), rs.getString("prenom") ));
	        }
	    } catch (SQLException exp) {
	        System.out.println(exp.getMessage());
	    } finally {
	    
	        try {
	            if (pst != null) {
	                pst.close();
	            }
	            if (rs != null) {
	                rs.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return listLecteur;
	}



}
