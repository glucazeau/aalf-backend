ALTER TABLE teacher DROP salt;
ALTER TABLE teacher DROP username;
ALTER TABLE teacher DROP username_canonical;
ALTER TABLE teacher DROP email_canonical;


ALTER TABLE open_house RENAME COLUMN open_house_date TO slot_date;
ALTER TABLE open_house RENAME COLUMN open_house_start_time TO start_time;
ALTER TABLE open_house RENAME COLUMN open_house_end_time TO end_time;
RENAME TABLE open_house TO registration_slots;