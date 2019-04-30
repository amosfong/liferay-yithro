create index IX_98526F53 on Yithro_SupportTeam (name[$COLUMN_LENGTH:75$]);
create index IX_2A828559 on Yithro_SupportTeam (parentSupportTeamId);
create index IX_C9477FA4 on Yithro_SupportTeam (supportLaborId);

create index IX_2F604245 on Yithro_SupportWorker (supportLaborId);
create index IX_9EA95C22 on Yithro_SupportWorker (supportTeamId);
create index IX_3BEB9B63 on Yithro_SupportWorker (userId, maxWork, role_);
create unique index IX_6B4FEDA8 on Yithro_SupportWorker (userId, supportTeamId);