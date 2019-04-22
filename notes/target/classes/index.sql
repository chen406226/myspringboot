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

select reception.email email from reception left join book on reception.book_id = book.id