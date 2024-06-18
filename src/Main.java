import java.sql.*;

public class Main {

    public static final String DB_URL = "jdbc:mysql://localhost/university";
    public static final String DB_USER= "root";
    public static final String DB_PASSWORD = "123";

    public static void main(String[] args) {

        Connection connect = null;


        try {
            connect = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            Statement statement = connect.createStatement();

            PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO employees (employee_name,employee_position,employee_salary) VALUES (?,?,?)");

            preparedStatement.setString(1,"Cemile Can");
            preparedStatement.setString(2,"Engineer");
            preparedStatement.setDouble(3,90000);
            preparedStatement.executeUpdate();

            preparedStatement.setString(1,"Alper Mudurlu");
            preparedStatement.setString(2,"Software");
            preparedStatement.setDouble(3,15000);
            preparedStatement.executeUpdate();

            preparedStatement.setString(1,"Nisa Nilal");
            preparedStatement.setString(2,"Sales");
            preparedStatement.setDouble(3,30000);
            preparedStatement.executeUpdate();

            preparedStatement.setString(1,"Hiloş Hell");
            preparedStatement.setString(2,"The old dragon");
            preparedStatement.setDouble(3,500);
            preparedStatement.executeUpdate();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
            System.out.println("  EMPLOYEE LIST");
            while(resultSet.next()) {
                System.out.println("------------------");
                System.out.println("EMPLOYEE ID: " + resultSet.getInt("employee_id"));
                System.out.println("EMPLOYEE NAME: " + resultSet.getString("employee_name"));
                System.out.println("EMPLOYEE POSTION: " + resultSet.getString("employee_position"));
                System.out.println("EMPLOYEE SALARY: " + resultSet.getDouble("employee_salary"));

            }
            preparedStatement.close();
            statement.close();
            connect.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
