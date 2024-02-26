package octopus.domain.sample;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {

    /**
     * Raw 데이터 저장
     *
     * @param rawDto - Raw 데이터
     */
    //void save( List<RawDto> rawList);
    void saveRawExcel( RawDto rawDto);

    void deleteRawAll();

    /**
     * 단지정보 데이터 저장
     *
     * @param danjiDto - 단지정보 데이터
     */
    void saveDanjiExcel( DanjiDto danjiDto);

    void deleteDanjiAll();

    /**
     * 기본정보 데이터 저장
     *
     * @param basicDto - 기본정보 데이터
     */
    void saveBasicExcel( BasicDto basicDto);

    void deleteBasicAll();

    /**
     * 평형정보 데이터 저장
     *
     * @param pyeongDto - 평형정보 데이터
     */
    void savePyeongExcel( PyeongDto pyeongDto);

    void deletePyeongAll();

    /**
     * 지역정보 데이터 저장
     *
     * @param jiyeogDto - 지역정보 데이터
     */
    void saveJiyoegExcel( JiyeogDto jiyeogDto);

    void deleteJiyoegAll();

    /**
     * KB 데이터 저장
     *
     * @param kbDto - KB 데이터
     */
    void saveKbExcel( KbDto kbDto);

    void deleteKbAll();
}
