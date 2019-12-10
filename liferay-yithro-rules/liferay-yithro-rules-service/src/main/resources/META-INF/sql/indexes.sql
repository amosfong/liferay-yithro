create index IX_EB17F525 on Yithro_Action (ruleId);

create index IX_67533BEE on Yithro_Expression (ruleId, type_[$COLUMN_LENGTH:75$]);
create index IX_2341F139 on Yithro_Expression (type_[$COLUMN_LENGTH:75$]);

create index IX_3923F6D on Yithro_Rule (objectName[$COLUMN_LENGTH:75$], objectEvent[$COLUMN_LENGTH:75$]);

create index IX_55B94941 on Yithro_RuleAction (ruleId);

create index IX_D9E7E161 on Yithro_RuleActionData (ruleActionId);

create index IX_132549A3 on Yithro_RuleCondition (ruleId, type_[$COLUMN_LENGTH:75$]);