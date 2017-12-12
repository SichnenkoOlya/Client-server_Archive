package by.bsuir.archive.dao;

import by.bsuir.archive.dao.impl.DAOMatterImpl;

public class DAOFactory {

	private static final DAOFactory factory = new DAOFactory();

	private final DAOMatter matterDAO = new DAOMatterImpl();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return factory;
	}

	public DAOMatter getMatterDAO() {
		return matterDAO;
	}
}