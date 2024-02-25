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
    void saveRrawExcel( RawDto rawDto);

    void deleteRawAll();

    /**
     * Raw 데이터 저장
     *
     * @param rawDto - Raw 데이터
     */
    void saveDanjiExcel( RawDto rawDto);

    void deleteDanjiAll();
}
