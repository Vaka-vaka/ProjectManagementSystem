CREATE VIEW list_developers_project AS
select p.name_, trim(d.name_ || ' ' || d.age) as d_name_
from projects p
join developers_projects dp on dp.projects_id = p.id
join developers d on dp.dev_id = d.id
group by p.name_, trim(d.name_ || ' ' || d.age)
order by 1;