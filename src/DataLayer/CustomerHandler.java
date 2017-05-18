package DataLayer;

import java.sql.*;

public class CustomerHandler {
    DatabaseHandler databaseHandler = new DatabaseHandler();

    public void newCustomer(String firstName, String lastName, String phoneNumber)
    {
        PreparedStatement preparedStatement = null;
        Connection conn = null;

        String sql = "INSERT INTO customers(customer_first_name, customer_last_name, phone_nr) VALUES (?, ?, ?)";

        try{
        conn = databaseHandler.getConnection();

        preparedStatement =	conn.prepareStatement(sql);

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, phoneNumber);

            preparedStatement.executeUpdate();

            System.out.println("UPDATE");
            preparedStatement.close();
            conn.close();
        }

       catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            databaseHandler.sqlEx(preparedStatement, conn);
        }
    }


}



