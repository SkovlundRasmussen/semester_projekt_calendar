package Controller;

import DataLayer.CustomerHandler;

import java.util.LinkedList;
import java.util.List;

public class Customers {

        public List<Customer> getCustomers() // Retunere en liste af Customer objekter
        {
            CustomerHandler customerHandler = new CustomerHandler();
            List<Customer> customers;

            customers = customerHandler.getCustomers();
            return customers;
        }
        //Kristain, Nichlas

        public Customer getCustomer(String customerId) // Returnere et Customer Objekt
        {
            CustomerHandler customerHandler = new CustomerHandler();
            Customer customer = customerHandler.getCustomer(customerId);
            return customer;
        }
        //Kristian

        public void newCustomer(String firstName, String lastName, String phoneNumber)
        {
            boolean error = false;
            CustomerHandler customerHandler = new CustomerHandler();

            if (ErrorHandler.IsAValidNumber(phoneNumber))
            {
                error = true;
            }
            if (ErrorHandler.IsAValidName(firstName))
            {
                error = true;
            }
            if (ErrorHandler.IsAValidName(lastName))
            {
                error = true;
            }
            if (!error)
            {
                customerHandler.newCustomer(firstName, lastName, phoneNumber);
            }
        }


}
