create index IX_C5CE2300 on Yithro_TicketAttachment (createDate, ticketEntryId);
create index IX_C4AF0A45 on Yithro_TicketAttachment (ticketEntryId, fileName[$COLUMN_LENGTH:255$], visibility, status);
create index IX_215491E4 on Yithro_TicketAttachment (ticketEntryId, status);
create index IX_41888312 on Yithro_TicketAttachment (ticketEntryId, ticketSolutionId);
create index IX_ACD37EA on Yithro_TicketAttachment (ticketEntryId, visibility, status);
create index IX_C67DC870 on Yithro_TicketAttachment (userId, ticketEntryId, visibility, status);

create index IX_F578A0BF on Yithro_TicketComment (ticketEntryId, type_);
create index IX_301F4742 on Yithro_TicketComment (ticketEntryId, visibility, status);
create index IX_B83B990D on Yithro_TicketComment (userId, ticketEntryId, visibility, status, type_);

create index IX_D62A2FD9 on Yithro_TicketEntry (modifiedDate);

create index IX_D0BF7A48 on Yithro_TicketFieldData (ticketEntryId, ticketFieldId);

create index IX_7826A201 on Yithro_TicketFlag (ticketEntryId, type_, value);
create index IX_9C71469A on Yithro_TicketFlag (userId, ticketEntryId, type_);

create index IX_509E5D5B on Yithro_TicketLink (ticketEntryId, ticketSolutionId);
create index IX_2EFFC20D on Yithro_TicketLink (ticketEntryId, visibility);

create index IX_151890E8 on Yithro_TicketSolution (ticketEntryId);

create index IX_5298C163 on Yithro_TicketWorker (sourceClassNameId, sourceClassPK);
create index IX_611BE594 on Yithro_TicketWorker (ticketEntryId, primary_);
create index IX_7C3AAD89 on Yithro_TicketWorker (userId, ticketEntryId);