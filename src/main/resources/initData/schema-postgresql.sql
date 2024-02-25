DROP TABLE IF EXISTS tb_post;

CREATE TABLE IF NOT EXISTS tb_post (
    id            SERIAL NOT NULL,
    title         VARCHAR(10) NOT NULL,
    content       VARCHAR(3000) NOT NULL,
    writer        VARCHAR(20) NOT NULL,
    view_cnt      INT,
    notice_yn     BOOLEAN,
    delete_yn     INT,
    created_date  TIMESTAMP,
    modified_date TIMESTAMP,
    CONSTRAINT PK_TB_POST PRIMARY KEY (id)
);

DROP TABLE IF EXISTS tb_comment;

CREATE TABLE IF NOT EXISTS tb_comment (
    id            SERIAL NOT NULL,
    post_id       DECIMAL NOT NULL,
    content       VARCHAR(3000) NOT NULL,
    writer        VARCHAR(20) NOT NULL,
    delete_yn     INT,
    created_date  TIMESTAMP,
    modified_date TIMESTAMP,
    CONSTRAINT PK_TB_COMMENT PRIMARY KEY (id, post_id)
);

DROP TABLE IF EXISTS tb_file;

CREATE TABLE IF NOT EXISTS tb_file (
    id            SERIAL NOT NULL,
    post_id       DECIMAL NOT NULL,
    original_name VARCHAR(1000) NOT NULL,
    save_name     VARCHAR(1000) NOT NULL,
    size          INT,
    delete_yn     INT,
    deleted_date  TIMESTAMP,
    created_date  TIMESTAMP,
    modified_date TIMESTAMP,
    CONSTRAINT PK_TB_FILE PRIMARY KEY (id)
);

DROP TABLE IF EXISTS tb_member;

CREATE TABLE IF NOT EXISTS tb_member (
    id            SERIAL NOT NULL,
    login_id      VARCHAR(20) NOT NULL,
    password      VARCHAR(256) NOT NULL,
    name          VARCHAR(100) NOT NULL,
    gender        CHAR(1),
    birthday      VARCHAR(8),
    delete_yn     BOOLEAN,
    created_date  TIMESTAMP,
    modified_date TIMESTAMP,
    CONSTRAINT PK_TB_MEMBER PRIMARY KEY (id)
);


DROP TABLE IF EXISTS tb_raw;

CREATE TABLE IF NOT EXISTS tb_raw (
    id         SERIAL NOT NULL,       -- PK
    doo        VARCHAR(100) NOT NULL, -- 도
    sigu       VARCHAR(100) NOT NULL, -- 시구
    dong1      VARCHAR(100),          -- 동1
    dong2      VARCHAR(100),          -- 동2
    maemul     VARCHAR(30),           -- 매물번호
    jiyeog     VARCHAR(30),           -- 지역코드
    danji      VARCHAR(1000),         -- 단지명
    wolse      VARCHAR(30),           -- 월세
    jonglyu    VARCHAR(30),           -- 부동산종류
    yuhyeong   VARCHAR(30),           -- 유형
    cheung     VARCHAR(30),           -- 층
    gagyeog    VARCHAR(30),           -- 가격
    myeonjeog1 VARCHAR(30),           -- 공급면적
    myeonjeog2 VARCHAR(30),           -- 전용면적
    dong       VARCHAR(30),           -- 동
    hyang      VARCHAR(30),           -- 향
    ilja       VARCHAR(30),           -- 확인일자
    bigo       VARCHAR(3000),         -- 비고
    gagyeog2   VARCHAR(30),           -- 가격2
    gagyeog3   VARCHAR(30),           -- 가격3
    maejeon    VARCHAR(30),           -- 매진구분
    pyeong     VARCHAR(30),           -- 평형
    pyeongdae  VARCHAR(30),           -- 평형대
    danga      VARCHAR(30),           -- 평당가
    pyo        VARCHAR(30),           -- 표
    apateu     VARCHAR(30),           -- 아파트코드_공급평형
    kbsise     VARCHAR(30),           -- KB매매시세
    kbsise2    VARCHAR(30),           -- KB매매하위시세
    kbsise3    VARCHAR(30),           -- KB전세평균시세
    geubmae    VARCHAR(30),           -- 급매여부
    choejeo    VARCHAR(30),           -- 최저시세대비
    biyul      VARCHAR(30),           -- 최저시세대비율
    link1      VARCHAR(300),          -- 링크
    link2      VARCHAR(300),          -- m링크
    link3      VARCHAR(300),          -- pc링크
    link4      VARCHAR(300),          -- pclink
    CONSTRAINT PK_TB_RAW PRIMARY KEY (id)
);


DROP TABLE IF EXISTS tb_danji;

CREATE TABLE IF NOT EXISTS tb_danji (
    id     SERIAL NOT NULL,       -- PK
    bunho  VARCHAR(30) NOT NULL,  -- 코드번호
    doo    VARCHAR(100) NOT NULL, -- 도
    sigu   VARCHAR(100) NOT NULL, -- 시구
    hscpNo VARCHAR(30),           -- hscpNo
    hscpNm VARCHAR(300),          -- hscpNm
    jiyeog VARCHAR(30),           -- 지역코드
    CONSTRAINT PK_TB_DANJI PRIMARY KEY (id)
);


DROP TABLE IF EXISTS tb_basic;

CREATE TABLE IF NOT EXISTS tb_basic (
    id        SERIAL NOT NULL,       -- PK
    index     VARCHAR(10) NOT NULL,  -- index
    bunho     VARCHAR(30) NOT NULL,  -- 코드번호
    doo       VARCHAR(100) NOT NULL, -- 도
    sigu      VARCHAR(100) NOT NULL, -- 시구
    hscpNo    VARCHAR(30),           -- hscpNo
    hscpNm    VARCHAR(300),          -- hscpNm
    url       VARCHAR(150),          -- url
    myeonjeog VARCHAR(30),           -- 면적
    sedae     VARCHAR(150),          -- 세대수
    gocheung  VARCHAR(30),           -- 최저/최고층
    jucha     VARCHAR(50),           -- 주차대수
    sayongil  VARCHAR(150),          -- 사용승인일
    yongjeog  VARCHAR(10),           -- 용적율
    geonpye   VARCHAR(10),           -- 건폐율
    geonseol  VARCHAR(300),          -- 건설사
    nanbang   VARCHAR(50),           -- 난방
    jiyeog    VARCHAR(30),           -- 지역코드
    juso      VARCHAR(300),          -- 주소
    do1       VARCHAR(30),           -- 도1
    sigu1     VARCHAR(30),           -- 시구1
    dong1     VARCHAR(30),           -- 동1
    dong2     VARCHAR(30),           -- 동2
    CONSTRAINT PK_TB_BASIC PRIMARY KEY (id)
);


DROP TABLE IF EXISTS tb_pyeong;

CREATE TABLE IF NOT EXISTS tb_pyeong (
    id                      SERIAL NOT NULL,       -- PK
    bunho                   VARCHAR(30) NOT NULL,  -- 코드번호
    doo                     VARCHAR(100) NOT NULL, -- 도
    sigu                    VARCHAR(100) NOT NULL, -- 시구
    hscpNo                  VARCHAR(30),           -- hscpNo
    hscpNm                  VARCHAR(300),          -- hscpNm
    url                     VARCHAR(150),          -- url
    ptpNo                   VARCHAR(10),           -- ptpNo
    ptpNm                   VARCHAR(10),           -- ptpNm
    splySpc                 VARCHAR(10),           -- splySpc
    exclsSpc                VARCHAR(10),           -- exclsSpc
    splySpcPyeong0WithUnit  VARCHAR(30),           -- splySpcPyeong0WithUnit
    splySpcPyeong2WithUnit  VARCHAR(30),           -- splySpcPyeong2WithUnit
    exclsSpcPyeong2WithUnit VARCHAR(10),           -- exclsSpcPyeong2WithUnit
    exclsRate               VARCHAR(10),           -- exclsRate
    ptybyTotHsehCnt         VARCHAR(10),           -- ptybyTotHsehCnt
    hscpTypeCd              VARCHAR(10),           -- hscpTypeCd
    ptpOrder                VARCHAR(10),           -- ptpOrder
    ptpNmWithUnit           VARCHAR(30),           -- ptpNmWithUnit
    splySpcWithUnit         VARCHAR(30),           -- splySpcWithUnit
    exclsSpcWithUnit        VARCHAR(30),           -- exclsSpcWithUnit
    roomCnt                 VARCHAR(10),           -- roomCnt
    bathroomCnt             VARCHAR(10),           -- bathroomCnt
    entranceType            VARCHAR(30),           -- entranceType
    splySpc2                VARCHAR(30),           -- splySpc2
    myeonjeog1              VARCHAR(30),           -- 공급면적
    CONSTRAINT PK_TB_PYEONG PRIMARY KEY (id)
);


DROP TABLE IF EXISTS tb_jiyeog;

CREATE TABLE IF NOT EXISTS tb_jiyeog (
    id        SERIAL NOT NULL,      -- PK
    doo       VARCHAR(10) NOT NULL, -- 도코드
    sigu      VARCHAR(10) NOT NULL, -- 시구코드
    dong      VARCHAR(10),          -- 동코드
    code      VARCHAR(20),          -- 코드8
    beobjeong VARCHAR(20),          -- 법정동코드
    do1       VARCHAR(100),         -- 도
    sigu1     VARCHAR(100),         -- 시구
    dong1     VARCHAR(30),          -- 동1
    dong2     VARCHAR(30),          -- 동2
    CONSTRAINT PK_TB_JIYEOG PRIMARY KEY (id)
);


DROP TABLE IF EXISTS tb_kb;

CREATE TABLE IF NOT EXISTS tb_kb (
    id          SERIAL NOT NULL,      -- PK
    sigu        VARCHAR(10) NOT NULL, -- 시구코드
    url         VARCHAR(150),         -- url
    danji       VARCHAR(10),          -- 단지기본일련번호
    sisemagam   VARCHAR(10),          -- 시세마감년월일
    sisemulgeon VARCHAR(20),          -- 시세물건식별자
    danjinm     VARCHAR(100),         -- 단지명
    beobjek     VARCHAR(20),          -- 법정동코드
    gyeyag      VARCHAR(30),          -- 계약면적
    gonggub     VARCHAR(30),          -- 공급면적
    jeonyong    VARCHAR(30),          -- 전용면적
    type        VARCHAR(30),          -- 주택형타입내용
    gubun       VARCHAR(30),          -- 연결구분명
    maemaega1   VARCHAR(30),          -- 매매.하위평균
    maemaega2   VARCHAR(30),          -- 매매.일반평균
    maemaega3   VARCHAR(30),          -- 매매.상위평균
    jeonse1     VARCHAR(30),          -- 전세.하위평균
    jeonse2     VARCHAR(30),          -- 전세.일반평균
    jeonse3     VARCHAR(30),          -- 전세.상위평균
    juso        VARCHAR(300),         -- 주소
    wolse       VARCHAR(30),          -- 월세
    naver       VARCHAR(30),          -- naver_code
    vcode       VARCHAR(30),          -- 공급면적_내림
    CONSTRAINT PK_TB_KB PRIMARY KEY (id)
);
