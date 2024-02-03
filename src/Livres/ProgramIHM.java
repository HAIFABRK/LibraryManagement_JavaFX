package Livres;

import java.util.List;

public class ProgramIHM {
public static void main(String[] args){
	ILivreDAO ldao = new LivreDAOImpl();
	
	System.out.println("--------getAll()");
	List<Livre> list = ldao.getAll();
	for(Livre l:list)
		System.out.println(l);
	
	System.out.println("--------getOne()");
	Object livre= ldao.getOne(3);
		System.out.println(livre);
		
		System.out.println("--------getAll()STRING");
		List<Livre> listS = ldao.getAll("VICTOR");
		for(Livre l:listS)
			System.out.println(l);
		
		System.out.println("--------delete()");
		ldao.delete(1);
		System.out.println("--------getOne()");
		Livre l= ldao.getOne(1);
		if(l!=null)	
			System.out.println(l);
		else 
			System.out.println("livre non existant");
		
		
		Livre l1 = new Livre(0, "l'etranger", "Albert Camus", 56);
		System.out.println("-----add()");
		ldao.add(l1);
		System.out.println("--------getAllAfterAdd()");
		List<Livre> newlist = ldao.getAll();
		for(Livre ll:newlist)
			System.out.println(ll);
}
}
