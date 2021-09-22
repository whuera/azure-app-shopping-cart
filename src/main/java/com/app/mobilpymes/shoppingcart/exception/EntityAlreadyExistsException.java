package com.app.mobilpymes.shoppingcart.exception;

public
class EntityAlreadyExistsException extends RuntimeException {
    public
    EntityAlreadyExistsException ( ) {
    }

    public
    EntityAlreadyExistsException (String message) {
        super ( message );
    }
}
