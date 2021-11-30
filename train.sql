DROP TABLE IF EXISTS users;
create table users(
    id int primary key auto_increment,
    user_name varchar(50) not null unique,
    password varchar(50) not null,
    telphone varchar(13),
    email varchar(50),
    identity_card char(35)
);

-- 联系人
DROP TABLE IF EXISTS contact;
create table contact(
    id int primary key auto_increment,
    user_id int not null,
    name varchar(124) not null,
    telphone varchar(124),
    identity_card char(35) not null,
    CONSTRAINT contact_user_id FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
)