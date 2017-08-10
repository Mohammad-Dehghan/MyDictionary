package kernel.db;

import java.sql.*;

/**
 *
 * @author Mohammad Dehghan
 */
public class DB {

    private String database = "dic.db";
    private Connection con = null;
    public Statement statement = null;
    private static DB db;

    public static DB getDB() {
        if (db == null) {
            db = new DB();
        }
        return db;
    }

    private DB() {
        try {
            // load required libraries
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + database);
            statement = con.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            //
        }
    }
}
