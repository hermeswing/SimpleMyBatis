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
    public void saveExcel( final List<RawDto>  rawList) {

        for(RawDto rawDto : rawList) {
            sampleMapper.save( rawDto );
        }

    }

    @Transactional
    public void deleteAll() {
        sampleMapper.deleteAll();
    }
}
