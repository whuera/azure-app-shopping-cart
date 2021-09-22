package com.app.mobilpymes.shoppingcart.services.impl;

import com.app.mobilpymes.shoppingcart.entity.Category;
import com.app.mobilpymes.shoppingcart.repository.CategoryRepository;
import com.app.mobilpymes.shoppingcart.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public
class CategoryServiceImpl implements CategoryService {

    private final
    CategoryRepository categoryRepository;

    @Override
    public
    Category createCategory (Category category) {
        return categoryRepository.save ( category );
    }

    @Override
    public
    List < Category > getAllCategories ( ) {
        return categoryRepository.findAll ( );
    }
}
