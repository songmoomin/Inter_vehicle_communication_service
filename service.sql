


GRANT connect,resource,dba TO c##lab4dx;



CREATE TABLE c##lab4dx.Member (
                       member_id VARCHAR(15) PRIMARY KEY ,  -- 사용자 고유 ID
                       password VARCHAR(15) NOT NULL ,
                       username VARCHAR(10) NOT NULL,  -- 사용자 이름
                       phone_number VARCHAR(13) NOT NULL UNIQUE  -- 이메일 주소 (중복 방지)
);

CREATE TABLE c##lab4dx.Emoji (
                        emoji_id VARCHAR(15) PRIMARY KEY   -- 이모지 고유 ID
);



CREATE TABLE c##lab4dx.Customizing_Setting(
                                member_id VARCHAR(15) NOT NULL,  -- 사용자 ID (Users 테이블의 외래키)
                                emoji_id VARCHAR(15) NOT NULL,  -- 이모지 ID (Emojis 테이블의 외래키)
                                message VARCHAR(100),  -- 사용자 정의 메시지
                                image_path VARCHAR(255),  -- 이미지 파일 경로
                                emoji_color VARCHAR(7) NOT NULL,  -- 이모지 색상 (예: '#FF5733')
                                PRIMARY KEY (member_id, emoji_id),  -- 복합 기본 키
                                FOREIGN KEY (member_id) REFERENCES c##lab4dx.Member(member_id),  -- 사용자 외래키
                                FOREIGN KEY (emoji_id) REFERENCES c##lab4dx.Emoji(emoji_id)

);

CREATE TABLE c##lab4dx.Default_Text(
    text_id VARCHAR(15) PRIMARY KEY ,
    text VARCHAR(100),
    sentiment VARCHAR(10)
);

CREATE TABLE c##lab4dx.Default_Setting(
    text_id VARCHAR(15) NOT NULL ,
    member_id VARCHAR(15) NOT NULL ,
    PRIMARY KEY (text_id, member_id),
    FOREIGN KEY (text_id) REFERENCES c##lab4dx.Default_Text(text_id),
    FOREIGN KEY (member_id) REFERENCES c##lab4dx.Member(member_id)
);

INSERT INTO C##LAB4DX.MEMBER (member_id, password, username, phone_number)
VALUES ('test135', 'password', 'Test User',  '1234567801');

SELECT * FROM C##LAB4DX.MEMBER;


SELECT * FROM (
                  SELECT t.*
                  FROM C##LAB4DX.MEMBER t
              ) WHERE ROWNUM <= 501

