package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }

    // 21.	Extract the limit
    @Test
    public void test021() {
        int limit =response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : "+ limit);
        System.out.println("------------------End of Test---------------------------");

    }
    //22.	Extract the total
    @Test
    public void test022() {
        int total =response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : "+ total);
        System.out.println("------------------End of Test---------------------------");
    }
    //23.	Extract the name of 5th product
    @Test
    public void test023() {
        String listOfName =response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("name of the 5th product : "+listOfName);
        System.out.println("------------------End of Test---------------------------");

    }
    //24.	Extract the names of all the products
    @Test
    public void test024() {
        List<String> listOfProducts =response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of products are : "+listOfProducts);
        System.out.println("------------------End of Test---------------------------");

    }
    //25.	Extract the productId of all the products
    @Test
    public void test025() {
        List<Integer>listOfIds =response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : "+listOfIds);
        System.out.println("------------------End of Test---------------------------");

    }
    //26.	Print the size of the data list
    @Test
    public void test026() {
        List<Integer>listOfSize =response.extract().path("data");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data is : "+listOfSize.size());//list.size()
        System.out.println("------------------End of Test---------------------------");
    }
    //27.	Get all the value of the product where product name = Energizer - MAX Batteries AA (4Pack)
    @Test
    public void test027() {
        List<Integer>values =response.extract().path("data[3].categories");

        //List<HashMap<String,?>>values=response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4Pack)'}.values");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The the value of the product is : "+values);
        System.out.println("------------------End of Test---------------------------");
    }
    //28.	Get the model of the product where product name = Energizer - N Cell E90 Batteries (2Pack)
    @Test
    public void test028() {
        String model =response.extract().path("data[3].model");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The the model of the product is : "+model);
        System.out.println("------------------End of Test---------------------------");
    }
    //29.	Get all the categories of 8th products
    @Test
    public void test029() {
        List<HashMap<String,?>> categories=response.extract().path("data[7].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The categories of 8th products are  : "+categories);
        System.out.println("------------------End of Test---------------------------");
    }
    //30.	Get categories of the store where product id = 150115
    @Test
    public void test030() {

        List<HashMap<String,?>> categories=response.extract().path("data[3].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The categories of the store is : "+categories);
        System.out.println("------------------End of Test---------------------------");
    }
    //31.	Get all the descriptions of all the products
    @Test
    public void test031() {
        List<HashMap<String,?>> descriptions=response.extract().path("data.description");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The the descriptions of all the products : "+descriptions);
        System.out.println("------------------End of Test---------------------------");
    }
    //32.	Get id of all the all categories of all the products
    @Test
    public void test032() {
        List<HashMap<String,?>> categories=response.extract().path("data.categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The the ctegories of all the products : "+ categories);
        System.out.println("------------------End of Test---------------------------");
    }
    //33.	Find the product names Where type = HardGood
    @Test
    public void test033() {
        // List<HashMap<String,?>> names=response.extract().path("data.findAll{it.type == 'HardGood'}.names");
        List<HashMap<String,?>> names=response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The the name of all the products : "+ names);
        System.out.println("------------------End of Test---------------------------");
    }
    //34.	Find the Total number of categories for the product where product name = Duracell - AA1.5V CopperTop Batteries (4-Pack)
    @Test
    public void test034() {

        List<HashMap<String,?>> categories=response.extract().path("data[1].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The the categories of all the products : "+ categories);
        System.out.println("------------------End of Test---------------------------");
    }
    //
//35.	Find the createdAt for all products whose price <  5.49
    @Test
    public void test035() {
        List<String>createdAt= response.extract().path("data.findAll{it.price < 5.49}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of products that price is less than 16.99 are: "+createdAt);
        System.out.println("------------------End of Test---------------------------");
    }
    // 36.	Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4Pack)”
    @Test
    public void test036() {
        List<String> name=  response.extract().path("data[3].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all categories is : "+name);
        System.out.println("------------------End of Test---------------------------");
    }
    // 37.	Find the manufacturer of all the products
    @Test
    public void test037() {
        List<String>manufacturer=  response.extract().path("data.manufacturer");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all manufacturer are : "+manufacturer);
        System.out.println("------------------End of Test---------------------------");
    }

    //38.	Find the imge of products whose manufacturer is = Energizer
    @Test
    public void test038() {
        List<HashMap<String,?>>imge= response.extract().path("data.findAll{it.manufacturer== 'Energizer'}.image");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all imge are : "+imge);
        System.out.println("------------------End of Test---------------------------");
    }

    //39.	Find the createdAt for all categories products whose price >  5.99
    @Test
    public void test039() {
        List<String>createdAt= response.extract().path("data.findAll{it.price >  5.99}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names createdAt for all categories products whose price >  5.99 are: "+createdAt);
        System.out.println("------------------End of Test---------------------------");
    }
    // 40.	Find the uri of all the products
    @Test
    public void test040() {
        List<HashMap<String,?>> uri=response.extract().path("data.url");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The uri of  products are  : "+uri);
        System.out.println("------------------End of Test---------------------------");
    }
}
