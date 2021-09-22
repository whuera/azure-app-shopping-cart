package com.app.mobilpymes.shoppingcart.controllers;

import com.app.mobilpymes.shoppingcart.entity.Category;
import com.app.mobilpymes.shoppingcart.entity.Product;
import com.app.mobilpymes.shoppingcart.services.CategoryService;
import com.app.mobilpymes.shoppingcart.services.ProductService;
import com.app.mobilpymes.shoppingcart.utils.ShoppingCartHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public
class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private
    CategoryService categoryService;

    @GetMapping
    public
    String healthPage ( ) {
        return "Status Ok";
    }

    @GetMapping("/products")
    public
    ResponseEntity < List < Product > > getAllProducts ( ) {
        return ResponseEntity.ok ( productService.listAllProduct ( ) );
    }

    @GetMapping("/listproducts")
    public
    ResponseEntity < List < Product > > listProduct (@RequestParam(name = "categoryId", required = false) Long categoryId) {
        List < Product > products = new ArrayList <> ( );
        if ( null == categoryId ) {
            products = productService.listAllProduct ( );
            if ( products.isEmpty ( ) ) {
                return ResponseEntity.noContent ( ).build ( );
            }
        } else {
            products = productService.findByCategory ( Category.builder ( ).id ( categoryId ).build ( ) );
            if ( products.isEmpty ( ) ) {
                return ResponseEntity.notFound ( ).build ( );
            }
        }

        return ResponseEntity.ok ( products );
    }

    @GetMapping(value = "/product/{id}")
    public
    ResponseEntity < Product > getProduct (@PathVariable("id") Long id) {
        Product product = productService.getProduct ( id );
        if ( null == product ) {
            return ResponseEntity.notFound ( ).build ( );
        }
        return ResponseEntity.ok ( product );
    }

    @PostMapping
    public
    ResponseEntity < Product > createProduct (@Valid @RequestBody Product product, BindingResult result) {
        if ( result.hasErrors ( ) ) {
            throw new ResponseStatusException ( HttpStatus.BAD_REQUEST, ShoppingCartHelper.formatMessage ( result ) );
        }
        Product productCreate = productService.createProduct ( product );
        return ResponseEntity.status ( HttpStatus.CREATED ).body ( productCreate );
    }

    @PutMapping(value = "/{id}")
    public
    ResponseEntity < Product > updateProduct (@PathVariable("id") Long id, @RequestBody Product product) {
        product.setId ( id );
        Product productDB = productService.updateProduct ( product );
        if ( productDB == null ) {
            return ResponseEntity.notFound ( ).build ( );
        }
        return ResponseEntity.ok ( productDB );
    }

    @PostMapping("/categories")
    public
    ResponseEntity < Category > createCategory (@Valid @RequestBody Category category) {
        Category categoryCreate = categoryService.createCategory ( category );
        return ResponseEntity.status ( HttpStatus.CREATED ).body ( categoryCreate );
    }

    @GetMapping("/categories")
    public
    ResponseEntity < List < Category > > getAllCategories ( ) {
        return ResponseEntity.ok ( categoryService.getAllCategories ( ) );
    }

}
