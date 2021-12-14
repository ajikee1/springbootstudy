package com.example.springbootstudy;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/*
    @RestController annotation is used to define the RESTful web services. It serves JSON, XML and custom response
 */
@RestController
public class RestFul {

    /* SAMPLE DATA */
    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    /*
        @RequestMapping annotation is used to define the Request URI to access the REST Endpoints
        The default request method is GET.
        Example: @RequestMapping(value = "/products") === http://localhost:8080/products
     */
    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }


    /*
        @RequestBody annotation is used to define the request body content type.

        Example: The request body is of the type Product. (@RequestBody Product product)
     */
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    /*
        @PathVariable annotation is used to define the custom or dynamic request URI.
        The Path variable in request URI is defined as curly braces {}

        Example: The {id} maps to the String id input parameter. (@PathVariable("id") String id, @RequestBody Product product)
     */

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }


    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }




}


/*
GET API
    The default HTTP request method is GET. This method does not require any Request Body.

POST API
    The HTTP POST request is used to create a resource. This method contains the Request Body.

PUT API
    The HTTP PUT request is used to update the existing resource. This method contains a Request Body.

DELETE API
    The HTTP Delete request is used to delete the existing resource. This method does not contain any Request Body.
 */
