create index IX_C2305924 on Yithro_AuditEntry (classNameId, classPK, field[$COLUMN_LENGTH:75$], action);
create index IX_A3E41536 on Yithro_AuditEntry (classNameId, classPK, visibility);
create index IX_18DC2B95 on Yithro_AuditEntry (createDate, classNameId);
create index IX_A1B0550A on Yithro_AuditEntry (fieldClassNameId, fieldClassPK, field[$COLUMN_LENGTH:75$]);