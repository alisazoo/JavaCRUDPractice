import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStatement {

    private static final String UPDATE_SQL = "UPDATE users SET name = ? WHERE id = ?";

    public void updateRecord() throws SQLException{

        System.out.println(UPDATE_SQL);
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL);){
            preparedStatement.setString(1, "Michel");
            preparedStatement.setInt(2,1);
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            JDBCUtils.printSQLException(e);
        }

    }

}
