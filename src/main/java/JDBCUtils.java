import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {

    private static String url = "jdbc:postgresql://localhost:5432/crud";
    private static String username = "postgres";
    private static String password = "arisa";

//    public static void main(String[] args) {
//        getConnection();
//    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void printSQLException(SQLException ex){
        for(Throwable e: ex){
            if(e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQL state: " + ( ( (SQLException) e).getSQLState() ) );
                System.err.println("Error code: " + ( ( (SQLException) e).getErrorCode() ) );
                System.err.println("Message: " +  e.getMessage() );
                Throwable t = ex.getCause();
                while(t!=null){
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
