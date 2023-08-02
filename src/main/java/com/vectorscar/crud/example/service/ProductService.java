package com.vectorscar.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vectorscar.crud.example.entity.Product;
import com.vectorscar.crud.example.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired //Injection using Autowired
    private ProductRepository repository;

    //POST METHOD to add single product in the Database
    public Product saveProduct(Product product){
        return repository.save(product);
    }
    // POST METHOD to add multiple products in the Database
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    //GET METHOD from the database to fetch all the data
    public List<Product> getProducts(){
        return repository.findAll();
    }

    //GET METHOD from the database to fetch single data
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    //GET Method to fetch data by name
    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    //DELETE METHOD to delete by id
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product removed!!" + id;
    }

    //UPDATE METHOD
    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }


}
