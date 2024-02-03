package Livres;

public class Livre {
	  private long code ;
	  private long ISBN;
	  private long total ;
	  private static long Nb_livres=0;
	  private String titre;
 	  private String auteur;
	  public Livre() {  
		  code=++Nb_livres; }
	  
	  public Livre(String titre){
		  this.titre=titre;
	  }
	  public Livre(long code){
		  this.code=code;
	  }
	  public Livre(long code,String titre,String auteur, long ISBN ) {
		  this.titre=titre;
		  this.auteur=auteur;
		  this.ISBN=ISBN;
		  this.code=code;
	  }
	  
	



  @Override
	public String toString() {
		return "Livre [code=" + code + ", ISBN=" + ISBN + ", total=" + total
				+ ", titre=" + titre + ", auteur=" + auteur + "]";
	}


public boolean equals(Livre livre) {
     
      return this.getTitre().equals(livre.getTitre()) && this.getAuteur().equals(livre.getAuteur());
  }
  @Override
  public int hashCode() {
      return titre.hashCode() + auteur.hashCode();
  }

	
	public long getCode() {
		return this.code;
	}
	
	public String getAuteur() {
		return this.auteur ;
	}

	public String getTitre() {
		return this.titre ;
	}
	
	public long getISBN() {
		return this.ISBN ;
	}
	
	
	public void setAuteur(String auteur) {
		this.auteur=auteur; 
	}
	
	public void setTitre(String titre) {
		this.titre=titre; 
	}
	
	public void setCode(long code) {
		this.code=code; 
	}
	public long getTotal() {
		return total ;
	}
	
	
	public void setTotal(long total) {
		this.total=total; 
	}
	  
}