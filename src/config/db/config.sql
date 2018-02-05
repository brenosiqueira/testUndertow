CREATE LOGIN usrTest WITH PASSWORD = 'test123', DEFAULT_LANGUAGE = us_english, CHECK_EXPIRATION = OFF, CHECK_POLICY = OFF;
CREATE USER  [usrTest] FOR LOGIN [usrTest] WITH DEFAULT_SCHEMA = [dbo];
--drop user usTest

create DATABASE dbTest;

use dbTest;

GRANT SELECT, INSERT, UPDATE, DELETE, ALTER  ON SCHEMA::dbo to usrTest;

use dbTest;
create TABLE email(
	id BIGINT PRIMARY key IDENTITY,
	address VARCHAR(50),
	person_type SMALLINT
)

INSERT INTO EMAIL VALUES('kenpachi@gmail.com', 1)
INSERT INTO EMAIL VALUES('ichigo@gmail.com', 1)
INSERT INTO EMAIL VALUES('soulsociety@gmail.com', 2)