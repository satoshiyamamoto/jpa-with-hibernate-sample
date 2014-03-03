insert into product values (1, 'MacBook Pro 13inch Retina Display', 200.00, 'すべてのピクセルに、さらなるパワーを', 3, current_timestamp, current_timestamp);
insert into product values (2, 'iPhone 5s 64G', 50.00, '進み続けるもの', 1, current_timestamp, current_timestamp);
insert into category values (1, 'iPhone', null, current_timestamp, current_timestamp);
insert into category values (2, 'Mac', null, current_timestamp, current_timestamp);
insert into category values (3, 'Macbook', 2, current_timestamp, current_timestamp);
insert into tag values (1, 'Retina', current_timestamp, current_timestamp);
insert into tag values (2, 'Laptop', current_timestamp, current_timestamp);
insert into tag values (3, 'Tablet', current_timestamp, current_timestamp);
insert into product_tag values (1, 1, current_timestamp, current_timestamp);
insert into product_tag values (2, 1, current_timestamp, current_timestamp);
insert into product_tag values (1, 2, current_timestamp, current_timestamp);
insert into product_tag values (2, 3, current_timestamp, current_timestamp);
insert into orders values (1, 400.00, current_timestamp, current_timestamp, current_timestamp)
insert into order_line values (1, 1, 1, 1, 200.00, current_timestamp, current_timestamp);
insert into order_line values (2, 1, 2, 2, 100.00, current_timestamp, current_timestamp);
