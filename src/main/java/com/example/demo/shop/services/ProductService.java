package com.example.demo.shop.services;

import com.example.demo.shop.models.Product;
import com.example.demo.shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, Product productDetail) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        product.setName(productDetail.getName());
        product.setQuantity(productDetail.getQuantity());
        product.setPrice(productDetail.getPrice());
        return productRepository.save(product);
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


}
