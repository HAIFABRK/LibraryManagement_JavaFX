package Lecteur;

import java.util.List;
import java.util.stream.Collectors;


public class LecteurSearchHandler {

	ILecteurDAO lDAO = new LecteurDAOImpl();

	SearchLecteurWindow searchWindow = null;
	public LecteurSearchHandler(SearchLecteurWindow searchWindow){
		this.searchWindow=searchWindow;
	}
	public void setListSearchWindow(SearchLecteurWindow searchWindow) {
	    this.searchWindow = searchWindow;
	}

    public List<Lecteur> search(long cin, String nom) {
        List<Lecteur> allLecteurs = lDAO.getAll();

        List<Lecteur> searchResults = allLecteurs.stream()
                .filter(Lecteur ->
                        Lecteur.getCin()==cin &&
                        Lecteur.getNom().toLowerCase().contains(nom.toLowerCase()))
                .collect(Collectors.toList());

        return searchResults;
    }
}
