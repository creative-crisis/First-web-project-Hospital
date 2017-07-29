package database.jdbc;
import java.sql.*;


public class DBConnection {

    private static final String url = "jdbc:postgresql://localhost:5432/Hospital";
    private static final String user = "postgres";
    private static final String password = "12345";
    private static final String driver = "org.postgresql.Driver";

    private static Connection getDBConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public static void workWithDB() throws SQLException {

        Connection connection = null;
        Statement statement = null;

        String createTable = "CREATE TABLE \"Doctors\"("
                + "doctor_id integer NOT NULL, "
                + "first_name character varying(20) NOT NULL, "
                + "last_name character varying(30) NOT NULL, "
                + "specialization integer NOT NULL, "
                + "employment_date character varying(10), "
                + "doctor_phone character varying(20), "
                + "doctor_email character varying(50), "
                + "PRIMARY KEY (doctor_id)"
                + ")";

        String insertTable = "INSERT INTO \"Doctors\" "
                + "(doctor_id, first_name, last_name, specialization) "
                + "VALUES"
                + "(21,'Lambert','Pearson', 4)";

        String updateTable = "UPDATE \"Doctors\" "
                + " SET specialization = 3 "
                + " WHERE doctor_id = 21";

        String deleteTable = "DELETE FROM \"Doctors\" WHERE doctor_id = 21";

        try {
            connection = getDBConnection();
            statement = connection.createStatement();
        //    statement.execute(createTable);
        //    statement.executeUpdate(insertTable);
        //    statement.execute(updateTable);
            statement.execute(deleteTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }

    }


    public static void selectRecords() throws SQLException {

        Connection dbConnection = null;
        Statement statement = null;

        String selectTable =
                "SELECT doctor_id, first_name, last_name FROM \"Doctors\" WHERE specialization = 2";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            ResultSet results = statement.executeQuery(selectTable);

            while (results.next()) {
                String id = results.getString("doctor_id");
                String fName = results.getString("first_name");
                String lName = results.getString("last_name");
                System.out.println(id + " " + fName + " " + lName);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }
    }


}
