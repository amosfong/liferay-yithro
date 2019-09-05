create index IX_EB17F525 on Yithro_Action (ruleId);

create index IX_67533BEE on Yithro_Expression (ruleId, type_[$COLUMN_LENGTH:75$]);
create index IX_2341F139 on Yithro_Expression (type_[$COLUMN_LENGTH:75$]);

create index IX_4F37C609 on Yithro_Rule (triggerAction[$COLUMN_LENGTH:75$], triggerObject[$COLUMN_LENGTH:75$]);
create index IX_31608707 on Yithro_Rule (triggerObject[$COLUMN_LENGTH:75$]);