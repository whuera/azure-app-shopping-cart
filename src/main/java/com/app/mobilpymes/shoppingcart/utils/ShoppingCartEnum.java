package com.app.mobilpymes.shoppingcart.utils;

public
enum ShoppingCartEnum {
    CUSTOMER_CREATE ( "CREATE_CUSTOMER" ),
    CUSTOMER_DELETE ( "INACTIVE_CUSTOMER" ),
    CUSTOMER_UPDATE ( "UPDATE_CUSTOMER" ),
    PRODUCT_CREATE ( "CREATE_PRODUCT" ),
    PRODUCT_DELETE ( "DELETE_PRODUCT" ),
    CARD_ACTIVE ( "ACTIVE_CARD" ),
    CARD_INACTIVE ( "INACTIVE_CARD" ),
    CHECKOUT_SUCCESS ( "CHECKOUT_SUCCESS" ),
    CHECKOUT_ERROR ( "CHECKOUT_ERROR" );

    public final String type;

    ShoppingCartEnum (String type) {
        this.type = type;
    }
}
