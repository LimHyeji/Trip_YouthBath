create database huhjsecdb;

use huhjsecdb;

create table memberSec(
    id varchar(20) primary key,
    salt varchar(500)
);