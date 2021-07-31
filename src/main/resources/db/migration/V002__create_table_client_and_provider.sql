CREATE TABLE client (
                         id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(100) NOT NULL,
                         email VARCHAR(80),
                         responsible VARCHAR(80),
                         phone VARCHAR(80),
                         note VARCHAR(120),
                         active INT(11)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE provider (
                         id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(100) NOT NULL,
                         email VARCHAR(80),
                         responsible VARCHAR(80),
                         phone VARCHAR(80),
                         note VARCHAR(120),
                         active INT(11)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;
