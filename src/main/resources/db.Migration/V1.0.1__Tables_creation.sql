create table Developers (
	id serial PRIMARY KEY,
	name varchar(50) not null,
	age integer not null,
	gender varchar(50) not null
);


create table Skills(
	id serial PRIMARY KEY,
	language varchar(250) not null,
	level_skills varchar(64) not null
);

create table Projects(
	id serial PRIMARY KEY,
	name varchar(250) not null,
	language varchar(150) not null
);

create table Companies(
	id serial PRIMARY KEY,
	name varchar(250) not null,
	city varchar(150) not null
);

create table Customers(
	id serial PRIMARY KEY,
	name varchar(64) not null,
	city varchar(100) not null
);

create table developers_to_skills(
	dev_id integer not null,
	skills_id integer not null,

	constraint dev_id_fk foreign key(dev_id) references Developers(id),
	constraint skills_id_fk foreign key(skills_id) references Skills(id)
);

create table developers_to_projects(
	dev_id integer not null,
	projects_id integer not null,

	constraint dev_id_fk foreign key(dev_id) references Developers(id),
	constraint projects_id_fk foreign key(projects_id) references Projects(id)
);

create table companies_to_projects(
	companies_id integer not null,
	projects_id integer not null,

	constraint companies_id_fk foreign key(companies_id) references Companies(id),
	constraint projects_id_fk foreign key(projects_id) references Projects(id)
);

create table customers_to_projects(
	customers_id integer not null,
	projects_id integer not null,

	constraint customers_id_fk foreign key(customers_id) references Customers(id),
	constraint projects_id_fk foreign key(projects_id) references Projects(id)
);