create sequence t_artists_SEQ start with 1 increment by 50;
create sequence t_customers_SEQ start with 1 increment by 50;
create sequence t_items_SEQ start with 1 increment by 50;
create sequence t_publishers_SEQ start with 1 increment by 50;
create sequence t_purchase_order_line_SEQ start with 1 increment by 50;
create sequence t_puurchase_order_SEQ start with 1 increment by 50;
create sequence t_tracks_SEQ start with 1 increment by 50;
create table t_artists
(
    created_date timestamp(6) with time zone not null,
    id           bigint                      not null,
    name         varchar(100)                not null,
    bio          varchar(3000),
    primary key (id)
);
create table t_customers
(
    created_date timestamp(6) with time zone not null,
    id           bigint                      not null,
    first_name   varchar(50),
    last_name    varchar(50),
    e_mail       varchar(255)                not null,
    primary key (id)
);
create table t_items
(
    nb_of_pages      integer,
    price            numeric(38, 2) not null,
    publication_date date,
    artist_fk        bigint,
    created_date     timestamp(6) with time zone,
    id               bigint         not null,
    publisher_fk     bigint,
    genre            varchar(15),
    isbn             varchar(15),
    DTYPE            varchar(31)    not null,
    title            varchar(100)   not null,
    description      varchar(3000),
    language         varchar(255) check (language in ('ENGLISH','FRENCH','SPANISH','GERMAN')
) , music_Company varchar(255), primary key (id));
create table t_publishers
(
    created_date timestamp(6) with time zone not null,
    id           bigint                      not null,
    name         varchar(50)                 not null,
    primary key (id)
);
create table t_purchase_order_line
(
    quantity          integer not null,
    create_date       timestamp(6) with time zone,
    id                bigint  not null,
    item_fk           bigint,
    purchase_order_fk bigint,
    primary key (id)
);
create table t_puurchase_order
(
    purchase_order_date date   not null,
    create_date         timestamp(6) with time zone,
    customer_fk         bigint,
    id                  bigint not null,
    primary key (id)
);
create table t_tracks
(
    duration     numeric(21, 0) not null,
    cd_fk        bigint,
    created_date timestamp(6) with time zone,
    id           bigint         not null,
    title        varchar(255)   not null,
    primary key (id)
);
alter table if exists t_items add constraint FKr3152tukbog585dik5qwonldg foreign key (artist_fk) references t_artists;
alter table if exists t_items add constraint FKi6lqpcqfnc4dtsp9w473p5kkj foreign key (publisher_fk) references t_publishers;
alter table if exists t_purchase_order_line add constraint FKk5o0lynwj3vddwn397a24kwqj foreign key (item_fk) references t_items;
alter table if exists t_purchase_order_line add constraint FK7ijbpfn70rubcf8hx19s2vwjs foreign key (purchase_order_fk) references t_puurchase_order;
alter table if exists t_puurchase_order add constraint FKeumox7h6y7pycu9d4cqqmka0f foreign key (customer_fk) references t_customers;
alter table if exists t_tracks add constraint FK23u6r10m0dkp0m8t5hr40ilux foreign key (cd_fk) references t_items;
