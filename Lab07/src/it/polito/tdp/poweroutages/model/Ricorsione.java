package it.polito.tdp.poweroutages.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.poweroutages.db.PowerOutageDAO;

public class Ricorsione {
	private List<PowerOutage> soluzione;
	private PowerOutageDAO dao=new PowerOutageDAO();
	private PoIdMap map=new PoIdMap();
	private int MAXH;
	private int MAXY;
	
	public List<PowerOutage> getSequenzaMigliore(Nerc nerc, int MAXY, int MAXH)
	{
		
		List<PowerOutage> parziale=new LinkedList<>();
		List<PowerOutage> NERClist=dao.getPO(nerc,map);
		this.MAXH=MAXH;
		this.MAXY=MAXY;
		recursive(parziale, NERClist);
		
		
		return soluzione;
	}
	
	
	private int max=Integer.MIN_VALUE;
	
	private void recursive(List<PowerOutage> parziale, List<PowerOutage> NERC)
	{
		for(PowerOutage pw: NERC)
		{
			parziale.add(pw);
			
			if(checkMax(parziale))	
			{
				if(MaxControl(parziale))
					soluzione=new ArrayList<PowerOutage>(parziale);
				

			List<PowerOutage> n=new ArrayList<>(NERC);
			n.remove(pw);
			recursive(parziale,n);
			}
			
			parziale.remove(pw);
			
			
		}
		
			
	}

	private boolean checkMax(List<PowerOutage> parziale) {
		int count=1;
		for(int i=0;i<parziale.size();i++)
		{
		if(i!=0)
		{
			if(parziale.get(i).getDataI().getYear() != parziale.get(i-1).getDataI().getYear())
				count++;
		}
		}
		if(count>MAXY)
			return false;
		
		
		double sum=0;
		for(PowerOutage pw:parziale)
		{
		LocalDateTime f=pw.getDataF();
		LocalDateTime i=pw.getDataI();
		
		long diff=Duration.between(i,f).toMinutes();
		sum+=diff;
		}
		if(sum>(MAXH*60))
			return false;
		
		
		return true;
	}

	private boolean MaxControl(List<PowerOutage> partial) {
		int sum=0;
		for(PowerOutage pw: partial)
		sum+=pw.getCustomersAffected();	
		
		if(sum>max)
		{
			max=sum;
			return true;
		}
		return false;
	}
}
