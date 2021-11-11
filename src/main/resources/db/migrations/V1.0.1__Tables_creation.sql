create table Developers (
	id serial PRIMARY KEY,
	name varchar(50) not null,
	age integer not null,
	gender varchar(50) not null
);

CREATE TABLE Skills (
	id serial PRIMARY KEY,
	language varchar(250) not null,
	level_skills varchar(64) not null
);

CREATE TABLE Projects (
	id serial PRIMARY KEY,
	name varchar(250) not null,
	language varchar(150) not null
);

CREATE TABLE Companies (
	id serial PRIMARY KEY,
	name varchar(250) not null,
	city varchar(150) not null
);

CREATE TABLE Customers (
	id serial PRIMARY KEY,
	name varchar(64) not null,
	city varchar(100) not null
);

CREATE TABLE developers_skills (
	dev_id integer not null,
	skills_id integer not null,

	constraint dev_id_fk foreign key(dev_id) references Developers(id),
	constraint skills_id_fk foreign key(skills_id) references Skills(id)
);

CREATE TABLE developers_projects (
	dev_id integer not null,
	projects_id integer not null,

	constraint dev_id_fk foreign key(dev_id) references Developers(id),
	constraint projects_id_fk foreign key(projects_id) references Projects(id)
);

CREATE TABLE companies_projects (
	companies_id integer not null,
	projects_id integer not null,

	constraint companies_id_fk foreign key(companies_id) references Companies(id),
	constraint projects_id_fk foreign key(projects_id) references Projects(id)
);

CREATE TABLE customers_projects (
	customers_id integer not null,
	projects_id integer not null,

	constraint customers_id_fk foreign key(customers_id) references Customers(id),
	constraint projects_id_fk foreign key(projects_id) references Projects(id)
);