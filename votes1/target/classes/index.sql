CREATE TABLE book(
  id INT(11) NOT NULL auto_increment PRIMARY KEY ,
  btype INT(11) NOT NULL ,
  url VARCHAR(100) NOT NULL ,
  book VARCHAR(100) NOT NULL ,
  uname VARCHAR (100) NOT NULL ,
  checkkey VARCHAR (100) NOT NULL
);
create table reception (
  id INT(11) NOT NULL auto_increment PRIMARY KEY ,
  book_id INT(11) NOT NULL ,
  email VARCHAR (50) NOT NULL ,
  CONSTRAINT fk_bookId FOREIGN KEY (book_id) REFERENCES book(id)
);
create table if not exists student(
  id integer primary key auto_increment,
  no char(5) not null unique,
  name varchar(100) not null,
  age integer check(age>=0 and age <=30),
  gender char(2) check(gender='M' or gender='WM')
)
select reception.email email from reception left join book on reception.book_id = book.id