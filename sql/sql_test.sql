-- user sql test

insert
  into users
values ( seq_users.nextval, '안대혁', 'kickscar@gmail.com', '1234', 'male');

rollback;

select no, name, email 
  from users
 where email='kickscar@gmail.com'
   and password = '1234';
   
   
     