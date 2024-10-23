--create table shop (
--id bigserial primary key auto_increment,
--identifier varchar not null,
--status varchar not null,
--date_shop date
--);
--
--create table shop_item (
--id bigserial primary key auto_increment,
--product_identifier varchar(100) not null,
--amount int not null,
--price float not null,
--shop_id bigint REFERENCES shop(id)
--);

-- Tabela Shop
CREATE TABLE Shop (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    identifier VARCHAR(255),
    status VARCHAR(255),
    date_shop DATE
);

-- Tabela ShopItem
CREATE TABLE ShopItem (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_identifier VARCHAR(255),
    amount INT,
    price FLOAT,
    shop_id BIGINT,
    CONSTRAINT fk_shop FOREIGN KEY (shop_id) REFERENCES Shop(id)
);