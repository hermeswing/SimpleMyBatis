package octopus.domain.sample;

import lombok.Data;

@Data
public class PyeongDto {

    private Long id;                                 // PK
    private String index;                            // index                          0
    private String bunho;                            // 코드번호                       1
    private String doo;                              // 도                             2
    private String sigu;                             // 시구                           3
    private String hscpNo;                           // hscpNo                         4
    private String hscpNm;                           // hscpNm                         5
    private String url;                              // url                            6
    private String ptpNo;                            // ptpNo                          7
    private String ptpNm;                            // ptpNm                          8
    private String splySpc;                          // splySpc                        9
    private String exclsSpc;                         // exclsSpc                       10
    private String splySpcPyeong0WithUnit;           // splySpcPyeong0WithUnit         11
    private String splySpcPyeong2WithUnit;           // splySpcPyeong2WithUnit         12
    private String exclsSpcPyeong2WithUnit;          // exclsSpcPyeong2WithUnit        13
    private String exclsRate;                        // exclsRate                      14
    private String ptybyTotHsehCnt;                  // ptybyTotHsehCnt                15
    private String hscpTypeCd;                       // hscpTypeCd                     16
    private String ptpOrder;                         // ptpOrder                       17
    private String ptpNmWithUnit;                    // ptpNmWithUnit                  18
    private String splySpcWithUnit;                  // splySpcWithUnit                19
    private String exclsSpcWithUnit;                 // exclsSpcWithUnit               20
    private String roomCnt;                          // roomCnt                        21
    private String bathroomCnt;                      // bathroomCnt                    22
    private String entranceType;                     // entranceType                   23
    private String splySpc2;                         // splySpc2                       24
    private String myeonjeog1;                       // 공급면적                       25

}