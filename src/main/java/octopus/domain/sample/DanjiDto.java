package octopus.domain.sample;

import lombok.Data;

@Data
public class DanjiDto {

    private Long id;                  // PK
    private String bunho;             // 코드번호     0
    private String doo;               // 도           1
    private String sigu;              // 시구         2
    private String hscpNo;            // hscpNo       3
    private String hscpNm;            // hscpNm       4
    private String jiyeog;            // 지역코드     5

}