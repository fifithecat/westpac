insert into post (id, message, parentId, createdAt)
values(10001,'This is msg 1', null, '2008-01-01 12:00:00');

insert into post (id, message, parentId, createdAt)
values(10002,'This is msg 2', null, '2020-01-01 12:00:00');

insert into post (id, message, parentId, createdAt)
values(10003,'This is comment 1 for msg 1', 10001, '2008-01-01 12:00:00');

insert into post (id, message, parentId, createdAt)
values(10004,'This is comment 2 for msg 2', 10002, '2020-01-01 12:00:00');