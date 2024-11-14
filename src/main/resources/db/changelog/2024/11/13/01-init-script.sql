create table users
(
    user_id       uuid primary key,
    name          varchar(64) not null,
    creation_date timestamp(6) default now()
);

create table tickets
(
    ticket_id     uuid primary key,
    user_id       uuid        not null,
    ticket_type   varchar(64) not null,
    creation_date timestamp(6) default now()
);

alter table if exists tickets
    add constraint user_id_fk
        foreign key (user_id)
            references users
            on delete cascade;
