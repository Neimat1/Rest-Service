package org.example.client;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import jakarta.ws.rs.client.Entity;
import org.example.model.Customer;

import javax.ws.rs.core.MediaType;


public class RestClient {

    public static void main(String[] args) {
        String url = "http://localhost:8080/RestServiceTask/webapi/";
        Customer customer1 = new Customer("Neimo","Soliman",22,"29912");
        RestClient client = new RestClient();
        client.printOutput(client.updateCustomer(url+"updateCustomer/29912",customer1));
        client.printOutput(client.getAllCustomers(url+"allCustomers"));
    }
    public   void printOutput(String output){
        System.out.println("Output received from Rest service ....");
        System.out.println(output);
    }
    public String addCustomer(String url, Customer customer){
        String output = "";
        try {
            Client client = Client.create();
            WebResource webResource = client.resource(url);
            ObjectMapper mapper = new ObjectMapper();
            String customerAsJsonString = mapper.writeValueAsString(customer);
            ClientResponse clientResponse = webResource
                    .type(MediaType.APPLICATION_JSON)
                    .post(ClientResponse.class,customerAsJsonString);

            if(clientResponse.getStatus()!=200){
                throw new RuntimeException("Request Processing Failed : HTTP error code : " + clientResponse.getStatus());
            }
            output = clientResponse.getEntity(String.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return output;
    }
    public String updateCustomer(String url,Customer customer){
        String output = "";
        try {
            Client client = Client.create();
            WebResource webResource = client.resource(url);
            ObjectMapper mapper = new ObjectMapper();
            String customerAsJsonString = mapper.writeValueAsString(customer);
            ClientResponse clientResponse = webResource
                    .type("application/json").put(ClientResponse.class,customerAsJsonString);

            if(clientResponse.getStatus()!=200){
                throw new RuntimeException("Request Processing Failed : HTTP error code : " + clientResponse.getStatus());
            }
            output = clientResponse.getEntity(String.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return output;
    }
    public String deleteCustomer(String url){
        String output = "";
        try {
            Client client = Client.create();
            WebResource webResource = client.resource(url);
            ClientResponse response = webResource
                    .type(MediaType.APPLICATION_JSON)
                    .delete(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Request Processing Failed : HTTP error code : " + response.getStatus());
            }

            output = response.getEntity(String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }
    public String getAllCustomers(String url){
        String output = "";
        try {
            Client client = Client.create();
            WebResource webResource = client.resource(url);
            ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Request Processing Failed : HTTP error code : " + response.getStatus());
            }

            output = response.getEntity(String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }
}