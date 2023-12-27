create table admins
(
    username varchar(16)  not null
        primary key,
    password varchar(148) not null,
    email    varchar(50)  not null,
    otp      int          null
);

create table adminsdetails
(
    id          int auto_increment
        primary key,
    username    varchar(16)             not null,
    name        varchar(50)             not null,
    gender      enum ('MALE', 'FEMALE') not null,
    dateOfBirth date                    not null,
    nid         varchar(12)             not null,
    phone       varchar(11)             not null,
    address     varchar(100)            not null,
    pictureName varchar(100)            not null,
    constraint AdminsDetails_admins_username_fk
        foreign key (username) references admins (username)
            on update cascade on delete cascade
);

create table categories
(
    id   int          not null
        primary key,
    name varchar(100) not null
);

create table customers
(
    email           varchar(100)  not null
        primary key,
    name            varchar(30)   not null,
    password        varchar(148)  not null,
    otp             int           null,
    totalProfit     int default 0 not null,
    tempTotalProfit int default 0 not null
);

create table discounts
(
    id         int auto_increment
        primary key,
    coupon     varchar(10) not null,
    amount     int         not null,
    expireTime datetime    not null
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
    constraint Orders_customers_email_fk
        foreign key (cusEmail) references customers (email)
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

create table orderdetails
(
    id              int auto_increment
        primary key,
    OrId            int not null,
    orderedQuantity int not null,
    price           int not null,
    productId       int not null,
    constraint OrderDetails_orders_orId_fk
        foreign key (OrId) references orders (orId),
    constraint orderdetails_products_id_fk
        foreign key (productId) references products (id)
);

create table totalrevenues
(
    id    int           not null
        primary key,
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
    `dec` int default 0 not null
);

create table totalsales
(
    id    int auto_increment
        primary key,
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
    `dec` int default 0 not null
);


