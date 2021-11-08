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
CREATE PROCEDURE find_song
BEGIN
    SELECT *
    FROM t_song;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE find_user_info
(IN songid CHAR(20))
BEGIN
    SELECT group_label
    FROM t_group
    INNER JOIN program p on t_group.group_id = p.group_id
    WHERE song_id = songid;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE find_meet
(IN songid CHAR(20), groupid CHAR(20))
BEGIN
    SELECT meet_id
    FROM program
    WHERE song_id = songid AND group_id = groupid;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE find_user_with_meet_spe
(IN songid CHAR(20), groupid CHAR(20))
BEGIN
    SELECT user_id
    FROM t_meet
#     WHERE meet_id = songid AND group_id = groupid;
END //
DELIMITER ;

