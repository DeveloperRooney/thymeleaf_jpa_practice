-- 회원 테이블 생성

create table member(


)

--테스트 데이터 생성

DELIMITER $$

drop procedure loopInsert;

CREATE PROCEDURE loopInsert()
BEGIN
    DECLARE i INT DEFAULT 1;

    WHILE i <= 500 DO
        INSERT INTO board(reg_date, update_date, author, title, content)
          VALUES(now(), now(), concat('작성자',i), concat('제목',i), concat('내용',i));
        SET i = i + 1;
    END WHILE;
END$$
DELIMITER $$


CALL loopInsert;