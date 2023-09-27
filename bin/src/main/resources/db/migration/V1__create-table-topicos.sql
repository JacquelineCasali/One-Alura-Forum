create table topicos{
  id bigint not null auto_increment,
  titulo varchar(255) not null,
   mensagem  varchar(255) not null,
    status varchar(25) not null,
   autor varchar(100) not null,
     curso varchar(100) not null,

   primary key(id)

}