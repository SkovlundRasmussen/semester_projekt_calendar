package Controller;

/**
 * Created by Jamie L. Ramsgaard on 5/16/2017.
 */
public class Customer {
    private int customerID; //!
    private String customerName; //!
    private String customerLastname;
    private String customerPhoneNumber;


    public Customer(int customerID, String customerName, String customerLastname, String customerPhoneNumber)
    {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerLastname = customerLastname;
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
        return customerLastname;
    }

    public void setCustomerLastname(String customerLastname) {
        this.customerLastname = customerLastname;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
