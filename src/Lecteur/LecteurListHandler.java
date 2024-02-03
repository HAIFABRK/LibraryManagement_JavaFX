package Lecteur;

import java.util.ArrayList;
import java.util.List;


public class LecteurListHandler {

	LecteurListeWindow listWindow = null;
	public LecteurListHandler(LecteurListeWindow listWindow){
		this.listWindow=listWindow;
	}
	public void setListWindow(LecteurListeWindow listWindow){
		this.listWindow=listWindow;
	}
	public void updateLecteurListWindows(){
		ILecteurDAO lDAO = new LecteurDAOImpl();
		List<Lecteur> list = lDAO.getAll();
		listWindow.LecteursObservableList.addAll(list);

	}
}
