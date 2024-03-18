package com.alicia.springbootcrud.service;

import com.alicia.springbootcrud.model.Product;
import com.alicia.springbootcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productOpt = productRepository.findById(id);
        if (productOpt.isPresent()) {
            Product productDb = productOpt.orElseThrow();
            productDb.setName(product.getName());
            productDb.setDescription(product.getDescription());
            productDb.setPrice(product.getPrice());
            productDb.setSku(product.getSku());
            return Optional.of(productRepository.save(productDb));
        }
        return productOpt;
    }

    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> productOpt = productRepository.findById(id);
        productOpt.ifPresent(productDb -> {
            productRepository.delete(productDb);
        });
        return productOpt;
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsBySku(String sku) {
       return productRepository.existsBySku(sku);
    }
}
