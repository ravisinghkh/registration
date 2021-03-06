create table USER(
userId DECIMAL(10)  GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1),
username VARCHAR(256) unique,
password  VARCHAR(256),
created TIMESTAMP,
primary key (userId)
);


create table LOGIN_HISTORY(
id DECIMAL(10)  GENERATED BY DEFAULT AS IDENTITY(START WITH 100, INCREMENT BY 1),
username VARCHAR(256),
login_time TIMESTAMP default current_timestamp,
primary key (id),
  FOREIGN  key (username) REFERENCES user(username)
);