package DAO.showdao;

import DTO.Shows;
import Exceptions.DaoException;

import java.util.List;

public interface ShowDaoInterface
{
    public List<Shows> findAllShows() throws DaoException;
    public String findAllShowsJson() throws DaoException;
}
