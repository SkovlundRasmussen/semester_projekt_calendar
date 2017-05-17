package Controller;

import DataLayer.CustomerHandler;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jamie L. Ramsgaard on 5/16/2017.
 */
public class Customers {

        private List getCustomerList(){
            List<User> customerList = new LinkedList<>();

            return customerList;
        }

        public void newCustomer(String firstName, String lastName, String phoneNumber)
        {
            CustomerHandler customerHandler = new CustomerHandler();

            customerHandler.newCustomer(firstName, lastName, phoneNumber);
        }
}
