alter table projects add column creation_date DATE;

update projects set creation_date = '2021.01.01' where id = 1;
update projects set creation_date = '2021.08.10' where id = 2;
update projects set creation_date = '2019.05.02' where id = 3;
update projects set creation_date = '2018.09.03' where id = 4;