package com.cooligc.labs.endpoints;

import com.cooligc.labs.model.Product;
import com.cooligc.labs.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductEndpoint {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/filter")
    public Product findByName(@RequestParam("name") String name){
        return productRepository.findByName(name);
    }

    @GetMapping
    public List<Product> getAllProduct(){
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(product -> products.add(product));
        return products;
    }

    //Creating seed-data
//    @PostConstruct
    public void createProducts(){

        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(product -> products.add(product));

        //This can be written in many ways
        for (int i = products.size(); i < products.size() + 20; i++) {
            Product product1
                    = Product.builder()
                    .categories(Arrays.asList("electronics","smart"))
                    .description("Electronics Gadget")
                    .name(i + "-"+UUID.randomUUID().toString())
                    .id(UUID.randomUUID().toString())
                    .build();

            Product product2
                    = Product.builder()
                    .categories(Arrays.asList("kitchen","steel"))
                    .description("Home utensil ")
                    .name(i + "-"+UUID.randomUUID().toString())
                    .id(UUID.randomUUID().toString())
                    .build();

            if(i % 2 == 0){
                productRepository.save(product1);
                System.out.println("Product created --> "+product1.getId());
            }else{
                productRepository.save(product2);
                System.out.println("Product created --> "+product2.getId());
            }


        }
    }

}
