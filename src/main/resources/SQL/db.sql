-- auto-generated definition
create table dogs
(
  id   serial not null
    constraint dogs_pk
      primary key,
  name varchar,
  age  integer
);

alter table dogs
  owner to postgres;

create unique index dogs_id_uindex
  on dogs (id);

