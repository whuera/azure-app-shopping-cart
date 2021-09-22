package com.app.mobilpymes.shoppingcart.services;

import com.app.mobilpymes.shoppingcart.entity.Category;

import java.util.List;

public
interface CategoryService {
    public
    Category createCategory (Category category);

    public
    List < Category > getAllCategories ( );
}
