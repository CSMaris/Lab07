package it.polito.tdp.poweroutages.model;

import java.util.HashMap;
import java.util.Map;



public class PoIdMap {
private Map<Integer, PowerOutage> map;
	
	public PoIdMap() {
		map = new HashMap<>();
	}
	
	public PowerOutage  get(Integer id) {
		return map.get(id);
	}
	
	public PowerOutage get(PowerOutage po) {
		PowerOutage old = map.get(po.getId());
		if (old == null) {
			map.put(po.getId(), po);
			return po;
		}
		return old;
	}
	
	public void put(Integer id, PowerOutage po) {
		map.put(id, po);
	}

}
