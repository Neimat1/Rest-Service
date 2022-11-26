package org.example.dao;

import org.example.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerDAO {
    public static HashMap<String, Customer> customersMap = new HashMap<>();

    /*public CustomerDAO() {
        Customer customer = new Customer();
        customer.setFirstName("Neimat");
        customer.setLastName("Soliman");
        customer.setAge(22);
        customer.setNationalID("29912220103321");


        customersMap.put(customer.getNationalID(),customer);
    }

     */

    public Customer createCustomer(Customer customer){
        return customersMap.putIfAbsent(customer.getNationalID(),customer);
    }

    public List<Customer> getAllCustomers (){
        return new ArrayList<Customer>(customersMap.values());
    }

    public Customer deleteCustomer(String customerNationalID){
        return customersMap.remove(customerNationalID);
    }
    public boolean updateCustomerDetails(String nationalID , Customer customer){
        if(customer.getNationalID().equals(nationalID)){
            customersMap.put(nationalID,customer);
            return true;

        }
        else {
            return false;

        }

    }

}
