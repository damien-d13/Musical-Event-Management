USE musical_event_manager_db;

INSERT INTO t_role (role_id, role_label) VALUES (1, 'Administrator');
INSERT INTO t_civility (civility_id, civility_label) VALUES (1, 'Mister');
INSERT INTO t_responsibility (responsibility_id, responsibility_label) VALUES (1, 'Supreme BOSS');
INSERT INTO t_user (user_firstname, user_lastname, user_birth_day, user_email, user_password, user_phone, user_fax, role_id, civility_id, responsibility_id) VALUES ('Damien', 'Devoti', '1984-09-13', 'devoti.damien@gmail.com', '12345', '07-50-57-10-29', 'none', 1, 1, 1);