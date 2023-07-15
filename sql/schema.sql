create table category
(
    id serial8,
    name varchar,
    primary key (id)
);


create table product
(
    id serial8,
    category_id int8,
    name varchar,
    price int4,
    primary key (id),
    foreign key (category_id) references category(id)
);


create table option
(
    id serial8,
    category_id int8,
    option varchar,
    primary key (id),
    foreign key (category_id) references category (id)
);


create table value
(
    id serial8,
    product_id int8,
    option_id int8,
    value varchar,
    primary key (id),
    foreign key (option_id) references option (id)
);

