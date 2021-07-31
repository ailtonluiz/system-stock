CREATE TABLE products_group
(
    id     BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    name   VARCHAR(50) NOT NULL,
    active INT(11)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE brand
(
    id     BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    name   VARCHAR(50) NOT NULL,
    active INT(11)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE unity
(
    id     BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    name   VARCHAR(50) NOT NULL,
    active INT(11)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE product
(
    id                     BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    bar_code               VARCHAR(14),
    name_product           VARCHAR(100) NOT NULL,
    reference              VARCHAR(15),
    price_sale             DECIMAL(10, 2),
    price_purchase         DECIMAL(10, 2),
    quantity_stock         INTEGER,
    quantity_stock_minimum INTEGER,
    quantity_stock_pending INTEGER,
    active                 INT(11),
    photo                  VARCHAR(100),
    content_type           VARCHAR(100),
    group_id               BIGINT(20)   NOT NULL,
    brand_id               BIGINT(20)   NOT NULL,
    unity_id               BIGINT(20)   NOT NULL,
    FOREIGN KEY (group_id) REFERENCES products_group (id),
    FOREIGN KEY (brand_id) REFERENCES brand (id),
    FOREIGN KEY (unity_id) REFERENCES unity (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


INSERT INTO products_group
VALUES (0, 'General', 1);
INSERT INTO brand
VALUES (0, 'Cleaning', 1);

