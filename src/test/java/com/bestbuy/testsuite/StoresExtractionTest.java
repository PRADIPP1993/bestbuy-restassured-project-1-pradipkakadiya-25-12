package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    // 1. Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    //2. Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + total);
        System.out.println("------------------End of Test---------------------------");

    }

    //3. Extract the name of 5th store
    @Test
    public void test003() {

        String name = response.extract().path("data[2].services[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : " + name);
        System.out.println("------------------End of Test---------------------------");

    }

    //4. Extract the names of all the store
    @Test
    public void test004() {
        List<String> listOfnames = response.extract().path("data.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : " + listOfnames);
        System.out.println("------------------End of Test---------------------------");
    }

    //5. Extract the storeId of all the store
    @Test
    public void test005() {
        List<Integer> listOfIds = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : " + listOfIds);
        System.out.println("------------------End of Test---------------------------");

    }

    //6. Print the size of the data list
    @Test
    public void test006() {
        List<Integer> listofsize = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data is : " + listofsize.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The values for product name 'St Cloud' are: " + values);
        System.out.println("------------------End of Test---------------------------");

    }

    //8. Get the address of the store where store name = Rochester
    @Test
    public void test008() {
        List<HashMap<String, ?>> address = response.extract().path("data.findAll{it.name == 'Rochester'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The values for product name 'Rochester' are: " + address);
        System.out.println("------------------End of Test---------------------------");

    }

    //9. Get all the services of 8th store
    @Test
    public void test009() {
        List<HashMap<String, ?>> services = response.extract().path("data[3].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The services of 8th store : " + services);
        System.out.println("------------------End of Test---------------------------");

    }

    //10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test010() {
        List<Integer> storeServices = response.extract().path("data.services.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The values for product name 'Rochester' are: " + storeServices);
        System.out.println("------------------End of Test---------------------------");

    }

    //11. Get all the storeId of all the store
    @Test
    public void test011() {
        List<HashMap<String, ?>> storeId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the storeId of all the store : " + storeId);
        System.out.println("------------------End of Test---------------------------");


    }

    //12. Get id of all the store
    @Test
    public void test012() {

        List<HashMap<String, ?>> Id = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the storeId of all the store : " + Id);
        System.out.println("------------------End of Test---------------------------");

    }

    //13. Find the store names Where state = ND
    @Test
    public void test013() {
        String storeName = response.extract().path("data[7].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the storeId of all the store : " + storeName);
        System.out.println("------------------End of Test---------------------------");


    }

    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test014() {
        List<HashMap<String, ?>> services = response.extract().path("data.findAll{it.name == 'Rochester'}.services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the Total number of services for the store where store name : " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test015() {
        List<Integer> createdAt = response.extract().path("data.services.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("he createdAt for all services whose name : " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }

    //16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test016() {
        List<String> createdAt = response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the name of all services Where store name : " + createdAt);
        System.out.println("------------------End of Test---------------------------");

    }

    //17. Find the zip of all the store
    @Test
    public void test017() {
        List<Integer> zip = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the zip of all the store : " + zip);
        System.out.println("------------------End of Test---------------------------");

    }

    //18. Find the zip of store name = Roseville
    @Test
    public void test018() {
        List<Integer> zip = response.extract().path("data.findAll{it.name == 'Roseville'}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The zip of store name : " + zip);
        System.out.println("------------------End of Test---------------------------");

    }
//data[2].services[7]
    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test019() {
      /*  //List<HashMap<String, ?>>  storeServices = response.extract().path("data.services.findAll{it.name == 'Magnolia Home Theater'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The zip of store name : " + storeServices);
        System.out.println("------------------End of Test---------------------------");
*/
    }

    //20. Find the lat of all the stores
    @Test
    public void test020() {
        List<Integer> lat = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The zip of store name : " + lat);
        System.out.println("------------------End of Test---------------------------");

    }

}
