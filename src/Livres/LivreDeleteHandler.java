
package Livres;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class LivreDeleteHandler {
	ILivreDAO lDAO = new LivreDAOImpl();

	DeleteLivreFenetre listWindowDelete = null;
	public LivreDeleteHandler(DeleteLivreFenetre list){
		this.listWindowDelete=list;
	}
	public void setListDeleteWindow(DeleteLivreFenetre listWindow){
		this.listWindowDelete=listWindow;
	}
	public void updateLivreDeleteWindows(){
		List<Livre> list = lDAO.getAll();
		listWindowDelete.livresObservableList.addAll(list);

	}
	public void deleteClick(Livre l){
		lDAO.delete(l.getCode());
	}
}
