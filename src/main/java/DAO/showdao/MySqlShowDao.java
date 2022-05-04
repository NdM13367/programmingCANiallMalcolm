package DAO.showdao;

import DAO.MySqlDao;
import DTO.Shows;
import Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlShowDao extends MySqlDao implements ShowDaoInterface
{
    public List<Shows> findAllShows() throws DaoException
    {
        {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            List<Shows> shows = new ArrayList<>();

            try
            {
                //Get a connection to the database
                con = this.getConnection();
                String query = "SELECT * FROM shows";
                ps = con.prepareStatement(query);

                //Use the prepared statement to execute the sql
                rs = ps.executeQuery();

                while (rs.next())
                {
                    int SHOWS_ID = rs.getInt("shows_id");
                    String name = rs.getString("name");
                    int year = rs.getInt("year");
                    String genre = rs.getString("genre");
                    String studio = rs.getString("studio");
                    int yourScore = rs.getInt("your_score");
                    int averageScore = rs.getInt("average_score");
                    int noOfReviews = rs.getInt("no_of_reviews");

                    Shows show = new Shows(SHOWS_ID, name, year, genre, studio, yourScore, averageScore, noOfReviews);

                    shows.add(show);
                }
            } catch (SQLException sqe)
            {
                throw new DaoException("findAllTrains() " + sqe.getMessage());
            } finally
            {
                try
                {
                    if (rs != null)
                    {
                        rs.close();
                    }
                    if (ps != null)
                    {
                        ps.close();
                    }
                    if (con != null)
                    {

                        freeConnection(con);
                    }
                } catch (SQLException sqe)
                {
                    throw new DaoException("findAllTrains() " + sqe.getMessage());
                }
            }

            return shows;
        }
    }

    @Override
    public String findAllShowsJson() throws DaoException {
        return null;
    }
}
