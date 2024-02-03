package Emprunt;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class RetournerLivreHandler {
	IEmpruntDAO lDAO = new EmpruntDAOImpl();

	RetournerWindow listWindow = null;
	public RetournerLivreHandler(RetournerWindow list){
		this.listWindow=list;
	}
	public void setListDeleteWindow(RetournerWindow listWindow){
		this.listWindow=listWindow;
	}
	public void updateEmpruntDeleteWindows(){
		List<Emprunt> list = lDAO.getAll();
		listWindow.EmpruntsObservableList.addAll(list);

	}
	public void retournerClick(Emprunt l){
		lDAO.update(l.getId_emp());
	}
}
