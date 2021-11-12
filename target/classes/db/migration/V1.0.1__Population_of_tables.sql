INSERT INTO DEVELOPERS(ID, NAME_, AGE, GENDER) VALUES
(1, 'Vaka', 35, 'male'),
(2, 'Vova', 25, 'male'),
(3, 'Vera', 29, 'female'),
(4, 'Lera', 33, 'female');

INSERT INTO SKILLS(ID, LANGUAGE, LEVEL_SKILLS) VALUES
(1, 'java', 'Senior'),
(2, 'java', 'Junior'),
(3, 'java', 'Middle'),
(4, 'java', 'Middle');

INSERT INTO PROJECTS(ID, NAME_, LANGUAGE) VALUES
(1, 'projects_1', 'Java'),
(2, 'projects_2', 'Java'),
(3, 'projects_3', 'Java'),
(4, 'projects_4', 'Java');

INSERT INTO COMPANIES(ID, NAME_, CITY) VALUES
(1, 'companies_1', 'Kiev'),
(2, 'companies_2', 'Krakov'),
(3, 'companies_3', 'Dublin'),
(4, 'companies_4', 'London');

INSERT INTO CUSTOMERS(ID, NAME_, CITY) VALUES
(1, 'customers_1', 'Kiev'),
(2, 'customers_2', 'Kiev'),
(3, 'customers_3', 'Odessa'),
(4, 'customers_4', 'Kiev');

INSERT INTO DEVELOPERS_SKILLS(DEV_ID, SKILLS_ID) VALUES
(1, 2), (2, 1), (3, 4), (4, 3);

INSERT INTO DEVELOPERS_PROJECTS(DEV_ID, PROJECTS_ID) VALUES
(1, 1), (1, 2), (2, 2), (3, 3), (4, 3), (2, 4), (4, 1);

INSERT INTO COMPANIES_PROJECTS(COMPANIES_ID, PROJECTS_ID) VALUES
(1, 1), (1, 2), (1, 3), (2, 1), (2, 4), (3, 3), (4, 4), (4, 1);

INSERT INTO CUSTOMERS_PROJECTS(CUSTOMERS_ID, PROJECTS_ID) VALUES
(1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (3, 3), (4, 4);