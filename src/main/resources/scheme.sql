create table if not exists dat
(
    id   integer  not null auto_increment,
    dat  integer  not null,
    date datetime not null,
    primary key (id)
);