create table Yithro_SupportLabor (
	supportLaborId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
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

create table Yithro_SupportLevelAgreement (
	supportLevelAgreementId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);

create table Yithro_SupportTeam (
	supportTeamId LONG not null primary key,
	companyId LONG,
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
	companyId LONG,
	userId LONG,
	supportTeamId LONG,
	supportLaborId LONG,
	assignedWork DOUBLE,
	maxWork DOUBLE,
	role_ INTEGER
);