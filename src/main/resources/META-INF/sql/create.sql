create table product(product_id bigint primary key, name varchar(256), price decimal(8,2), description text, category_id bigint, create_at datetime, update_at datetime);
create table category(category_id bigint primary key, name varchar(256), parent_id bigint, create_at datetime, update_at datetime);
create table tag(tag_id bigint primary key, name varchar(256), create_at datetime, update_at datetime);
create table product_tag(product_id bigint, tag_id bigint, create_at datetime, update_at datetime, primary key(product_id, tag_id));
create table orders(order_id bigint primary key, total_amount decimal(8,2), purchase_orderdate datetime, create_at datetime, update_at datetime);
create table order_line(order_line_id bigint , order_id bigint, product_id bigint, quantity integer, amount decimal(8,2), create_at datetime, update_at datetime, primary key(order_id, order_line_id));