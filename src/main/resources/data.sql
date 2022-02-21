create table if not exists address
(
    id integer not null
        primary key,
    city varchar,
    country varchar,
    postal_code varchar,
    street varchar
);

create table if not exists person
(
    id integer not null
        primary key,
    first_name varchar,
    last_name varchar,
    address_id integer
);

create table if not exists reservation
(
    id integer not null
        primary key,
    booking_date date,
    person_id integer
);



-- drop table address;
-- drop table person;
-- drop table reservation;