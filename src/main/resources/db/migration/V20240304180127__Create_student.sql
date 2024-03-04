DELIMITER $$
DROP PROCEDURE IF EXISTS V20240304180127__Create_student $$
CREATE PROCEDURE V20240304180127__Create_student()
BEGIN

IF NOT EXISTS ((SELECT * FROM information_schema.Tables WHERE table_schema=DATABASE() AND table_name='student')) THEN 
CREATE TABLE student (id integer primary key, name varchar(20), branch varchar(20), semester integer, marks integer);
END IF; 

END $$
CALL V20240304180127__Create_student () $$ 
DROP PROCEDURE IF EXISTS V20240304180127__Create_student $$ 
DELIMITER ;