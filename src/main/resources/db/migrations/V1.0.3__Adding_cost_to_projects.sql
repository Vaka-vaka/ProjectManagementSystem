alter table projects add cost Integer;
update projects set cost = 50000 where (id = 1);
update projects set cost = 10000 where (id = 2);
update projects set cost = 30000 where (id = 3);
update projects set cost = 30000 where (id = 4);