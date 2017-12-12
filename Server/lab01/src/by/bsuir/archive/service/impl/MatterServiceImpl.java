package by.bsuir.archive.service.impl;

import by.bsuir.archive.dao.DAOFactory;
import by.bsuir.archive.dao.DAOMatter;
import by.bsuir.archive.dao.exception.DAOException;
import by.bsuir.archive.domain.Matter;
import by.bsuir.archive.service.MatterService;
import by.bsuir.archive.service.exception.ServiceException;

public class MatterServiceImpl implements MatterService {

	@Override
	public void createMatter(String surname, String name, int age, String univer, int numberOfGroup)
			throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		DAOMatter matterDAO = daoFactory.getMatterDAO();

		try {
			matterDAO.createMatter(surname, name, age, univer, numberOfGroup);

		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public String findMatter(int idMatter) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		DAOMatter matterDAO = daoFactory.getMatterDAO();

		try {
			Matter matter = matterDAO.findMatter(idMatter);
			return matter.toString();

		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void changeMatter(int idMatter, String newSurname, String newName, int newAge, String newUniver,
			int newNumberOfGroup) throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		DAOMatter matterDAO = daoFactory.getMatterDAO();

		try {
			matterDAO.changeMatter(idMatter, newSurname, newName, newAge, newUniver, newNumberOfGroup);

		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

}
