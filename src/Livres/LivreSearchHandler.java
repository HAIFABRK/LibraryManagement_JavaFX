package Livres;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LivreSearchHandler {
	ILivreDAO lDAO = new LivreDAOImpl();

	SearchLivreFenetre searchWindow = null;
	public LivreSearchHandler(SearchLivreFenetre searchWindow){
		this.searchWindow=searchWindow;
	}
	public void setListSearchWindow(SearchLivreFenetre searchWindow) {
	    this.searchWindow = searchWindow;
	}

	public List<Livre> search(String titre, String auteur) {
	    try {
	        List<Livre> allLivres = lDAO.getAll();

	        List<Livre> searchResults = allLivres.stream()
	                .filter(livre ->
	                        livre.getTitre().toLowerCase().contains(titre.toLowerCase()) &&
	                        livre.getAuteur().toLowerCase().contains(auteur.toLowerCase()))
	                .collect(Collectors.toList());

	        return searchResults;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return Collections.emptyList(); 
	    }
	}

}
