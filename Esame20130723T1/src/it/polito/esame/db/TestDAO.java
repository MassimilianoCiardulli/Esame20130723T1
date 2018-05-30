package it.polito.esame.db;

import it.polito.esame.dao.IscrittiDAO;

public class TestDAO {

	public static void main(String[] args) {

		IscrittiDAO dao = new IscrittiDAO();
		
		dao.getAllCorso();
	}

}
