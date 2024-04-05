-- v2.0.0_1 - Languages

create table t_lang
(
    id char(2) not null,
    name varchar(255) not null,
    constraint t_lang_pk primary key (id)
);

INSERT INTO t_lang VALUES('es', 'Español'), ('en', 'English');

alter table t_user
    add lang_id char(2) not null default 'es';

alter table t_user
    add constraint t_user_t_lang_id_fk
        foreign key (lang_id) references t_lang (id);

alter table t_dictionary
    add lang_id char(2) not null default 'es';

alter table t_dictionary
    add constraint t_dictionary_t_lang_id_fk
        foreign key (lang_id) references t_lang (id);