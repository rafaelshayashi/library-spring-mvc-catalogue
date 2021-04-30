create table if not exists book
(
    id bigserial primary key,
    uuid uuid not null,
    title varchar (255) not null,
    sub_title varchar (255),
    currency varchar (6) not null,
    amount integer not null,
    unit_type varchar not null,
    description text,
    isbn varchar not null unique,
    user_id varchar not null
);