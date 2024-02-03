package Lecteur;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LecteurDeleteHandler {

	ILecteurDAO lDAO = new LecteurDAOImpl();

	DeleteLecteurWindow listWindowDelete = null;
	public LecteurDeleteHandler(DeleteLecteurWindow list){
		this.listWindowDelete=list;
	}
	public void setListDeleteWindow(DeleteLecteurWindow listWindow){
		this.listWindowDelete=listWindow;
	}
	public void updateLecteurDeleteWindows(){
		List<Lecteur> list = lDAO.getAll();
		listWindowDelete.LecteursObservableList.addAll(list);

	}
	public void deleteClick(Lecteur l){
		lDAO.delete(l.getCin());
	}
}
