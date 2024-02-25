package octopus.domain.sample;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SampleService {

    private final SampleMapper sampleMapper;

    /**
     * 엑셀 저장
     *
     * @param rawList - 엑셀 데이터
     * @return Generated PK
     */
    @Transactional
    public void saveRrawExcel( final List<RawDto>  rawList) {

        for(RawDto rawDto : rawList) {
            sampleMapper.saveRrawExcel( rawDto );
        }

    }

    @Transactional
    public void deleteRawAll() {
        sampleMapper.deleteRawAll();
    }

    /**
     * 엑셀 저장
     *
     * @param rawList - 엑셀 데이터
     * @return Generated PK
     */
    @Transactional
    public void danjiExcelSave( final List<RawDto>  rawList) {

        for(RawDto rawDto : rawList) {
            sampleMapper.saveDanjiExcel( rawDto );
        }

    }

    @Transactional
    public void deleteDanjiAll() {
        sampleMapper.deleteDanjiAll();
    }
}
