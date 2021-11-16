USE musical_event_manager_db;

DELIMITER //
CREATE PROCEDURE login()
BEGIN
    SELECT user_email, user_password
    FROM t_user ;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE find_user_info
(IN useremail CHAR(20))
BEGIN
    SELECT user_firstname
    FROM t_user
    WHERE user_email = useremail ;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE all_instrument()
BEGIN
    SELECT *
    FROM t_instrument;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE all_song()
BEGIN
    SELECT *
    FROM t_song;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE all_meet()
BEGIN
    SELECT *
    FROM t_meet;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE all_country()
BEGIN
    SELECT *
    FROM t_address;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE all_speciality()
BEGIN
    SELECT *
    FROM t_speciality;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE all_group()
BEGIN
    SELECT *
    FROM t_group;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE all_group_number()
BEGIN
    SELECT COUNT(t_group.group_label)
    FROM t_group;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE all_address()
BEGIN
    SELECT *
    FROM t_address;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE find_group_by_song
(IN songid CHAR(20))
BEGIN
    SELECT group_label
    FROM t_group
    INNER JOIN program p on t_group.group_id = p.group_id
    WHERE song_id = songid;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE find_meet_by_song_group
(IN songid CHAR(20), groupid CHAR(20))
BEGIN
    SELECT *
    FROM t_meet
    INNER JOIN program p on t_meet.meet_id = p.meet_id
    WHERE p.song_id = songid AND p.group_id = groupid;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE find_user_with_meet_spe
(IN spe CHAR(20), meet CHAR(20))
BEGIN
    SELECT *
    from t_user
             INNER join participates p on t_user.user_id = p.user_id
             INNER JOIN t_group tg on p.group_id = tg.group_id
             INNER JOIN program prog on tg.group_id = prog.group_id
             INNER JOIN t_meet tm on prog.meet_id = tm.meet_id
             INNER JOIN specialized s on t_user.user_id = s.user_id
             INNER JOIN t_speciality ts on s.speciality_id = ts.speciality_id
    WHERE prog.meet_id = meet and ts.speciality_id = spe
    ;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE find_song_with_time_location
(IN address CHAR(20), timemin CHAR(20))
BEGIN
    SELECT *
    from t_song s
            INNER JOIN program p on s.song_id = p.song_id
            INNER JOIN t_meet tm on p.meet_id = tm.meet_id
            INNER JOIN t_address ta on tm.address_id = ta.address_id
    WHERE ta.address_id = address and  s.song_duration >= timemin
    ;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE find_meet_by_nb_group
(IN nbgroup CHAR(20))
BEGIN
    SELECT t_meet.*, GROUP_CONCAT(tg.group_label)
    FROM t_meet
             INNER JOIN  program p on t_meet.meet_id = p.meet_id
             INNER JOIN t_group tg on p.group_id = tg.group_id
    GROUP BY t_meet.meet_id
    HAVING COUNT(tg.group_id) >= nbgroup;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE find_meet_by_instrument
(IN instrument CHAR(20))
BEGIN
    SELECT t_meet.meet_label
    FROM t_meet
             INNER JOIN  program p on t_meet.meet_id = p.meet_id
             INNER JOIN t_group tg on p.group_id = tg.group_id
             INNER JOIN participates part on tg.group_id = part.group_id
             INNER JOIN t_user tu on part.user_id = tu.user_id
             INNER JOIN practice prac on tu.user_id = prac.user_id
    WHERE prac.instrument_id = instrument;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE find_program_by_group_address
(IN groupid integer, address integer)
BEGIN
    SELECT *
    FROM program
    INNER JOIN t_group tg on program.group_id = tg.group_id
    INNER JOIN t_meet tm on program.meet_id = tm.meet_id
    INNER JOIN t_address ta on tm.address_id = ta.address_id
    WHERE program.group_id = groupid AND ta.address_id = address;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE find_meet_by_song_group
(IN songid integer, groupid integer)
BEGIN
    SELECT *
    FROM t_meet
            INNER JOIN program p on t_meet.meet_id = p.meet_id
            INNER JOIN t_group tg on p.group_id = tg.group_id
            INNER JOIN t_song ts on p.song_id = ts.song_id
    WHERE p.group_id = groupid AND p.song_id = songid;
END //
DELIMITER ;