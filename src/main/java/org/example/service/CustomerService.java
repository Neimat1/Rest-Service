package org.example.service;

import jakarta.ws.rs.core.Response;
import org.example.dao.CustomerDAO;
import org.example.model.Customer;

import java.util.List;

public class CustomerService {
    CustomerDAO customerDAO = new CustomerDAO();

    public Response addCustomer(Customer customer)
    {
        try {
            if(customerDAO.createCustomer(customer)==null){
                return Response.status(200,"Added new customer").build();
            }else {
                return Response.status(400,"Can't add this customer").build();
            }
        }catch(Exception e){
            return Response.status(500,e.getMessage()).build();
        }
    }


    public List<Customer> getAllCustomers (){
        return customerDAO.getAllCustomers();
    }

    public Response deleteCustomer(String customerNationalID){
        try {
            if(customerDAO.deleteCustomer(customerNationalID)!=null){
                return Response.status(200,"Deleted successfully").build();
            }else {
                return Response.status(400,"Can't delete").build();
            }
        }catch(Exception e){
            return Response.status(500,e.getMessage()).build();
        }
    }
    public Response updateCustomer (String nationalID, Customer customer){
        try {
            if(customerDAO.updateCustomerDetails(nationalID,customer)){
                return Response.status(200,"Updated successfully").build();
            }else {
                return Response.status(400,"Can't update").build();
            }
        }catch(Exception e){
            return Response.status(500,e.getMessage()).build();
        }
    }
}
