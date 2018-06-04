
package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DatabaseMap;


/**
 * <h1>The Class ProcedureDAO.</h1>
 *
 * @author Groupe 13
 * @version 2.0
 */
	

public abstract class ProcedureDAO extends AbstractDAO {

    /** String which contain sql call to procedure 'getLevelByID'  */
    private static String sqlgetLevelByID   = "{call getLevelByID(?)}";


   //
    
    /** The element column index. */
    private static int    elementColumnIndex  = 2;
    
    /** The cooX column index. */
    private static int    cooXColumnIndex    = 3;
    
    /** The cooY column index. */
    private static int    cooYColumnIndex    = 4;

   

    /**
     * Gets the map 
     *
     *@param id ID of the map
     * @return a list of elements of Example type(Element, X, Y)
     * @throws SQLException
     *             the SQL exception
     */
   public static List<DatabaseMap> getLevelByID(final int id) throws SQLException {
    	final ArrayList<DatabaseMap> levels = new ArrayList<DatabaseMap>();
        final CallableStatement callStatement = prepareCall(sqlgetLevelByID);
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();

            for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {
            	
            	//System.out.print(result.getString(elementColumnIndex)+"\n");
                levels.add(new DatabaseMap(result.getString(elementColumnIndex), result.getInt(cooXColumnIndex), result.getInt(cooYColumnIndex)));
            }
            result.close();
        }
        return levels;
    }
    
    
  
    
    
   
}

