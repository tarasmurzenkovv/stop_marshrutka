select 'drop table if exists "' || tablename || '" cascade;'
from pg_tables
where schemaname = 'public';

create table application_user_type (
  ID        bigserial PRIMARY KEY NOT NULL,
  USER_TYPE TEXT                  NOT NULL
);

create table application_user (
  ID               bigserial PRIMARY KEY NOT NULL,
  USER_TYPE_ID     BIGINT references application_user_type (ID),
  LOGIN            TEXT                  NOT NULL,
  PASSWORD         TEXT                  NOT NULL,
  EMAIL            TEXT                  NOT NULL,
  TELEPHONE_NUMBER TEXT                  NOT NULL,
  NAME             TEXT                  NOT NULL,
  SURNAME          TEXT                  NOT NULL
);

create table car (
  ID         bigserial PRIMARY KEY NOT NULL,
  DRIVER_ID  BIGINT references application_user (ID),
  CAR_NUMBER TEXT                  NOT NULL,
  CAR_TYPE   TEXT                  NOT NULL
);

create table route (
  ID                    bigserial PRIMARY KEY NOT NULL,
  APPLICATION_USER      BIGINT references application_user (ID),
  NAME                  TEXT                  NOT NULL,
  START_COORDINATE_LAT  FLOAT                 NOT NULL,
  START_COORDINATE_LONG FLOAT                 NOT NULL,
  END_COORDINATE_LAT    FLOAT                 NOT NULL,
  END_COORDINATE_LONG   FLOAT                 NOT NULL
);

INSERT INTO application_user_type (USER_TYPE)
values ('Driver');
INSERT INTO application_user_type (USER_TYPE)
values ('Passenger');