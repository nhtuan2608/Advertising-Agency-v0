CREATE  TABLE users (
  userid INT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  role varchar(45) NOT NULL
  );
INSERT INTO users (username, password, role)
VALUES ("son", "123456", "admin");
INSERT INTO users (username, password, role)
VALUES ("tuan", "123456", "admin");
INSERT INTO users (username, password, role)
VALUES ("dung", "123456", "admin");