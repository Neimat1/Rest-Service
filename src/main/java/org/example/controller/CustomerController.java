package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.model.Customer;
import org.example.service.CustomerService;

import java.util.List;
@Path("/")
public class CustomerController {
    CustomerService customerService = new CustomerService();


    @GET
    @Path("allCustomers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @DELETE
    @Path("deleteCustomer/{customerNationalID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCustomer(@PathParam("customerNationalID") String  customerNationalID){
        return customerService.deleteCustomer(customerNationalID);
    }


    @POST
    @Path("/addCustomer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCustomer(Customer customer) {

        return customerService.addCustomer(customer);
    }

    @PUT
    @Path("/updateCustomer/{nationalID}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response updateCustomerInfo( @PathParam("nationalID") String nationalID,Customer customer){
         return customerService.updateCustomer(nationalID,customer);
    }
}
