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
    public void saveRawExcel( final List<RawDto> rawList ) {

        for( RawDto rawDto : rawList ) {
            sampleMapper.saveRawExcel( rawDto );
        }

    }

    @Transactional
    public void deleteRawAll() {
        sampleMapper.deleteRawAll();
    }

    /**
     * 엑셀 저장
     *
     * @param danjiList - 엑셀 데이터
     * @return Generated PK
     */
    @Transactional
    public void saveDanjiExcel( final List<DanjiDto> danjiList ) {

        for( DanjiDto danjiDto : danjiList ) {
            sampleMapper.saveDanjiExcel( danjiDto );
        }

    }

    @Transactional
    public void deleteDanjiAll() {
        sampleMapper.deleteDanjiAll();
    }

    /**
     * 엑셀 저장
     *
     * @param basicList - 엑셀 데이터
     * @return Generated PK
     */
    @Transactional
    public void saveBasicExcel( final List<BasicDto> basicList ) {

        for( BasicDto basicDto : basicList ) {
            sampleMapper.saveBasicExcel( basicDto );
        }

    }

    @Transactional
    public void deleteBasicAll() {
        sampleMapper.deleteBasicAll();
    }

    /**
     * 엑셀 저장
     *
     * @param pyeongList - 엑셀 데이터
     * @return Generated PK
     */
    @Transactional
    public void savePyeongExcel( final List<PyeongDto> pyeongList ) {

        for( PyeongDto pyeongDto : pyeongList ) {
            sampleMapper.savePyeongExcel( pyeongDto );
        }

    }

    @Transactional
    public void deletePyeongAll() {
        sampleMapper.deletePyeongAll();
    }

    /**
     * 엑셀 저장
     *
     * @param jiyeogList - 엑셀 데이터
     * @return Generated PK
     */
    @Transactional
    public void saveJiyeogExcel( final List<JiyeogDto> jiyeogList ) {

        for( JiyeogDto jiyeogDto : jiyeogList ) {
            sampleMapper.saveJiyeogExcel( jiyeogDto );
        }

    }

    @Transactional
    public void deleteJiyeogAll() {
        sampleMapper.deleteJiyeogAll();
    }

    /**
     * 엑셀 저장
     *
     * @param kbList - 엑셀 데이터
     * @return Generated PK
     */
    @Transactional
    public void saveKbExcel( final List<KbDto> kbList ) {

        for( KbDto kbDto : kbList ) {
            sampleMapper.saveKbExcel( kbDto );
        }

    }

    @Transactional
    public void deleteKbAll() {
        sampleMapper.deleteKbAll();
    }
}
