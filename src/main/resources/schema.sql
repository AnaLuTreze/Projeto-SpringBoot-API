drop table if exists pessoa;

create table pessoa(
    id_pessoa bigint auto_increment,
    nome varchar(100) not null,
    valor double not null,
    idade double not null,
    telefone double not null,
    primary key(id_pessoa)
    );

