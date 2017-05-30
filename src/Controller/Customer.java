package Controller;

/**
 * Created by Jamie L. Ramsgaard on 5/16/2017.
 */
public class Customer {
    private int customerID;
    private String customerName;
    private String customerLastName;
    private String customerPhoneNumber;


    public Customer(int customerID, String customerName, String customerLastName, String customerPhoneNumber)
    {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerLastName = customerLastName;
        this.customerPhoneNumber = customerPhoneNumber;
    }


    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerLastname() {
        return customerLastName;
    }

    public void setCustomerLastname(String customerLastname) {
        this.customerLastName = this.customerLastName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
