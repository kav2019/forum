-- create table post (
--                       id int PRIMARY KEY generated by default as identity,
--                       title varchar(255) not null,
--                       textpost text not null,
--                       datecreate timestamp not null,
--                       author varchar(255) not null
-- );

insert into post (title, textpost, datecreate, author) VALUES ('one', 'one text',now(), 'one author');
insert into post (title, textpost, datecreate, author) VALUES ('two', 'two text',now(), 'two author');
insert into post (title, textpost, datecreate, author) VALUES ('three', 'three text',now(), 'three author');