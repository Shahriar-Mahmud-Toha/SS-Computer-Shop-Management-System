create table categories
(
    id   int          not null
        primary key,
    name varchar(100) not null
);

create table customerprofit
(
    id          int           not null
        primary key,
    cusEmail    varchar(100)  not null,
    totalProfit int default 0 null
);

create table discounts
(
    id         int auto_increment
        primary key,
    coupon     varchar(10) not null,
    amount     int         not null,
    expireTime datetime    not null
);

create table productkeys
(
    `key` varchar(16) not null
        primary key
);

create table products
(
    id           int           not null
        primary key,
    actualPrice  int default 0 not null,
    sellingPrice int default 0 not null,
    name         varchar(100)  not null,
    categoryId   int           not null,
    brandName    varchar(100)  not null,
    quantity     int default 0 not null,
    orderCount   int default 0 not null,
    imageName    varchar(100)  null,
    description  text          not null,
    constraint Products_categories_id_fk
        foreign key (categoryId) references categories (id)
);

create table roles
(
    id   int auto_increment
        primary key,
    name varchar(255) not null
);

create table totalrevenues
(
    id    int           not null
        primary key,
    year  int           not null,
    jan   int default 0 not null,
    feb   int default 0 not null,
    mar   int default 0 not null,
    apr   int default 0 not null,
    may   int default 0 not null,
    jun   int default 0 not null,
    jul   int default 0 not null,
    aug   int default 0 not null,
    sep   int default 0 not null,
    oct   int default 0 not null,
    nov   int default 0 not null,
    `dec` int default 0 not null,
    constraint totalrevenues_pk
        unique (year)
);

create table totalsales
(
    id    int auto_increment
        primary key,
    year  int           not null,
    jan   int default 0 not null,
    feb   int default 0 not null,
    mar   int default 0 not null,
    apr   int default 0 not null,
    may   int default 0 not null,
    jun   int default 0 not null,
    jul   int default 0 not null,
    aug   int default 0 null,
    sep   int default 0 not null,
    oct   int default 0 not null,
    nov   int default 0 not null,
    `dec` int default 0 not null,
    constraint totalsales_pk
        unique (year)
);

create table users
(
    Email    varchar(100)  not null
        primary key,
    Password varchar(148)  not null,
    enabled  int default 0 null
);

create table admins
(
    id          int auto_increment
        primary key,
    email       varchar(16)             not null,
    name        varchar(50)             not null,
    gender      enum ('MALE', 'FEMALE') not null,
    dateOfBirth date                    not null,
    nid         varchar(12)             not null,
    phone       varchar(11)             not null,
    address     varchar(100)            not null,
    pictureName varchar(100)            null,
    constraint admins_users_Email_fk
        foreign key (email) references users (Email)
);

create table customers
(
    Id    int auto_increment
        primary key,
    Email varchar(100) not null,
    Name  varchar(100) not null,
    constraint customers_users_Email_fk
        foreign key (Email) references users (Email)
);

create table orders
(
    orId           int          not null
        primary key,
    status         varchar(12)  not null,
    time           datetime     not null,
    cusEmail       varchar(100) not null,
    shipingAddress varchar(100) not null,
    paymentStatus  varchar(12)  not null,
    constraint orders_customers_Email_fk
        foreign key (cusEmail) references customers (Email)
);

create table orderdetails
(
    id              int auto_increment
        primary key,
    OrId            int           not null,
    orderedQuantity int           not null,
    actualPrice     int default 0 not null,
    sellingPrice    int default 0 not null,
    productId       int           not null,
    constraint OrderDetails_orders_orId_fk
        foreign key (OrId) references orders (orId),
    constraint orderdetails_products_id_fk
        foreign key (productId) references products (id)
);

create table user_has_roles
(
    id      int auto_increment
        primary key,
    email   varchar(255) not null,
    role_id int          not null,
    constraint user_has_roles_ibfk_1
        foreign key (email) references users (Email),
    constraint user_has_roles_ibfk_2
        foreign key (role_id) references roles (id)
);

create index email
    on user_has_roles (email);

create index role_id
    on user_has_roles (role_id);


