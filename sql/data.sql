insert into category (name)
values ('процессоры'),
       ('мониторы');


insert into product (category_id, name, price)
values (1,'Intel Core I9 9900',1200),
       (2,'Samsung SU556270',1500);


insert into option (category_id, option)
values (1,'Производитель'),
       (1,'Количество ядер'),
       (1,'Сокет'),
       (2,'Производитель'),
       (2,'Диагональ'),
       (2,'Матрица'),
       (2,'Разрешение');


insert into value (product_id, option_id, value)
values (1,1,'Intel'),
       (1,1,'AMD'),
       (1,2,'8'),
       (1,2,'12'),
       (1,3,'1250'),
       (1,3,'AM4'),
       (2,4,'Samsung'),
       (2,4,'AOC'),
       (2,5,'27'),
       (2,5,'21.5'),
       (2,6,'TN'),
       (2,6,'AH-IPS'),
       (2,7,'2560*1440'),
       (2,7,'1920*1080');

