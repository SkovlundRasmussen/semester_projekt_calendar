package Controller;

import DataLayer.CustomerHandler;

import java.util.ArrayList;
import java.util.List;

public class Customers {

        public List<Customer> getCustomers(){
            CustomerHandler customerHandler = new CustomerHandler();
            List<Customer> customers = new ArrayList<Customer>();

            customers = customerHandler.getCustomers();
            return customers;
        }

        public void newCustomer(String firstName, String lastName, String phoneNumber)
        {
            CustomerHandler customerHandler = new CustomerHandler();

            customerHandler.newCustomer(firstName, lastName, phoneNumber);
        }


}
