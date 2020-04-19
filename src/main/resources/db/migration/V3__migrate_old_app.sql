DROP TABLE a_repondu;
DROP TABLE acl_entries;
DROP TABLE acl_object_identities;
DROP TABLE acl_object_identity_ancestors;
DROP TABLE acl_security_identities;
DROP TABLE acl_classes;
DROP TABLE acl_object_identities;
DROP TABLE adresse_appartient_a;
DROP TABLE adresses;

ALTER TABLE teacher DROP salt;
ALTER TABLE teacher DROP username;
ALTER TABLE teacher DROP username_canonical;
ALTER TABLE teacher DROP email_canonical;


ALTER TABLE open_house RENAME COLUMN open_house_date TO slot_date;
ALTER TABLE open_house RENAME COLUMN open_house_start_time TO start_time;
ALTER TABLE open_house RENAME COLUMN open_house_end_time TO end_time;
RENAME TABLE open_house TO registration_slots;