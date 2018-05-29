
package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Example;


/**
 * <h1>The Class ProcedureDAO.</h1>
 *
 * @author Antoine MOHR antoine.mohr@viacesi.fr
 * @version 1.0
 */
	
public abstract class ProcedureDAO extends AbstractDAO {

    /** The sql example by id. */
    private static String sqlgetLevelByID   = "{call getLevelByID(?)}";

    
   
    
    /** The element column index. */
    private static int    elementColumnIndex  = 2;
    
    /** The cooX column index. */
    private static int    cooXColumnIndex    = 3;
    
    /** The cooY column index. */
    private static int    cooYColumnIndex    = 4;

   

    /**
     * Gets the example by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    
    
    /*
    public static Example getLevelyId(final int id) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlgetLevelByID);
        Example level = null;
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                level = new Example(result.getInt(idColumnIndex), result.getString(nameColumnIndex));
            }
            result.close();
        }
        return level;
    }
    /*
    
    /**
     * Gets the all examples.
     *
     * @return the all examples
     * @throws SQLException
     *             the SQL exception
     */
    public static List<Example> getLevelByID(final int id) throws SQLException {
        final ArrayList<Example> levels = new ArrayList<Example>();
        final CallableStatement callStatement = prepareCall(sqlgetLevelByID);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();

            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
                levels.add(new Example(result.getString(elementColumnIndex), result.getInt(cooXColumnIndex), result.getInt(cooYColumnIndex)));
            }
            result.close();
        }
        return levels;
    }
    
    
    
    /**
     * Gets the example by name.
     *
     * @param name
     *            the name
     * @return the example by name
     * @throws SQLException
     *             the SQL exception
     
    public static Example getExampleByName(final String name) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlExampleByName);
        Example example = null;

        callStatement.setString(1, name);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                example = new Example(result.getInt(idColumnIndex), result.getString(nameColumnIndex));
            }
            result.close();
        }
        return example;
    }
    */
    
    
   
}

