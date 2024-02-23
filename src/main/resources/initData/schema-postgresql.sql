DROP TABLE IF EXISTS tb_comment;

CREATE TABLE IF NOT EXISTS tb_comment (
                                          id SERIAL NOT NULL,
                                          post_id SERIAL NOT NULL,
                                          content VARCHAR(3000) NOT NULL,
    writer VARCHAR(20) NOT NULL,
    delete_yn INT,
    created_date TIMESTAMP,
    modified_date TIMESTAMP,
    CONSTRAINT PK_TB_COMMENT PRIMARY KEY (id, post_id)
    );

DROP TABLE IF EXISTS tb_post;

CREATE TABLE IF NOT EXISTS tb_post (
                                       id SERIAL NOT NULL,
                                       title VARCHAR(10) NOT NULL,
    content VARCHAR(3000) NOT NULL,
    writer VARCHAR(20) NOT NULL,
    view_cnt INT,
    notice_yn BOOLEAN,
    delete_yn INT,
    created_date TIMESTAMP,
    modified_date TIMESTAMP,
    CONSTRAINT PK_TB_POST PRIMARY KEY (id)
    );

DROP TABLE IF EXISTS tb_file;

CREATE TABLE IF NOT EXISTS tb_file (
                                       id SERIAL NOT NULL,
                                       post_id SERIAL NOT NULL,
                                       original_name VARCHAR(1000) NOT NULL,
    save_name VARCHAR(1000) NOT NULL,
    size INT,
    delete_yn INT,
    created_date TIMESTAMP,
    modified_date TIMESTAMP,
    CONSTRAINT PK_TB_FILE PRIMARY KEY (id)
    );

DROP TABLE IF EXISTS tb_member;

CREATE TABLE IF NOT EXISTS tb_member (
                                         id SERIAL NOT NULL,
                                         login_id VARCHAR(20) NOT NULL,
    password VARCHAR(256) NOT NULL,
    name VARCHAR(100) NOT NULL,
    gender CHAR(1),
    birthday VARCHAR(8),
    delete_yn BOOLEAN,
    created_date TIMESTAMP,
    modified_date TIMESTAMP,
    CONSTRAINT PK_TB_MEMBER PRIMARY KEY (id)
    );