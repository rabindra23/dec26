package com.masai.main.EMUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtils {

	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("dec26");
	}
	
	public static EntityManager provideEntityManager() {
		return emf.createEntityManager();
	}
}
