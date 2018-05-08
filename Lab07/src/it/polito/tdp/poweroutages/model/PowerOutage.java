package it.polito.tdp.poweroutages.model;

import java.time.LocalDateTime;
import java.util.*;

public class PowerOutage {
	
	private int id;
	private int customersAffected;
	private LocalDateTime dataI;
	private LocalDateTime dataF;
	
	public PowerOutage(int id, int customersAffected, LocalDateTime dataI, LocalDateTime dataF) {
		this.id = id;
		this.customersAffected = customersAffected;
		this.dataI = dataI;
		this.dataF = dataF;
	}

	public int getId() {
		return id;
	}

	public int getCustomersAffected() {
		return customersAffected;
	}

	public LocalDateTime getDataI() {
		return dataI;
	}

	public LocalDateTime getDataF() {
		return dataF;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PowerOutage other = (PowerOutage) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PowerOutage [id=" + id + ", customersAffected=" + customersAffected + ", dataI=" + dataI + ", dataF="
				+ dataF + "]";
	}

	
	
	
	
	
	
	

}
