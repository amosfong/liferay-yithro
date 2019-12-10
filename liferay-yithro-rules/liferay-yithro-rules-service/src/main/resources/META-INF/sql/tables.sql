create table Yithro_Action (
	actionId LONG not null primary key,
	ruleId LONG,
	entity VARCHAR(75) null,
	name VARCHAR(75) null,
	value VARCHAR(75) null
);

create table Yithro_Expression (
	expressionId LONG not null primary key,
	ruleId LONG,
	type_ VARCHAR(75) null,
	field VARCHAR(75) null,
	operation VARCHAR(75) null,
	value VARCHAR(75) null
);

create table Yithro_Rule (
	ruleId LONG not null primary key,
	name VARCHAR(75) null,
	objectName VARCHAR(75) null,
	objectEvent VARCHAR(75) null
);

create table Yithro_RuleAction (
	ruleActionId LONG not null primary key,
	ruleId LONG,
	actionClassName VARCHAR(75) null
);

create table Yithro_RuleActionData (
	ruleActionDataId LONG not null primary key,
	ruleActionId LONG,
	field VARCHAR(75) null,
	value VARCHAR(75) null
);

create table Yithro_RuleCondition (
	ruleConditionId LONG not null primary key,
	ruleId LONG,
	type_ VARCHAR(75) null,
	field VARCHAR(75) null,
	operation VARCHAR(75) null,
	value VARCHAR(75) null
);