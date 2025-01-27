package com.ecom.productCatalog.config;


import com.ecom.productCatalog.model.Category;
import com.ecom.productCatalog.model.Product;
import com.ecom.productCatalog.repository.CategoryRepository;
import com.ecom.productCatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //clear existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        //create categories
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home");

        categoryRepository.saveAll(Arrays.asList(electronics, clothing, home));

        //create products
        Product phone = new Product();
        phone.setName("SmartPhone");
        phone.setDescription("Latest phone with amazing features");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(699.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("High performance laptop for work");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(999.99);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Winter jacket");
        jacket.setDescription("Warm and cozy jacket for winter");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(129.99);
        jacket.setCategory(clothing);

        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("High speed blender for smoothies");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(79.99);
        blender.setCategory(home);

        productRepository.saveAll(Arrays.asList(phone, laptop, jacket, blender));


    }
}
