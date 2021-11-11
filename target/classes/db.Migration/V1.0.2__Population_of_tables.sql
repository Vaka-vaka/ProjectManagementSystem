INSERT INTO DEVELOPERS(NAME, AGE, GENDER) VALUES
("Vaka", 35, "male"),
("Vova", 25, "male"),
("Vera", 29, "female"),
("Lera", 33, "female");

INSERT INTO SKILLS(LANGUAGE, LEVEL_SKILLS) VALUES
("java", "Senior"),
("java", "Junior"),
("java", "Middle"),
("java", "Middle");

INSERT INTO PROJECTS(NAME, LANGUAGE) VALUES
("projects_1", "Java"),
("projects_2", "Java"),
("projects_3", "Java"),
("projects_4", "Java");

INSERT INTO COMPANIES(NAME, CITY) VALUES
("companies_1", "Kiev"),
("companies_2", "Krakov"),
("companies_3", "Dublin"),
("companies_4", "London");

INSERT INTO CUSTOMERS(NAME, CITY) VALUES
("customers_1", "Kiev"),
("customers_2", "Kiev"),
("customers_3", "Odessa"),
("customers_4", "Kiev");

INSERT INTO DEVELOPERS_TO_SKILLS(DEV_ID, SKILLS_ID) VALUES
(1, 2), (2, 1), (3, 4), (4, 3);

INSERT INTO DEVELOPERS_TO_PROJECTS(DEV_ID, PROJECTS_ID) VALUES
(1, 1), (1, 2), (2, 2), (3, 3), (4, 3), (2, 4), (4, 1);

INSERT INTO COMPANIES_TO_PROJECTS(COMPANIES_ID, PROJECTS_ID) VALUES
(1, 1), (1, 2), (1, 3), (2, 1), (2, 4), (3, 3), (4, 4), (4, 1);

INSERT INTO CUSTOMERS_TO_PROJECTS(CUSTOMERS_ID, PROJECTS_ID) VALUES
(1, 1), (1, 2), (1, 3), (2, 1), (2, 2), (3, 3), (4, 4);