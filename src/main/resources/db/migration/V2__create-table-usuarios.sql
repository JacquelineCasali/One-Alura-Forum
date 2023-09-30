CREATE TABLE usuarios (
 id bigint not null auto_increment,
 nome varchar(100) not null,
 email varchar(100) not null unique,
 senha VARCHAR(100) NOt NULL,

    PRIMARY KEY(id)
);