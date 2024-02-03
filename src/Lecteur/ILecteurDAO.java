package Lecteur;

import java.util.List;
import application.IDAO;


public interface ILecteurDAO extends IDAO {
	public void add(Lecteur l);
	public List<Lecteur> getAll();
	public Lecteur getOne(long id);
	public List<Lecteur> getAll(String s);
	public void delete(long id);

}
