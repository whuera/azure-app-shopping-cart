package com.app.mobilpymes.shoppingcart.services.impl;

import com.app.mobilpymes.shoppingcart.entity.Category;
import com.app.mobilpymes.shoppingcart.entity.Product;
import com.app.mobilpymes.shoppingcart.repository.ProductRepository;
import com.app.mobilpymes.shoppingcart.services.ProductService;
import com.app.mobilpymes.shoppingcart.utils.ShoppingCartEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public
class ProductServiceImpl implements ProductService {

    public static final int DISCOUNT_VALUE = 2;
    private
    final ProductRepository productRepository;

    @Override
    public
    List < Product > listAllProduct ( ) {
        return productRepository.findAll ( );
    }

    @Override
    public
    Product getProduct (Long id) {
        return productRepository.findById ( id ).orElse ( null );
    }

    @Override
    public
    Product createProduct (Product product) {
        if ( !product.equals ( null ) ) {
            product.setCreateAt ( new Date ( ) );
            Double priceWithdiscount = product.getDiscount ( ) ? product.getPrice ( ) / DISCOUNT_VALUE : product.getPrice ( );
            product.setPrice ( priceWithdiscount );
            product.setStatus ( ShoppingCartEnum.PRODUCT_CREATE.type );
            return productRepository.save ( product );
        }
        return null;
    }

    @Override
    public
    Product updateProduct (Product product) {
        Product productDB = getProduct ( product.getId ( ) );
        if ( null == productDB ) {
            return null;
        }
        productDB.setName ( product.getName ( ) );
        productDB.setDescription ( product.getDescription ( ) );
        productDB.setCategory ( product.getCategory ( ) );
        productDB.setPrice ( product.getPrice ( ) );
        return productRepository.save ( productDB );
    }

    @Override
    public
    Product deleteProduct (Long id) {
        Product productDB = getProduct ( id );
        if ( null == productDB ) {
            return null;
        }
        productDB.setStatus ( ShoppingCartEnum.PRODUCT_DELETE.type );
        return productRepository.save ( productDB );
    }

    @Override
    public
    List < Product > findByCategory (Category category) {
        return productRepository.findByCategory ( category );
    }

    @Override
    public
    Product updateStock (Long id, Double quantity) {
        Product productDB = getProduct ( id );
        if ( null == productDB ) {
            return null;
        }
        Double stock = productDB.getStock ( ) + quantity;
        productDB.setStock ( stock );
        return productRepository.save ( productDB );
    }
}
