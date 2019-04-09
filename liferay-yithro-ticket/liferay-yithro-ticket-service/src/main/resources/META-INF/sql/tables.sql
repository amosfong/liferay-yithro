create table Yithro_TicketAttachment (
	ticketAttachmentId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	ticketEntryId LONG,
	ticketSolutionId LONG,
	fileName VARCHAR(255) null,
	fileSize LONG,
	visibility INTEGER,
	status INTEGER
);

create table Yithro_TicketComment (
	ticketCommentId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	ticketEntryId LONG,
	body TEXT null,
	type_ INTEGER,
	format VARCHAR(75) null,
	visibility INTEGER,
	settings_ VARCHAR(75) null,
	status INTEGER
);

create table Yithro_TicketCommentTemplate (
	ticketCommentTemplateId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name STRING null,
	content STRING null
);

create table Yithro_TicketEntry (
	ticketEntryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	languageId VARCHAR(75) null,
	ticketNumber LONG,
	subject VARCHAR(255) null,
	description STRING null,
	severity INTEGER,
	status INTEGER,
	weight INTEGER,
	escalationLevel INTEGER,
	resolution INTEGER,
	holdDate DATE null,
	closedDate DATE null,
	dueDate DATE null
);

create table Yithro_TicketFlag (
	ticketFlagId LONG not null primary key,
	companyId LONG,
	userId LONG,
	modifiedDate DATE null,
	ticketEntryId LONG,
	type_ INTEGER,
	flag INTEGER
);

create table Yithro_TicketInformation (
	ticketInformationId LONG not null primary key,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	ticketEntryId LONG,
	fieldId LONG,
	data_ STRING null
);

create table Yithro_TicketLink (
	ticketLinkId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	ticketEntryId LONG,
	ticketSolutionId LONG,
	url STRING null,
	type_ INTEGER,
	visibility INTEGER
);

create table Yithro_TicketSolution (
	ticketSolutionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	ticketEntryId LONG,
	solution STRING null,
	type_ INTEGER,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	statusMessage TEXT null,
	statusReason INTEGER
);

create table Yithro_TicketWorker (
	ticketWorkerId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	ticketEntryId LONG,
	sourceClassNameId LONG,
	sourceClassPK LONG,
	role_ INTEGER,
	primary_ BOOLEAN
);