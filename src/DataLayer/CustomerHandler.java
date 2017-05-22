package DataLayer;

import Controller.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerHandler
{
    DatabaseHandler databaseHandler = new DatabaseHandler();

    public void editCustomer(String firstName, String lastName, String phoneNumber, String id)
    {
        PreparedStatement preparedStatement = null;

        Connection conn = null;

        String sql = "UPDATE customers SET customer_first_name = ?, customer_last_name = ?, phone_nr = ? WHERE customer_id = ?;";


        try
        {
            conn = databaseHandler.getConnection();

            preparedStatement =	conn.prepareStatement(sql);

            //prepareStatements(firstName, lastName, phoneNumber, preparedStatement);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setString(4, id);

            preparedStatement.executeUpdate();

            System.out.println("UPDATE");
            preparedStatement.close();
            conn.close();
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }

        finally
        {
            databaseHandler.sqlEx(preparedStatement, conn);
        }
    }


    public void newCustomer(String firstName, String lastName, String phoneNumber)
    {
        PreparedStatement preparedStatement = null;
        Connection conn = null;

        String sql = "INSERT INTO customers(customer_first_name, customer_last_name, phone_nr) VALUES (?, ?, ?)";

        try
        {
        conn = databaseHandler.getConnection();

        preparedStatement =	conn.prepareStatement(sql);

            prepareStatements(firstName, lastName, phoneNumber, preparedStatement);

            preparedStatement.executeUpdate();

            System.out.println("UPDATE");
            preparedStatement.close();
            conn.close();
        }

       catch (SQLException e)
       {
           e.printStackTrace();
       }

        finally
        {
            databaseHandler.sqlEx(preparedStatement, conn);
        }
    }

    private void prepareStatements(String firstName, String lastName, String phoneNumber, PreparedStatement preparedStatement) throws SQLException
    {
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, phoneNumber);
    }

    public List<Customer> getCustomers() {
        PreparedStatement preparedStatement = null;
        Statement smtp = null;
        ResultSet rs = null;
        Connection conn = null;

        int id;
        String first_name;
        String last_name;
        String phone_nr;

        List<Customer> customers = new ArrayList<Customer>();

        String sql = "SELECT * FROM customers"; // WHERE SESSION USER_ID = ?

        try {

            conn = databaseHandler.getConnection();

            smtp = conn.createStatement();
            rs = smtp.executeQuery(sql);

            while (rs.next()) // Laver et nyt Customer objekt for hvert row i DB. Lager objekterne i en liste
            {
                id = rs.getInt("customer_id");
                first_name = rs.getString("customer_first_name");
                last_name = rs.getString("customer_last_name");
                phone_nr = rs.getString("phone_nr");
                Customer customer = new Customer(id, first_name, last_name, phone_nr);

                customers.add(customer);
            }
            smtp.close();
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            databaseHandler.sqlEx(preparedStatement, conn);
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
        }
        //Slet senere
        return customers;
    }
    // Kristian

    public Customer getCustomer(String customerId)
    {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Connection conn = null;

        Customer customer = null;

        int id;
        String first_name;
        String last_name;
        String phone_nr;


        String sql = "SELECT * FROM customers WHERE customer_id=?";


        try{
            conn = databaseHandler.getConnection();

            preparedStatement =	conn.prepareStatement(sql);
            preparedStatement.setString(1, customerId);
            rs = preparedStatement.executeQuery();

            if(rs.next()) // Kommer der et hit ud fra DB bliver der lavet et nyt Customer Objekt.
            {
                id = rs.getInt("customer_id");
                first_name = rs.getString("customer_first_name");
                last_name = rs.getString("customer_last_name");
                phone_nr = rs.getString("phone_nr");

                customer = new Customer(id, first_name, last_name, phone_nr);

                // Eksekvere return før finally?
                return customer;
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            databaseHandler.sqlEx(preparedStatement, conn);
            if (rs != null) try { rs.close(); } catch (SQLException logOrIgnore) {}
        }
        return customer;
    }
    // Kristian

}




