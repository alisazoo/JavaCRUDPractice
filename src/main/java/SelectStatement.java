import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectStatement {

    private static final String SELECT_SQL =
            "SELECT id, name, email, country, password FROM users WHERE id = ?";

    public static void selectItem() {
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SQL);){
           preparedStatement.setInt(1, 1);
            System.out.println(preparedStatement);

            ResultSet rset = preparedStatement.executeQuery();

            while(rset.next()){
                int id = rset.getInt("id");
                String name = rset.getString("name");
                String email = rset.getString("email");
                String country = rset.getString("country");
                String password = rset.getString("password");
                System.out.println(id + ", " + name + ", " + email + ", " + country + ", " + password);
            }

        } catch(SQLException e){
            JDBCUtils.printSQLException(e);

        }
    }

}
