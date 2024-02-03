package Livres;

import java.util.ArrayList;
import java.util.List;

public class LivreListHandler {
	LivreListeFenetre listWindow = null;
	public LivreListHandler(LivreListeFenetre listWindow){
		this.listWindow=listWindow;
	}
	public void setListWindow(LivreListeFenetre listWindow){
		this.listWindow=listWindow;
	}
	public void updateLivreListWindows(){
		ILivreDAO lDAO = new LivreDAOImpl();
		List<Livre> list = lDAO.getAll();
		listWindow.livresObservableList.addAll(list);

	}
}
