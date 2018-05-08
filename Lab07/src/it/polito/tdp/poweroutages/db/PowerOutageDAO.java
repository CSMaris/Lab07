package it.polito.tdp.poweroutages.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import it.polito.tdp.poweroutages.model.Nerc;
import it.polito.tdp.poweroutages.model.PoIdMap;
import it.polito.tdp.poweroutages.model.PowerOutage;

public class PowerOutageDAO {

	public List<Nerc> getNercList() {

		String sql = "SELECT id, value FROM nerc";
		List<Nerc> nercList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Nerc n = new Nerc(res.getInt("id"), res.getString("value"));
				nercList.add(n);
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return nercList;
	}
	
	public List<PowerOutage> getPO(Nerc n, PoIdMap map)
	{
		String sql="select id, customers_affected, date_event_began, date_event_finished from poweroutages where nerc_id=? order by date_event_began";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, n.getId());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				PowerOutage po = new PowerOutage(rs.getInt("id"),
						rs.getInt("customers_affected"),
						(rs.getTimestamp("date_event_began")).toLocalDateTime(),
						(rs.getTimestamp("date_event_finished")).toLocalDateTime() ) ;
				
				n.getPO().add(map.get(po));//potevi non farlo è necessario solo per relazioni N:M
			}

			conn.close();
			return n.getPO();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
		
		
		
		
		
	}


