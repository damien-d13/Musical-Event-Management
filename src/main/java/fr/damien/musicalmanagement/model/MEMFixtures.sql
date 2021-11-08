USE musical_event_manager_db;

INSERT INTO t_role (role_id, role_label) VALUES (1, 'Administrator');
INSERT INTO t_role (role_id, role_label) VALUES (2, 'User');
INSERT INTO t_role (role_id, role_label) VALUES (3, 'Guest');

INSERT INTO t_civility (civility_id, civility_label) VALUES (1, 'Mister');
INSERT INTO t_civility (civility_id, civility_label) VALUES (2, 'Misses');
INSERT INTO t_civility (civility_id, civility_label) VALUES (3, 'Other');

INSERT INTO t_responsibility (responsibility_id, responsibility_label) VALUES (1, 'Supreme BOSS');
INSERT INTO t_responsibility (responsibility_id, responsibility_label) VALUES (2, 'Accountant');
INSERT INTO t_responsibility (responsibility_id, responsibility_label) VALUES (3, 'Security');

INSERT INTO t_instrument (instrument_id, instrument_label) VALUES (1, 'harmonica');
INSERT INTO t_instrument (instrument_id, instrument_label) VALUES (2, 'Saber');
INSERT INTO t_instrument (instrument_id, instrument_label) VALUES (3, 'Artifact');
INSERT INTO t_instrument (instrument_id, instrument_label) VALUES (4, 'Portal gun');

INSERT INTO t_speciality (speciality_id, speciality_label) VALUES (1, 'soloist');
INSERT INTO t_speciality (speciality_id, speciality_label) VALUES (2, 'chorister');
INSERT INTO t_speciality (speciality_id, speciality_label) VALUES (3, 'musician');

INSERT INTO t_address (address_id, address_label, address_number, address_street, address_complement, address_region, address_country) VALUES (1, 'At home', 17, 'Main street', 'second floor', 'Grand Est', 'France' );
INSERT INTO t_address (address_id, address_label, address_number, address_street, address_complement, address_region, address_country) VALUES (2, 'At home', 12, 'Main street', 'first floor', 'Grand Est', 'France' );
INSERT INTO t_address (address_id, address_label, address_number, address_street, address_complement, address_region, address_country) VALUES (3, 'Out side', 15, 'Park', '', 'Wallonie', 'Belgique' );
INSERT INTO t_address (address_id, address_label, address_number, address_street, address_complement, address_region, address_country) VALUES (4, 'Staduim', 32, 'Princes park ', '', 'Parisian', 'France' );

INSERT INTO t_user (user_firstname, user_lastname, user_birth_day, user_email, user_password, user_phone, user_fax, role_id, civility_id, responsibility_id) VALUES ('Damien', 'Devoti', '1984-09-13', 'devoti.damien@gmail.com', '12345', '07-50-57-10-29', 'none', 1, 1, 1);
INSERT INTO t_user (user_firstname, user_lastname, user_birth_day, user_email, user_password, user_phone, user_fax, role_id, civility_id, responsibility_id) VALUES ('Rick', 'Sanchez', '1962-07-20', 'rick.sanchez@gmail.com', '12345', '07-50-57-10-29', 'none', 1, 1, 1);
INSERT INTO t_user (user_firstname, user_lastname, user_birth_day, user_email, user_password, user_phone, user_fax, role_id, civility_id, responsibility_id) VALUES ('Yang', 'Kai', '1984-09-15', 'yang.kai@gmail.com', '12345', '07-50-57-10-29', 'none', 1, 1, 1);
INSERT INTO t_user (user_firstname, user_lastname, user_birth_day, user_email, user_password, user_phone, user_fax, role_id, civility_id, responsibility_id) VALUES ('Baam', '25', '1984-09-14', '25.baam@gmail.com', '12345', '07-50-57-10-29', 'none', 1, 1, 1);

INSERT INTO localise (user_id, address_id) VALUES (1, 1);
INSERT INTO localise (user_id, address_id) VALUES (2, 1);
INSERT INTO localise (user_id, address_id) VALUES (3, 1);
INSERT INTO localise (user_id, address_id) VALUES (4, 2);

INSERT INTO specialized (user_id, speciality_id) VALUES (1, 1);
INSERT INTO specialized (user_id, speciality_id) VALUES (2, 1);
INSERT INTO specialized (user_id, speciality_id) VALUES (3, 2);
INSERT INTO specialized (user_id, speciality_id) VALUES (4, 3);

INSERT INTO practice (user_id, instrument_id) VALUES (1, 1);
INSERT INTO practice (user_id, instrument_id) VALUES (2, 4);
INSERT INTO practice (user_id, instrument_id) VALUES (3, 3);
INSERT INTO practice (user_id, instrument_id) VALUES (4, 2);

INSERT INTO t_meet (meet_id, meet_label, meet_date_start, meet_date_stop, meet_periodicity, meet_nb_customers_expected, address_id, user_id) VALUES (1, 'Park', '2021-10-15', '2021-10-17', 'Annual', 1500, 3, 1);
INSERT INTO t_meet (meet_id, meet_label, meet_date_start, meet_date_stop, meet_periodicity, meet_nb_customers_expected, address_id, user_id) VALUES (2, 'Park', '2021-09-15', '2021-09-17', 'Monthly', 2500, 4, 1);

INSERT INTO t_group (group_id, group_label, group_characteristic) VALUES (1, 'Casseur flowters', 'HIP-HOP');
INSERT INTO t_group (group_id, group_label, group_characteristic) VALUES (2, 'Svinkels', 'HIP-HOP');
INSERT INTO t_group (group_id, group_label, group_characteristic) VALUES (3, 'Radiohead', 'Experimental rock');
INSERT INTO t_group (group_id, group_label, group_characteristic) VALUES (4, 'Beatles', 'Rock \'n\' roll');

INSERT INTO t_song (song_id, song_title, song_date, song_duration) VALUES (1, 'St valentin', '2008-02-14', '00:04:40' );
INSERT INTO t_song (song_id, song_title, song_date, song_duration) VALUES (2, 'Reveille le punk', '1999-02-14', '00:03:49' );
INSERT INTO t_song (song_id, song_title, song_date, song_duration) VALUES (3, 'Creep', '1992-05-15', '00:03:56' );
INSERT INTO t_song (song_id, song_title, song_date, song_duration) VALUES (4, 'Let it be', '1970-05-08', '00:04:04' );

INSERT INTO t_type (type_id, type_label) VALUES (1, 'Rock');
INSERT INTO t_type (type_id, type_label) VALUES (2, 'HIP-HOP');

INSERT INTO program (group_id, song_id, meet_id, program_date, program_time_start, program_time_stop) VALUES (1, 1, 1, '2021-10-15', '10:15:00', '10:20:00');
INSERT INTO program (group_id, song_id, meet_id, program_date, program_time_start, program_time_stop) VALUES (4, 4, 1, '2021-10-15', '10:21:00', '10:25:00');
INSERT INTO program (group_id, song_id, meet_id, program_date, program_time_start, program_time_stop) VALUES (2, 2, 2, '2021-09-15', '10:15:00', '10:20:00');
INSERT INTO program (group_id, song_id, meet_id, program_date, program_time_start, program_time_stop) VALUES (3, 3, 1, '2021-09-15', '10:21:00', '10:25:00');

INSERT INTO participates (group_id, user_id) VALUES (1, 1);
INSERT INTO participates (group_id, user_id) VALUES (2, 2);

INSERT INTO categorize (song_id, type_id) VALUES (1, 2);
INSERT INTO categorize (song_id, type_id) VALUES (2, 2);
INSERT INTO categorize (song_id, type_id) VALUES (3, 1);
INSERT INTO categorize (song_id, type_id) VALUES (4, 1);

INSERT INTO creates (user_id, song_id) VALUES (1, 1)


