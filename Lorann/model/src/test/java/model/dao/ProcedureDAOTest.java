package model.dao;

import model.DatabaseMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProcedureDAOTest {

    /**
     * Check that getLevelByID return an ArrayList, if null test will fail.
     */
    @Test
    public void getLevelByID() {
        try {
            assertEquals(ProcedureDAO.getLevelByID(1).getClass(),ArrayList.class);
        } catch (SQLException e) {
            fail("Maybe credential mistake.");
            e.printStackTrace();
        }
    }
}