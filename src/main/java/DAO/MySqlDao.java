package DAO;

import Exceptions.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDao
{
    public Connection getConnection() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/shows_database";
        String username = "root";
        String password = "";
        Connection con = null;

        try
        {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println("Failed to find the driver class " + cnfe.getMessage());
        }
        catch(SQLException sqe)
        {
            System.out.println("Connection failed " + sqe.getMessage());
        }
        return con;
    }

    public void freeConnection(Connection con) throws DaoException
    {
        try
        {
            if(con != null)
            {
                con.close();
                con = null;
            }
        }
        catch(SQLException sqe)
        {
            System.out.println("Failied to free the connection: " + sqe.getMessage());
            System.exit(1);
        }
    }
}
