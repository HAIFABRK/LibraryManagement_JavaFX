package Lecteur;

public class Lecteur {
		private long cin;
		private String nom;
		private String prenom;


	public Lecteur(String nom,String prenom){
		this.nom=nom;
		this.prenom=prenom;
	}
	public Lecteur(long cin) {
		this.cin = cin;
	

	}
		public Lecteur(long cin, String nom, String prenom) {
			super();
			this.cin = cin;
			this.nom = nom;
			this.prenom = prenom;

		}
		  @Override
			public String toString() {
				return "Lecteur [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + "]" ;
			}
		public long getCin() {
			return cin;
		}
		public void setCin(long cin) {
			this.cin = cin;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		
	

}
