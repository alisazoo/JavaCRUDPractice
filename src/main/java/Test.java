import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException {

        // Update statement
        UpdateStatement updateStatement = new UpdateStatement();
        updateStatement.updateRecord();

        // Select statement
        SelectStatement.selectItem();

        // Delete statement
        DeleteStatement.deleteRecord();

        // Select statement
        SelectStatement.selectItem();
    }
}
