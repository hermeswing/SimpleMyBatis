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

DROP TABLE IF EXISTS tb_comment;

CREATE TABLE IF NOT EXISTS tb_comment (
    id SERIAL NOT NULL,
    post_id DECIMAL NOT NULL,
    content VARCHAR(3000) NOT NULL,
    writer VARCHAR(20) NOT NULL,
    delete_yn INT,
    created_date TIMESTAMP,
    modified_date TIMESTAMP,
    CONSTRAINT PK_TB_COMMENT PRIMARY KEY (id, post_id)
);

DROP TABLE IF EXISTS tb_file;

CREATE TABLE IF NOT EXISTS tb_file (
    id SERIAL NOT NULL,
    post_id DECIMAL NOT NULL,
    original_name VARCHAR(1000) NOT NULL,
    save_name VARCHAR(1000) NOT NULL,
    size INT,
    delete_yn INT,
    deleted_date TIMESTAMP,
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


DROP TABLE IF EXISTS tb_raw;

CREATE TABLE IF NOT EXISTS tb_raw (
    id SERIAL NOT NULL,              -- PK
    doo VARCHAR(100) NOT NULL,       -- 도
    sigu VARCHAR(100) NOT NULL,      -- 시구
    dong1 VARCHAR(100),              -- 동1
    dong2 VARCHAR(100),                 -- 동2
    maemul VARCHAR(30),              -- 매물번호
    jiyeog VARCHAR(30),              -- 지역코드
    danji VARCHAR(1000),             -- 단지명
    wolse VARCHAR(30),               -- 월세
    jonglyu VARCHAR(30),             -- 부동산종류
    yuhyeong VARCHAR(30),            -- 유형
    cheung VARCHAR(30),              -- 층
    gagyeog VARCHAR(30),                 -- 가격
    myeonjeog1 VARCHAR(30),          -- 공급면적
    myeonjeog2 VARCHAR(30),          -- 전용면적
    dong VARCHAR(30),                -- 동
    hyang VARCHAR(30),               -- 향
    ilja VARCHAR(30),                 -- 확인일자
    bigo VARCHAR(3000),              -- 비고
    gagyeog2 VARCHAR(30),                -- 가격2
    gagyeog3 VARCHAR(30),                -- 가격3
    maejeon VARCHAR(30),             -- 매진구분
    pyeong VARCHAR(30),              -- 평형
    pyeongdae VARCHAR(30),           -- 평형대
    danga VARCHAR(30),                   -- 평당가
    pyo VARCHAR(30),                 -- 표
    apateu VARCHAR(30),              -- 아파트코드_공급평형
    kbsise VARCHAR(30),                  -- KB매매시세
    kbsise2 VARCHAR(30),                 -- KB매매하위시세
    kbsise3 VARCHAR(30),                 -- KB전세평균시세
    geubmae VARCHAR(30),             -- 급매여부
    choejeo VARCHAR(30),             -- 최저시세대비
    biyul VARCHAR(30),               -- 최저시세대비율
    link1 VARCHAR(300),               -- 링크
    link2 VARCHAR(300),              -- m링크
    link3 VARCHAR(300),              -- pc링크
    link4 VARCHAR(300),               -- pclink
    CONSTRAINT PK_TB_RAW PRIMARY KEY (id)
);