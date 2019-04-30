create table Yithro_SupportLabor (
	supportLaborId LONG not null primary key,
	name VARCHAR(75) null,
	description STRING null,
	timeZoneId VARCHAR(75) null,
	sunOpen INTEGER,
	sunClose INTEGER,
	monOpen INTEGER,
	monClose INTEGER,
	tueOpen INTEGER,
	tueClose INTEGER,
	wedOpen INTEGER,
	wedClose INTEGER,
	thuOpen INTEGER,
	thuClose INTEGER,
	friOpen INTEGER,
	friClose INTEGER,
	satOpen INTEGER,
	satClose INTEGER
);

create table Yithro_SupportTeam (
	supportTeamId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	parentSupportTeamId LONG,
	supportLaborId LONG,
	name VARCHAR(75) null,
	description STRING null,
	assignedWork DOUBLE,
	maxWork DOUBLE
);

create table Yithro_SupportWorker (
	supportWorkerId LONG not null primary key,
	userId LONG,
	supportTeamId LONG,
	supportLaborId LONG,
	assignedWork DOUBLE,
	maxWork DOUBLE,
	role_ INTEGER
);