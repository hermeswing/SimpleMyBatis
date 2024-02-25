package octopus.domain.sample;

import lombok.Data;

@Data
public class KbDto {

    private String sigu;                  // 시구코드              0
    private String url;                   // url                   1
    private String danji;                 // 단지기본일련번호      2
    private String sisemagam;             // 시세마감년월일        3
    private String sisemulgeon;           // 시세물건식별자        4
    private String danjinm;               // 단지명                5
    private String beobjek;               // 법정동코드            6
    private String gyeyag;                // 계약면적              7
    private String gonggub;               // 공급면적              8
    private String jeonyong;              // 전용면적              9
    private String type;                  // 주택형타입내용        10
    private String gubun;                 // 연결구분명            11
    private String maemaega1;             // 매매.하위평균         12
    private String maemaega2;             // 매매.일반평균         13
    private String maemaega3;             // 매매.상위평균         14
    private String jeonse1;               // 전세.하위평균         15
    private String jeonse2;               // 전세.일반평균         16
    private String jeonse3;               // 전세.상위평균         17
    private String juso;                  // 주소                  18
    private String wolse;                 // 월세                  19
    private String naver;                 // naver_code            20
    private String vcode;                 // 공급면적_내림         21

}