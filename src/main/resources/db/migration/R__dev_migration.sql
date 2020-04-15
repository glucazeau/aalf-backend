UPDATE teacher SET email = CONCAT(username, '@example.com') WHERE username NOT IN ('root', 'glucazeau');
UPDATE teacher SET password = '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.';