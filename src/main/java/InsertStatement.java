import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertStatement {

    private static final String INSERT_USERS_SQL =
            "INSERT INTO users " +
                    "(name, email, country, password) VALUES" +
                    " (?,?,?,?);";

    public static void main(String[] args) throws SQLException {
        InsertStatement insertUser = new InsertStatement();
        insertUser.insertRecod();
    }

    public void insertRecod() throws SQLException{
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
            preparedStatement.setString(1, "Tony");
            preparedStatement.setString(2, "tony@tony.com");
            preparedStatement.setString(3, "US");
            preparedStatement.setString(4, "password");
            System.out.println(INSERT_USERS_SQL);
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            JDBCUtils.printSQLException(e);
        }


    }
}
