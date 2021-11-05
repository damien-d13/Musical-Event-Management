
DROP DATABASE IF EXISTS musical_event_manager_db;
CREATE DATABASE musical_event_manager_db CHARACTER SET utf8 COLLATE utf8_general_ci;
USE musical_event_manager_db;

drop table if exists t_group;
drop table if exists t_address;
drop table if exists t_song;
drop table if exists t_speciality;
drop table if exists t_type;
drop table if exists t_instrument;
drop table if exists t_responsibility;
drop table if exists t_civility;
drop table if exists t_role;
drop table if exists t_user;
drop table if exists t_meet;
drop table if exists participates;
drop table if exists specialized;
drop table if exists practice;
drop table if exists categorize;
drop table if exists creates;
drop table if exists localise;
drop table if exists program;
CREATE TABLE t_group(
                        group_id INT AUTO_INCREMENT,
                        group_label VARCHAR(50) ,
                        group_characteristic VARCHAR(50)  NOT NULL,
                        PRIMARY KEY(group_id)
);

CREATE TABLE t_address(
                          address_id INT AUTO_INCREMENT,
                          address_label VARCHAR(50) ,
                          address_number INT,
                          address_street VARCHAR(50) ,
                          address_complement VARCHAR(50) ,
                          address_region VARCHAR(50)  NOT NULL,
                          address_country VARCHAR(50)  NOT NULL,
                          PRIMARY KEY(address_id)
);

CREATE TABLE t_song(
                       song_id INT AUTO_INCREMENT,
                       song_title VARCHAR(50)  NOT NULL,
                       song_date DATE NOT NULL,
                       song_duration TIME NOT NULL,
                       PRIMARY KEY(song_id)
);

CREATE TABLE t_speciality(
                             speciality_id INT AUTO_INCREMENT,
                             speciality_label VARCHAR(50) ,
                             PRIMARY KEY(speciality_id)
);

CREATE TABLE t_type(
                       type_id INT AUTO_INCREMENT,
                       type_label VARCHAR(50)  NOT NULL,
                       PRIMARY KEY(type_id)
);

CREATE TABLE t_instrument(
                             instrument_id INT AUTO_INCREMENT,
                             instrument_label VARCHAR(50)  NOT NULL,
                             PRIMARY KEY(instrument_id)
);

CREATE TABLE t_responsibility(
                                 responsibility_id INT AUTO_INCREMENT,
                                 responsibility_label VARCHAR(50)  NOT NULL,
                                 PRIMARY KEY(responsibility_id)
);

CREATE TABLE t_civility(
                           civility_id INT AUTO_INCREMENT,
                           civility_label VARCHAR(50)  NOT NULL,
                           PRIMARY KEY(civility_id)
);

CREATE TABLE t_role(
                       role_id INT AUTO_INCREMENT,
                       role_label VARCHAR(50) ,
                       PRIMARY KEY(role_id)
);

CREATE TABLE t_user(
                       user_id INT AUTO_INCREMENT,
                       user_firstname VARCHAR(50)  NOT NULL,
                       user_lastname VARCHAR(50)  NOT NULL,
                       user_birth_day DATE NOT NULL,
                       user_email VARCHAR(50)  NOT NULL,
                       user_phone VARCHAR(50) ,
                       user_fax VARCHAR(50) ,
                       user_password VARCHAR(50)  NOT NULL,
                       role_id INT NOT NULL,
                       civility_id INT NOT NULL,
                       responsibility_id INT NOT NULL,
                       PRIMARY KEY(user_id),
                       UNIQUE(user_email),
                       FOREIGN KEY(role_id) REFERENCES t_role(role_id),
                       FOREIGN KEY(civility_id) REFERENCES t_civility(civility_id),
                       FOREIGN KEY(responsibility_id) REFERENCES t_responsibility(responsibility_id)
);

CREATE TABLE t_meet(
                       meet_id INT AUTO_INCREMENT,
                       meet_label VARCHAR(50)  NOT NULL,
                       meet_date_start DATE NOT NULL,
                       meet_date_stop DATE NOT NULL,
                       meet_periodicity VARCHAR(50)  NOT NULL,
                       meet_nb_customers_expected INT NOT NULL,
                       address_id INT NOT NULL,
                       user_id INT NOT NULL,
                       PRIMARY KEY(meet_id),
                       FOREIGN KEY(address_id) REFERENCES t_address(address_id),
                       FOREIGN KEY(user_id) REFERENCES t_user(user_id)
);

CREATE TABLE participates(
                             group_id INT,
                             user_id INT,
                             PRIMARY KEY(group_id, user_id),
                             FOREIGN KEY(group_id) REFERENCES t_group(group_id),
                             FOREIGN KEY(user_id) REFERENCES t_user(user_id)
);

CREATE TABLE specialized(
                            user_id INT,
                            speciality_id INT,
                            PRIMARY KEY(user_id, speciality_id),
                            FOREIGN KEY(user_id) REFERENCES t_user(user_id),
                            FOREIGN KEY(speciality_id) REFERENCES t_speciality(speciality_id)
);

CREATE TABLE practice(
                         user_id INT,
                         instrument_id INT,
                         PRIMARY KEY(user_id, instrument_id),
                         FOREIGN KEY(user_id) REFERENCES t_user(user_id),
                         FOREIGN KEY(instrument_id) REFERENCES t_instrument(instrument_id)
);

CREATE TABLE categorize(
                           song_id INT,
                           type_id INT,
                           PRIMARY KEY(song_id, type_id),
                           FOREIGN KEY(song_id) REFERENCES t_song(song_id),
                           FOREIGN KEY(type_id) REFERENCES t_type(type_id)
);

CREATE TABLE creates(
                        user_id INT,
                        song_id INT,
                        PRIMARY KEY(user_id, song_id),
                        FOREIGN KEY(user_id) REFERENCES t_user(user_id),
                        FOREIGN KEY(song_id) REFERENCES t_song(song_id)
);

CREATE TABLE localise(
                         user_id INT,
                         address_id INT,
                         PRIMARY KEY(user_id, address_id),
                         FOREIGN KEY(user_id) REFERENCES t_user(user_id),
                         FOREIGN KEY(address_id) REFERENCES t_address(address_id)
);

CREATE TABLE program(
                        group_id INT,
                        song_id INT,
                        meet_id INT,
                        program_date DATE NOT NULL,
                        program_time_start TIME NOT NULL,
                        program_time_stop VARCHAR(50)  NOT NULL,
                        PRIMARY KEY(group_id, song_id, meet_id),
                        FOREIGN KEY(group_id) REFERENCES t_group(group_id),
                        FOREIGN KEY(song_id) REFERENCES t_song(song_id),
                        FOREIGN KEY(meet_id) REFERENCES t_meet(meet_id)
);
