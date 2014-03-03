insert into product values (1, 'name1', 10.00, 'description1', 1, current_timestamp, current_timestamp);
insert into product values (2, 'name2', 10.00, 'description2', 1, current_timestamp, current_timestamp);
insert into category values (1, 'name1', null, current_timestamp, current_timestamp);
insert into category values (2, 'name2', 1, current_timestamp, current_timestamp);
insert into tag values (1, 'tag1', current_timestamp, current_timestamp);
insert into tag values (2, 'tag2', current_timestamp, current_timestamp);
insert into product_tag values (1, 1, current_timestamp, current_timestamp);
insert into product_tag values (1, 2, current_timestamp, current_timestamp);
insert into product_tag values (2, 1, current_timestamp, current_timestamp);
insert into product_tag values (2, 2, current_timestamp, current_timestamp);
insert into orders values (1, 60.00, current_timestamp, current_timestamp, current_timestamp)
insert into orders values (2, 20.00, current_timestamp, current_timestamp, current_timestamp)
insert into order_line values (1, 1, 1, 2, 20.00, current_timestamp, current_timestamp);
insert into order_line values (1, 2, 1, 1, 10.00, current_timestamp, current_timestamp);
insert into order_line values (2, 2, 2, 1, 10.00, current_timestamp, current_timestamp);
