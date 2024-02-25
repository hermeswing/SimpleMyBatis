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
    void save( RawDto rawDto);

    void deleteAll();
}
