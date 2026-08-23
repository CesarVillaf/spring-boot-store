package com.codewithmosh.store.products;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public List<ProductDto> getProduct(Byte categoryId) {
        List<Product> products = (categoryId != null)
                ? productRepository.findByCategoryId(categoryId)
                : productRepository.findAllWithCategory();

        return products.stream().map(productMapper::toDto).toList();
    }

    public ProductDto getProduct(Long productId) {
        var product = productRepository.findById(productId).orElse(null);
        if (product == null)
            throw new ProductNotFoundException();

        return productMapper.toDto(product);
    }

    public ProductDto createProduct(ProductDto request) {
        var category = categoryRepository.findById(request.categoryId()).orElse(null);
        if (category == null)
            throw new CategoryNotFoundException();

        var product = productMapper.toEntity(request);
        product.setCategory(category);

        var productSave = productRepository.save(product);
        return productMapper.toDto(productSave);
    }

    public ProductDto updateProduct(Long productId, ProductDto request) {
        var category = categoryRepository.findById(request.categoryId()).orElse(null);
        if (category == null)
            throw new CategoryNotFoundException();

        var product = productRepository.findById(productId).orElse(null);
        if (product == null)
            throw new ProductNotFoundException();

        productMapper.update(request, product);
        product.setCategory(category);

        productRepository.save(product);
        return productMapper.toDto(product);
    }

    public void deleteProduct(Long productId) {
        var product = productRepository.findById(productId).orElse(null);
        if (product == null)
            throw new ProductNotFoundException();

        productRepository.delete(product);
    }
}
