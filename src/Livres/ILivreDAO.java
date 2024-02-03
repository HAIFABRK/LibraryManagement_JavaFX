package Livres;

import java.util.List;

import application.IDAO;

public interface ILivreDAO extends IDAO {
	public void add(Livre l);
	public List<Livre> getAll();
	public Livre getOne(long id);
	public List<Livre> getAll(String s);
	public void delete(long id);

}
