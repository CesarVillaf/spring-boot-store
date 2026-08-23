CREATE TABLE carts (
    id BINARY(16) DEFAULT (UUID_TO_BIN(UUID())) NOT NULL
        PRIMARY KEY,
    date_created DATE DEFAULT (CURDATE()) NOT NULL
);

CREATE TABLE carts_items (
    id BIGINT NOT NULL AUTO_INCREMENT
        PRIMARY KEY,
    cart_id BINARY(16) NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL DEFAULT 1,
    CONSTRAINT cart_items_carts_products_unique
        UNIQUE (cart_id, product_id),
    CONSTRAINT cart_items_carts_id_fk
        FOREIGN KEY (cart_id) REFERENCES carts(id)
            ON DELETE CASCADE,
    CONSTRAINT cart_items_product_id_fk
        FOREIGN KEY (product_id) REFERENCES products(id)
            ON DELETE CASCADE
);