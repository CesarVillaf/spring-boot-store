alter table order_items
    drop foreign key order_item_products_id_fk;

alter table order_items
    add constraint order_item_products_id_fk
        foreign key (product_id) references products (id)
            on delete cascade;