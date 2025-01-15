
    create table authors (
        id integer not null,
        apellido varchar(255),
        nombre varchar(255),
        primary key (id)
    );

    create table books (
        authors_id integer,
        id integer not null,
        precio numeric(38,2),
        isbn varchar(255),
        titulo varchar(255),
        primary key (id)
    );

    create table authors (
        id integer not null,
        apellido varchar(255),
        nombre varchar(255),
        primary key (id)
    );

    create table books (
        authors_id integer,
        id integer not null,
        precio numeric(38,2),
        isbn varchar(255),
        titulo varchar(255),
        primary key (id)
    );

    create table authors (
        id integer not null,
        apellido varchar(255),
        nombre varchar(255),
        primary key (id)
    );

    create table books (
        authors_id integer,
        id integer not null,
        precio numeric(38,2),
        isbn varchar(255),
        titulo varchar(255),
        primary key (id)
    );

    create table authors (
        id integer not null,
        apellido varchar(255),
        nombre varchar(255),
        primary key (id)
    );

    create table books (
        authors_id integer,
        id integer not null,
        precio numeric(38,2),
        isbn varchar(255),
        titulo varchar(255),
        primary key (id)
    );
