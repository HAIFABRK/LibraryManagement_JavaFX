package Lecteur;

import java.util.List;

public class ProgramIHMLecteur {

public static void main(String[] args){
	ILecteurDAO ldao = new LecteurDAOImpl();
	
	System.out.println("--------getAll()");
	List<Lecteur> list = ldao.getAll();
	for(Lecteur l:list)
		System.out.println(l);
	
	System.out.println("--------getOne()");
	Object Lecteur= ldao.getOne(1349);
		System.out.println(Lecteur);
		
		System.out.println("--------getAll()STRING");
		List<Lecteur> listS = ldao.getAll("HAIFA");
		for(Lecteur l:listS)
			System.out.println(l);
		
		System.out.println("--------delete()");
		ldao.delete(1);
		System.out.println("--------getOne()");
		Lecteur l= ldao.getOne(1);
		if(l!=null)	
			System.out.println(l);
		else 
			System.out.println("Lecteur non existant");
		
		
		Lecteur l1 = new Lecteur(0,"HAIFA", "BRIKI");
		System.out.println("-----add()");
		ldao.add(l1);
		System.out.println("--------getAllAfterAdd()");
		List<Lecteur> newlist = ldao.getAll();
		for(Lecteur ll:newlist)
			System.out.println(ll);
}
}
