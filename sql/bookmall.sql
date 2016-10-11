--sequences

--book_seq
drop sequence book_seq;

create sequence book_seq
start with 1
increment by 1
maxvalue 9999999999;

--category_seq
drop sequence category_seq;

create sequence category_seq
start with 1
increment by 1
maxvalue 9999999999;

--member_seq
drop sequence member_seq;

create sequence member_seq
start with 1
increment by 1
maxvalue 9999999999;

--orders_seq
drop sequence orders_seq;

create sequence orders_seq
start with 1
increment by 1
maxvalue 9999999999;

insert into category values(1,'소설');
select * from book;
select * from category;
select * from cart;
select * from category;
select * from member;
select * from order_book;



select * from book a, category b where a.category_no = b.no;
select * from orders a, member b where a.member_no= b.no;

select * from cart d , (select * from book a, category b where a.category_no = b.no) c;
