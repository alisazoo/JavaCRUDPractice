import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStatement {

    private static final String DELETE_SQL = "DELETE FROM users WHERE id = 1";

    public static void deleteRecord() throws SQLException{
        System.out.println(DELETE_SQL);
        try(Connection connection = JDBCUtils.getConnection();
            Statement statement = connection.createStatement();){
            int result = statement.executeUpdate(DELETE_SQL);
            System.out.println("Number of records affected:: " + result);
        } catch(SQLException e){
            JDBCUtils.printSQLException(e);
        }
    }
}
