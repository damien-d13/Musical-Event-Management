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