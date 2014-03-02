create table product(product_id long primary key, name varchar, price double, description text, category_id long, create_at datetime, update_at datetime);
create table category(category_id long primary key, name varchar, parent_id long, create_at datetime, update_at datetime);
create table tag(tag_id long primary key, name varchar, create_at datetime, update_at datetime);
create table product_tag(product_id long, tag_id long, create_at datetime, update_at datetime, primary key(product_id, tag_id));
create table orders(order_id long primary key, total_amount double, purchase_orderdate datetime, create_at datetime, update_at datetime);
create table order_line(order_line_id long , order_id long, product_id long, quantity integer, amount double, create_at datetime, update_at datetime, primary key(order_id, order_line_id));