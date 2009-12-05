package com.sitereview.server.services;

import java.util.List;

import javax.jdo.PersistenceManager;

import com.sitereview.server.dao.PMF;
import com.sitereview.server.dao.Provider;

public class ProviderService {

	public static List<Provider> getAll(){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select from " + Provider.class.getName();
		return (List<Provider>) pm.newQuery(query).execute();
	}
	
}
