create table Yithro_Action (
	actionId LONG not null primary key,
	ruleId LONG,
	name VARCHAR(75) null,
	value VARCHAR(75) null
);

create table Yithro_Expression (
	expressionId LONG not null primary key,
	type_ VARCHAR(75) null,
	field VARCHAR(75) null,
	operation VARCHAR(75) null,
	value VARCHAR(75) null,
	ruleId LONG
);

create table Yithro_Rule (
	ruleId LONG not null primary key,
	name VARCHAR(75) null,
	triggerAction VARCHAR(75) null,
	triggerObject VARCHAR(75) null
);