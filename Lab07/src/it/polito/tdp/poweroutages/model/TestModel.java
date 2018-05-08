package it.polito.tdp.poweroutages.model;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.db.PowerOutageDAO;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		System.out.println(model.getNercList());
	    List<Nerc> lista=new ArrayList<>(model.getNercList());
	    Nerc n=lista.get(15);
	    //PowerOutageDAO dao=new PowerOutageDAO();
	    //PoIdMap map=new PoIdMap();
	    //System.out.println(dao.getPO(n, map));
	    
	 for(PowerOutage pw:   model.getSequenza(n, 1, 10))
	 {
		 System.out.println(pw);
		 System.out.println((pw.getDataF()));
		 System.out.println((pw.getDataI()));
		 System.out.println(Duration.between(pw.getDataI(),pw.getDataF()).toHours());
		 
	 }
	    
	
		
		
	}
}
