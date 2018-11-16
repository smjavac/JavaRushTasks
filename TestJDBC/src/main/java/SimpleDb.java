import java.sql.*;

public class SimpleDb {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";

    static final String USER = "postgres";
    static final String PASSWORD = "5099";


    public static void main(String[] args) {
        String sql;
        sql = "CREATE TABLE testauto (id serial not null , model varchar(50), body varchar(50) not null)";
//        sql = "select * from auto";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            Class.forName(JDBC_DRIVER);
//            System.out.println("\nautomobiles:");
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String model = resultSet.getString("model");
//                String body = resultSet.getString("body");
//                System.out.println("\n================\n");
//                System.out.println("id: " + id);
//                System.out.println("model: " + model);
//                System.out.println("body: " + body);
//            }
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }
    }
}
