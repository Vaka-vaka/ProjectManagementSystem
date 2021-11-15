CREATE VIEW list_projects AS
SELECT count (dp.dev_id) || ' - ' || p.name_ || ' - ' || to_char (p.creation_date, 'dd.mm.yyyy') as list_project
FROM projects p
JOIN developers_projects dp on dp.projects_id = p.id
GROUP BY creation_date, p.name_;