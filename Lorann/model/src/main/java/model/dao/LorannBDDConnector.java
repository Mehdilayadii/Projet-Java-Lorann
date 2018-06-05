package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <h1>The Class LorannBDDConnector.</h1>
 *
 * @author Group 13
 * @version 2.0
 */	

public final class LorannBDDConnector {

					/**** ATTRIBUTE ****/
    /** The instance. */
    private static LorannBDDConnector instance;

    /** The login. */
    private static String user     = "root";

    /** The password. */
    private static String password = "";

    /** The url. */
    private static String url      = "jdbc:mysql://localhost/lorann?useSSL=false&serverTimezone=UTC";

    /** The connection. */
    private Connection connection;

    /** The statement. */
    private Statement statement;

    				/**** CONSTRUCTOR ****/
    /**
     * Instantiates a new BDD connector.
     */
    public LorannBDDConnector() {
			this.open();
    }

    				/**** METHODS ****/
    /**
     * Gets the single instance of the BDDConnector.
     *
     * @return single instance of the BDDConnector
     */
    public static LorannBDDConnector getInstance() {
        if (instance == null) {
            setInstance(new LorannBDDConnector());
        }
        return instance;
    }

    /**
     * Sets the instance.
     *
     * @param instance
     *            the new instance
     */
    private static void setInstance(final LorannBDDConnector instance) {
        LorannBDDConnector.instance = instance;
    }

    /**
     * Open.
     *
     * @return true, if successful
     */
    private boolean open() {
        try {
        	System.out.print("Trying to connect to database 'lorann'... \n");
            this.connection = DriverManager.getConnection(LorannBDDConnector.url, LorannBDDConnector.user,
                    LorannBDDConnector.password);
            this.statement = this.connection.createStatement();
            System.out.print("Successfully connected !\n");
            return true;
        } catch (final SQLException exception) {
        	System.out.print("Error ! :(  \n\nCheck these errors :\n");
            exception.printStackTrace();
        }
        return false;
    }

    /**
     * Execute query.
     *
     * @param query
     *            the query
     * @return the result set
     */
    public ResultSet executeQuery(final String query) {
        try {
            return this.getStatement().executeQuery(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Prepare call.
     *
     * @param query
     *            the query
     * @return the java.sql. callable statement
     */
    public java.sql.CallableStatement prepareCall(final String query) {
        try {
            return this.getConnection().prepareCall(query);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Execute update.
     *
     * @param query
     *            the query
     * @return the int
     */
    public int executeUpdate(final String query) {
        try {
            return this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    				/**** GETTERS and SETTERS ****/

    /**
     * Gets the connection.
     *
     * @return the connection
     */
    public Connection getConnection() {
        return this.connection;
    }

    /**
     * Sets the connection.
     *
     * @param connection
     *            the new connection
     */
    public void setConnection(final Connection connection) {
        this.connection = connection;
    }

    /**
     * Gets the statement.
     *
     * @return the statement
     */
    public Statement getStatement() {
        return this.statement;
    }

    /**
     * Sets the statement.
     *
     * @param statement
     *            the new statement
     */
    public void setStatement(final Statement statement) {
        this.statement = statement;
    }

}
