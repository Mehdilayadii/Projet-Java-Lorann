package model.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class LorannBDDConnectorTest {

    private LorannBDDConnector connector;

    @Before
    public void setUp() throws Exception {
        this.connector = new LorannBDDConnector();
    }

    /**
     *
     */
    @Test
    public void executeQuery() {
        try {
            Statement statement = connector.getConnection().createStatement();
            ResultSet resultEspected = statement.executeQuery("SELECT * FROM levels");
            String resultStringEspected = "";

            while (resultEspected.next()) {
                resultStringEspected += resultEspected.getString(1);
            }

            ResultSet result = connector.executeQuery("SELECT * FROM levels");
            String resultString = "";

            while (result.next()) {
                resultString += result.getString(1);
            }

            assertEquals(resultStringEspected,resultString);

        } catch (final SQLException e) {
            e.printStackTrace();
            fail("May be credential problem.");
        }
    }

    @Test
    public void prepareCall() {
    }

    @Test
    public void executeUpdate() {
    }
}