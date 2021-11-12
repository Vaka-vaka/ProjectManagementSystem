alter table projects add column creation_date DATE;

update projects set creation_date = '01.01.2021' where id = 1;
update projects set creation_date = '10.08.2021' where id = 2;
update projects set creation_date = '02.05.2019' where id = 3;
update projects set creation_date = '03.09.2018' where id = 4;