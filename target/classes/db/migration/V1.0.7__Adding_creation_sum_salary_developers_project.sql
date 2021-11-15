CREATE VIEW sum_salary_developers_project AS
SELECT p.name_, sum(d.salary) AS sum_salary
FROM developers d
JOIN developers_projects dp ON dp.dev_id = d.id
JOIN projects p ON p.id = dp.projects_id
GROUP BY p.name_;
