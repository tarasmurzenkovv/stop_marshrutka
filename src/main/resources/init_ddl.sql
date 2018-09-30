create table application_user_type (
  ID        bigserial PRIMARY KEY NOT NULL,
  USER_TYPE TEXT                  NOT NULL
);

create table application_user (
  ID           bigserial PRIMARY KEY NOT NULL,
  USER_TYPE_ID BIGINT references application_user_type (ID),
  NAME         TEXT                  NOT NULL
);

create table route (
  ID                    bigserial PRIMARY KEY NOT NULL,
  USER_ID               BIGINT references application_user (ID),
  NAME                  TEXT                  NOT NULL,
  START_COORDINATE_LAT  FLOAT                 NOT NULL,
  START_COORDINATE_LONG FLOAT                 NOT NULL,
  END_COORDINATE_LAT    FLOAT                 NOT NULL,
  END_COORDINATE_LONG   FLOAT                 NOT NULL
);

INSERT INTO application_user_type (USER_TYPE) values ('Driver');
INSERT INTO application_user_type (USER_TYPE) values ('Customer');