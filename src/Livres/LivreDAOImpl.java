package Livres;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.AbstractDAO;

public class LivreDAOImpl extends AbstractDAO  implements ILivreDAO {
	
	
	@Override
	public void add(Livre livre){
	   	PreparedStatement pst=null;
    	String sql = "insert into Livre(ISBN, titre, auteur, total) values(?,?,?,?)";
    	try{
    	pst = connection.prepareStatement(sql);
    	pst.setLong(1, livre.getISBN());
    	pst.setString(2, livre.getTitre());
    	pst.setString(3, livre.getAuteur());
    	pst.setLong(4, livre.getTotal());    	
    	
    	System.out.println("succes d'execution de la requete");
    	pst.execute();
    	}catch(SQLException exp){
    		System.out.println(exp.getMessage());
    	}		
    	}
	
	@Override
	public void delete(long id){
	   	PreparedStatement pst=null;
    	String sql = "delete from Livre where code=?";
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
	public Livre getOne(long id){
    	PreparedStatement pst=null;
    	ResultSet rs;
    	String sql = "select * from Livre where code=?";
    	try{
    	pst = connection.prepareStatement(sql);
    	pst.setLong(1, id);
    	System.out.println("succes d'execution de la requete");
    	rs=pst.executeQuery();
    	if(rs.next()){
    		return new Livre(rs.getLong("code"), rs.getString("titre"),rs.getString("auteur"), rs.getLong("ISBN") );
    	}
    	
    	}catch(SQLException exp){
    		System.out.println(exp.getMessage());
    	}
    	return null;
	}




	@Override
	public List<Livre> getAll() {
	   	List<Livre> listLivre = new ArrayList<Livre>();
    	PreparedStatement pst=null;
    	ResultSet rs;
    	String sql = "select * from Livre";
    	try{
    	pst = connection.prepareStatement(sql);
    	System.out.println("succes d'execution de la requete");
    	rs=pst.executeQuery();
    	while(rs.next()){
    		listLivre.add( new Livre(rs.getLong("code"), rs.getString("titre"),rs.getString("auteur"), rs.getLong("ISBN") ));
    	}
    	}catch(SQLException exp){
    		System.out.println(exp.getMessage());
    	}
    	return listLivre;
	}


	@Override
	public List<Livre> getAll(String s) {
	   	List<Livre> listLivre = new ArrayList<Livre>();
    	PreparedStatement pst=null;
    	ResultSet rs;
    	String sql = "select * from Livre where auteur like ?";
    	try{
    	pst = connection.prepareStatement(sql);
    	pst.setString(1,s+"%");
    	System.out.println("succes d'execution de la requete");
    	rs=pst.executeQuery();
    	while(rs.next()){
    		listLivre.add( new Livre(rs.getLong("code"), rs.getString("titre"),rs.getString("auteur"), rs.getLong("ISBN") ));
    	}
    	}catch(SQLException exp){
    		System.out.println(exp.getMessage());
    	}
    	return listLivre;
	}

	public List<Livre> search(String titre, String auteur) {
	    List<Livre> listLivre = new ArrayList<>();
	    PreparedStatement pst = null;
	    ResultSet rs = null;

	    String sql = "SELECT * FROM Livre WHERE titre LIKE ? AND auteur LIKE ?";

	    try {
	        pst = connection.prepareStatement(sql);
	        pst.setString(1, "%" + titre + "%");
	        pst.setString(2, "%" + auteur + "%");

	        System.out.println("Success executing the query");
	        rs = pst.executeQuery();

	        while (rs.next()) {
	            listLivre.add(new Livre(rs.getLong("code"), rs.getString("titre"), rs.getString("auteur"), rs.getLong("ISBN")));
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

	    return listLivre;
	}



}
