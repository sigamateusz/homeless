create table if not exists donor_place
(
    id   integer not null primary key,
    name varchar,
    desc varchar,
    lat  varchar,
    lng  varchar,
    type varchar
);

-- drop table address;
-- drop table person;
-- drop table reservation;
-- drop table donor_place;