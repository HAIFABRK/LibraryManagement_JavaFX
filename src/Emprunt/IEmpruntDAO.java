package Emprunt;

import java.util.List;

import Emprunt.Emprunt;
import application.IDAO;

public interface IEmpruntDAO extends IDAO{

	public void add(Emprunt l);
	public void update(long id);
	public List<Emprunt> getAll();	

	

}
