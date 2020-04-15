-- Copy salt in password column
UPDATE teacher SET password = CONCAT("{", salt, "}", password);
ALTER TABLE teacher DROP salt;

