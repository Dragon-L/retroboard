DROP TABLE IF EXISTS retro;
CREATE TABLE retro (
  id SERIAL NOT NULL PRIMARY KEY,
  created_time TIMESTAMP NOT NULL,
  uuid UUID NOT NULL,
  status VARCHAR(16) NOT NULL,
  dimensions VARCHAR(16) ARRAY,
  invitation_code CHAR(16) UNIQUE,
  last_modify_time TIMESTAMP,
  description VARCHAR(255)
);