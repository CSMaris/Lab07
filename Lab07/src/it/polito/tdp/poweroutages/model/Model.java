package it.polito.tdp.poweroutages.model;

import java.util.List;

import it.polito.tdp.poweroutages.db.PowerOutageDAO;

public class Model {

	PowerOutageDAO podao;
	PoIdMap map;
	Ricorsione ric;
	
	public Model() {
		podao = new PowerOutageDAO();
		map=new PoIdMap();
		ric=new Ricorsione();
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}
	
	
	public List<PowerOutage> getSequenza(Nerc nerc, int MAXY, int MAXH)
	{
		List<PowerOutage> lista=ric.getSequenzaMigliore(nerc, MAXY, MAXH);
		return lista;
		
	}

}
