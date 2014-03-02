create table products(id long primary key(id), name varchar, price double, description text, category_id long, create_at datetime, update_at datetime);
create table categories(id long primary key(id), name varchar, parent_id long, create_at datetime, update_at datetime);
create table tags(id long primary key(id)name varchar, create_at datetime, update_at datetime);
create table products_tags(product_id long not null, tag_id long not null, create_at datetime, update_at datetime, primary key(product_id, tag_id));
create table orders(id long primary key(id), total_amount double, purchase_orderdate datetime, create_at datetime, update_at datetime);
create table order_lines(id long , order_id long, product_id long, quantity integer, amount double, create_at datetime, update_at datetime, primary key(id, order_id));