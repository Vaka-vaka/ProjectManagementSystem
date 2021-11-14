CREATE VIEW list_java_developers AS
select trim(d.name_ || ' ' || d.age || ' ' || d.gender || ' ' || d.salary)
FROM developers d
INNER JOIN developers_skills ds ON ds.dev_id=d.id
INNER JOIN skills s ON s.id = ds.skills_id
WHERE s.language = 'java';