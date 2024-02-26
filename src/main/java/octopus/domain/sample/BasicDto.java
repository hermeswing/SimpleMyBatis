package octopus.domain.sample;

import lombok.Data;

@Data
public class BasicDto {

    private Long id;                   // PK
    private String index;              // index          0
    private String bunho;              // 코드번호       1
    private String doo;                // 도             2
    private String sigu;               // 시구           3
    private String hscpNo;             // hscpNo         4
    private String hscpNm;             // hscpNm         5
    private String url;                // url            6
    private String myeonjeog;          // 면적           7
    private String sedae;              // 세대수         8
    private String gocheung;           // 최저/최고층    9
    private String jucha;              // 주차대수       10
    private String sayongil;           // 사용승인일     11
    private String yongjeog;           // 용적율         12
    private String geonpye;            // 건폐율         13
    private String geonseol;           // 건설사         14
    private String nanbang;            // 난방           15
    private String jiyeog;             // 지역코드       16
    private String juso;               // 주소           17
    private String do1;                // 도1            18
    private String sigu1;              // 시구1          19
    private String dong1;              // 동1            20
    private String dong2;              // 동2            21

}