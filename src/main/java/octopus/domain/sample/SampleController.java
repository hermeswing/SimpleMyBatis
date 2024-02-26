package octopus.domain.sample;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import octopus.base.common.dto.MessageDto;
import octopus.base.model.SingleResult;
import octopus.base.utils.FileUtils;
import octopus.base.utils.ResponseService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SampleController {
    private final ResponseService responseService;
    private final FileUtils fileUtils;
    private final SampleService sampleService;

    @Value( "${raw.file.path}" )
    private String rawFilePath;

    @Value( "${danji.file.path}" )
    private String danjiFilePath;

    @Value( "${basic.file.path}" )
    private String basicFilePath;

    @Value( "${pyeong.file.path}" )
    private String pyeongFilePath;

    @Value( "${jiyeog.file.path}" )
    private String jiyoegFilePath;

    @Value( "${kb.file.path}" )
    private String kbFilePath;

    @GetMapping( "/sample/sample.do" )
    public String openSample( Model model ) {
        log.debug( "여기" );
        return "sample/sample";
    }

    @PostMapping( "/sample/saveRawExcel.do" )
    public @ResponseBody SingleResult<MessageDto> saveRawExcel( Model model ) throws Exception {

        log.debug( "filePath :: {}", rawFilePath );
        File file = new File( rawFilePath );

        log.debug( "file.isFile() :: {}", file.isFile() );

        // 엑셀 파일 읽기
        FileInputStream fileInputStream = null;
        Workbook workbook = null;

        sampleService.deleteRawAll();

        try {
            // 엑셀 파일 읽기
            fileInputStream = new FileInputStream( file );
            workbook = WorkbookFactory.create( fileInputStream );

            log.debug( "시트갯수 :: {}", workbook.getNumberOfSheets() );

            Sheet sheet = workbook.getSheetAt( 1 );   // 첫 번째 시트 선택
            RawDto rawDto = null;
            List<RawDto> rawList = new ArrayList<>();
            // 각 행을 반복하면서 데이터 읽기
            for( Row row : sheet ) {
                if( row.getRowNum() == 0 ) continue;
                //if( row.getRowNum() > 50 ) continue;
                //if( row.getRowNum() <= 44100 ) continue;
                //if( row.getRowNum() >= 44150 ) break;

                rawDto = new RawDto();
                // 각 셀을 반복하면서 데이터 읽기
                for( Cell cell : row ) {
                    //log.debug( "Index :: {} cell.getStringCellValue() :: {}", cell.getColumnIndex(), convString(cell) );

                    switch( cell.getColumnIndex() ) {
                        case 0:       // 도
                            rawDto.setDoo( convString( cell ) );
                            break;
                        case 1:       // 시구
                            rawDto.setSigu( convString( cell ) );
                            break;
                        case 2:       // 동1
                            rawDto.setDong1( convString( cell ) );
                            break;
                        case 3:       // 동2
                            rawDto.setDong2( convString( cell ) );
                            break;
                        case 4:       // 매물번호
                            rawDto.setMaemul( convString( cell ) );
                            break;
                        case 5:       // 지역코드
                            rawDto.setJiyeog( convString( cell ) );
                            break;
                        case 6:       // 단지명
                            rawDto.setDanji( convString( cell ) );
                            break;
                        case 7:       // 월세
                            rawDto.setWolse( convString( cell ) );
                            break;
                        case 8:       // 부동산종류
                            rawDto.setJonglyu( convString( cell ) );
                            break;
                        case 9:       // 유형
                            rawDto.setYuhyeong( convString( cell ) );
                            break;
                        case 10:       // 층
                            rawDto.setCheung( convString( cell ) );
                            break;
                        case 11:       // 가격
                            rawDto.setGagyeog( convString( cell ) );
                            break;
                        case 12:       // 공급면적
                            rawDto.setMyeonjeog1( convString( cell ) );
                            break;
                        case 13:       // 전용면적
                            rawDto.setMyeonjeog2( convString( cell ) );
                            break;
                        case 14:       // 동
                            rawDto.setDong( convString( cell ) );
                            break;
                        case 15:       // 향
                            rawDto.setHyang( convString( cell ) );
                            break;
                        case 16:       // 확인일자
                            rawDto.setIlja( convString( cell ) );
                            break;
                        case 17:       // 비고
                            rawDto.setBigo( convString( cell ) );
                            break;
                        case 18:       // 가격2
                            rawDto.setGagyeog2( convString( cell ) );
                            break;
                        case 19:       // 가격3
                            rawDto.setGagyeog3( convString( cell ) );
                            break;
                        case 20:       // 매전구분
                            rawDto.setMaejeon( convString( cell ) );
                            break;
                        case 21:       // 평형
                            rawDto.setPyeong( convString( cell ) );
                            break;
                        case 22:       // 평형대
                            rawDto.setPyeongdae( convString( cell ) );
                            break;
                        case 23:       // 평당가
                            rawDto.setDanga( convString( cell ) );
                            break;
                        case 24:       // 표
                            rawDto.setPyo( convString( cell ) );
                            break;
                        case 25:       // 아파트코드_공급평형
                            rawDto.setApateu( convString( cell ) );
                            break;
                        case 26:       // KB매매시세
                            rawDto.setKbsise( convString( cell ) );
                            break;
                        case 27:       // KB매매하위시세
                            rawDto.setKbsise2( convString( cell ) );
                            break;
                        case 28:       // KB전세평균시세
                            rawDto.setKbsise3( convString( cell ) );
                            break;
                        case 29:       // 급매여부
                            rawDto.setGeubmae( convString( cell ) );
                            break;
                        case 30:       // 최저시세대비
                            rawDto.setChoejeo( convString( cell ) );
                            break;
                        case 31:       // 최저시세대비율
                            rawDto.setBiyul( convString( cell ) );
                            break;
                        case 32:       // 링크
                            rawDto.setLink1( convString( cell ) );
                            break;
                        case 33:       // m링크
                            rawDto.setLink2( convString( cell ) );
                            break;
                        case 34:       // pc링크
                            rawDto.setLink3( convString( cell ) );
                            break;
                        case 35:       // pclink
                            rawDto.setLink4( convString( cell ) );
                            break;
                    }
                }

                if( rawDto.getDoo() == null || rawDto.getDoo().isEmpty() ) continue;

                rawList.add( rawDto );
                if( row.getRowNum() % 100 == 0 ) {
                    sampleService.saveRawExcel( rawList );

                    //log.debug("100건 단위 :: {}", rawList);

                    rawList = new ArrayList<>();
                }
            }

            log.debug( "남은 데이터 :: {}", rawList );
            sampleService.saveRawExcel( rawList );

        } catch( IOException e ) {
            log.debug( "엑셀 파일을 읽는 중 오류 발생 :: {}", e.getMessage() );
        } finally {
            try {
                // 파일 스트림 닫기
                fileInputStream.close();
                workbook.close();
            } catch( IOException ioe ) {
                log.debug( "엑셀 파일을 닫는 중 오류 발생 :: {}", ioe.getMessage() );
            } catch( Exception e ) {
                log.debug( "오류 발생 :: {}", e.getMessage() );
            }
        }


        MessageDto message = new MessageDto( "성공하였습니다.", "/", RequestMethod.POST, null );
        return responseService.getSingleResult( message );
    }

    @PostMapping( "/sample/saveDanjiExcel.do" )
    public @ResponseBody SingleResult<MessageDto> saveDanjiExcel( Model model ) throws Exception {

        log.debug( "filePath :: {}", danjiFilePath );
        File file = new File( danjiFilePath );

        log.debug( "file.isFile() :: {}", file.isFile() );

        // 엑셀 파일 읽기
        FileInputStream fileInputStream = null;
        Workbook workbook = null;

        sampleService.deleteDanjiAll();

        try {
            // 엑셀 파일 읽기
            fileInputStream = new FileInputStream( file );
            workbook = WorkbookFactory.create( fileInputStream );

            log.debug( "시트갯수 :: {}", workbook.getNumberOfSheets() );

            Sheet sheet = workbook.getSheetAt( 1 );   // 첫 번째 시트 선택
            DanjiDto danjiDto = null;
            List<DanjiDto> danjiList = new ArrayList<>();
            // 각 행을 반복하면서 데이터 읽기
            for( Row row : sheet ) {
                if( row.getRowNum() == 0 ) continue;
                //if( row.getRowNum() > 50 ) continue;
                //if( row.getRowNum() >= 44150 ) break;

                danjiDto = new DanjiDto();
                // 각 셀을 반복하면서 데이터 읽기
                for( Cell cell : row ) {
                    //log.debug( "Index :: {} cell.getStringCellValue() :: {}", cell.getColumnIndex(), convString(cell) );

                    switch( cell.getColumnIndex() ) {
                        case 0:       // 코드번호
                            danjiDto.setBunho( convString( cell ) );
                            break;
                        case 1:       // 도
                            danjiDto.setDoo( convString( cell ) );
                            break;
                        case 2:       // 시구
                            danjiDto.setSigu( convString( cell ) );
                            break;
                        case 3:       // hscpNo
                            danjiDto.setHscpNo( convString( cell ) );
                            break;
                        case 4:       // hscpNm
                            danjiDto.setHscpNm( convString( cell ) );
                            break;
                        case 5:       // 지역코드
                            danjiDto.setJiyeog( convString( cell ) );
                            break;
                    }
                }

                if( danjiDto.getBunho() == null || danjiDto.getBunho().isEmpty() ) continue;

                danjiList.add( danjiDto );
                if( row.getRowNum() % 100 == 0 ) {
                    sampleService.saveDanjiExcel( danjiList );

                    //log.debug("100건 단위 :: {}", rawList);

                    danjiList = new ArrayList<>();
                }
            }

            log.debug( "남은 데이터 :: {}", danjiList );
            sampleService.saveDanjiExcel( danjiList );

        } catch( IOException e ) {
            log.debug( "엑셀 파일을 읽는 중 오류 발생 :: {}", e.getMessage() );
        } finally {
            try {
                // 파일 스트림 닫기
                fileInputStream.close();
                workbook.close();
            } catch( IOException ioe ) {
                log.debug( "엑셀 파일을 닫는 중 오류 발생 :: {}", ioe.getMessage() );
            } catch( Exception e ) {
                log.debug( "오류 발생 :: {}", e.getMessage() );
            }
        }


        MessageDto message = new MessageDto( "성공하였습니다.", "/", RequestMethod.POST, null );
        return responseService.getSingleResult( message );
    }

    @PostMapping( "/sample/saveBasicExcel.do" )
    public @ResponseBody SingleResult<MessageDto> saveBasicExcel( Model model ) throws Exception {

        log.debug( "filePath :: {}", basicFilePath );
        File file = new File( basicFilePath );

        log.debug( "file.isFile() :: {}", file.isFile() );

        // 엑셀 파일 읽기
        FileInputStream fileInputStream = null;
        Workbook workbook = null;

        sampleService.deleteBasicAll();

        try {
            // 엑셀 파일 읽기
            fileInputStream = new FileInputStream( file );
            workbook = WorkbookFactory.create( fileInputStream );

            log.debug( "시트갯수 :: {}", workbook.getNumberOfSheets() );

            Sheet sheet = workbook.getSheetAt( 1 );   // 첫 번째 시트 선택
            BasicDto basicDto = null;
            List<BasicDto> basicList = new ArrayList<>();
            // 각 행을 반복하면서 데이터 읽기
            for( Row row : sheet ) {
                if( row.getRowNum() == 0 ) continue;
                //if( row.getRowNum() > 50 ) continue;
                //if( row.getRowNum() >= 44150 ) break;

                basicDto = new BasicDto();
                // 각 셀을 반복하면서 데이터 읽기
                for( Cell cell : row ) {
                    //log.debug( "Index :: {} cell.getStringCellValue() :: {}", cell.getColumnIndex(), convString(cell) );

                    switch( cell.getColumnIndex() ) {
                        case 0:       // index
                            basicDto.setIndex( convString( cell ) );
                            break;
                        case 1:       // 코드번호
                            basicDto.setBunho( convString( cell ) );
                            break;
                        case 2:       // 도
                            basicDto.setDoo( convString( cell ) );
                            break;
                        case 3:       // 시구
                            basicDto.setSigu( convString( cell ) );
                            break;
                        case 4:       // hscpNo
                            basicDto.setHscpNo( convString( cell ) );
                            break;
                        case 5:       // hscpNm
                            basicDto.setHscpNm( convString( cell ) );
                            break;
                        case 6:       // url
                            basicDto.setUrl( convString( cell ) );
                            break;
                        case 7:       // 면적
                            basicDto.setMyeonjeog( convString( cell ) );
                            break;
                        case 8:       // 세대수
                            basicDto.setSedae( convString( cell ) );
                            break;
                        case 9:       // 최저/최고층
                            basicDto.setGocheung( convString( cell ) );
                            break;
                        case 10:       // 주차대수
                            basicDto.setJucha( convString( cell ) );
                            break;
                        case 11:       // 사용승인일
                            basicDto.setSayongil( convString( cell ) );
                            break;
                        case 12:       // 용적율
                            basicDto.setYongjeog( convString( cell ) );
                            break;
                        case 13:       // 건폐율
                            basicDto.setGeonpye( convString( cell ) );
                            break;
                        case 14:       // 건설사
                            basicDto.setGeonseol( convString( cell ) );
                            break;
                        case 15:       // 난방
                            basicDto.setNanbang( convString( cell ) );
                            break;
                        case 16:       // 지역코드
                            basicDto.setJiyeog( convString( cell ) );
                            break;
                        case 17:       // 주소
                            basicDto.setJuso( convString( cell ) );
                            break;
                        case 18:       // 도1
                            basicDto.setDo1( convString( cell ) );
                            break;
                        case 19:       // 시구1
                            basicDto.setSigu1( convString( cell ) );
                            break;
                        case 20:       // 동1
                            basicDto.setDong1( convString( cell ) );
                            break;
                        case 21:       // 동2
                            basicDto.setDong2( convString( cell ) );
                            break;
                    }
                }

                if( basicDto.getIndex() == null || basicDto.getIndex().isEmpty() ) continue;

                basicList.add( basicDto );
                if( row.getRowNum() % 100 == 0 ) {
                    sampleService.saveBasicExcel( basicList );

                    //log.debug("100건 단위 :: {}", rawList);
                    basicList = new ArrayList<>();
                }
            }

            log.debug( "남은 데이터 :: {}", basicList );
            sampleService.saveBasicExcel( basicList );

        } catch( IOException e ) {
            log.debug( "엑셀 파일을 읽는 중 오류 발생 :: {}", e.getMessage() );
        } finally {
            try {
                // 파일 스트림 닫기
                fileInputStream.close();
                workbook.close();
            } catch( IOException ioe ) {
                log.debug( "엑셀 파일을 닫는 중 오류 발생 :: {}", ioe.getMessage() );
            } catch( Exception e ) {
                log.debug( "오류 발생 :: {}", e.getMessage() );
            }
        }


        MessageDto message = new MessageDto( "성공하였습니다.", "/", RequestMethod.POST, null );
        return responseService.getSingleResult( message );
    }

    @PostMapping( "/sample/savePyeongExcel.do" )
    public @ResponseBody SingleResult<MessageDto> savePyeongExcel( Model model ) throws Exception {

        log.debug( "filePath :: {}", pyeongFilePath );
        File file = new File( pyeongFilePath );

        log.debug( "file.isFile() :: {}", file.isFile() );

        // 엑셀 파일 읽기
        FileInputStream fileInputStream = null;
        Workbook workbook = null;

        sampleService.deletePyeongAll();

        // 10억건의 데이터를 읽을 수 있도록 설정. Default 1억건.
        IOUtils.setByteArrayMaxOverride(1000000000);
        try {
            // 엑셀 파일 읽기
            fileInputStream = new FileInputStream( file );
            workbook = WorkbookFactory.create( fileInputStream );

            log.debug( "시트갯수 :: {}", workbook.getNumberOfSheets() );

            Sheet sheet = workbook.getSheetAt( 1 );   // 첫 번째 시트 선택
            PyeongDto pyeongDto = null;
            List<PyeongDto> pyeongList = new ArrayList<>();
            // 각 행을 반복하면서 데이터 읽기
            for( Row row : sheet ) {
                if( row.getRowNum() == 0 ) continue;
                //if( row.getRowNum() > 50 ) continue;
                //if( row.getRowNum() >= 44150 ) break;

                pyeongDto = new PyeongDto();
                // 각 셀을 반복하면서 데이터 읽기
                for( Cell cell : row ) {
                    //log.debug( "Index :: {} cell.getStringCellValue() :: {}", cell.getColumnIndex(), convString(cell) );

                    switch( cell.getColumnIndex() ) {
                        case 0:       // 코드번호
                            pyeongDto.setIndex( convString( cell ) );
                            break;
                        case 1:       // 코드번호
                            pyeongDto.setBunho( convString( cell ) );
                            break;
                        case 2:       // 도
                            pyeongDto.setDoo( convString( cell ) );
                            break;
                        case 3:       // 시구
                            pyeongDto.setSigu( convString( cell ) );
                            break;
                        case 4:       // hscpNo
                            pyeongDto.setHscpNo( convString( cell ) );
                            break;
                        case 5:       // hscpNm
                            pyeongDto.setHscpNm( convString( cell ) );
                            break;
                        case 6:       // url
                            pyeongDto.setUrl( convString( cell ) );
                            break;
                        case 7:       // ptpNo
                            pyeongDto.setPtpNo( convString( cell ) );
                            break;
                        case 8:       // ptpNm
                            pyeongDto.setPtpNm( convString( cell ) );
                            break;
                        case 9:       // splySpc
                            pyeongDto.setSplySpc( convString( cell ) );
                            break;
                        case 10:       // exclsSpc
                            pyeongDto.setExclsSpc( convString( cell ) );
                            break;
                        case 11:       // splySpcPyeong0WithUnit
                            pyeongDto.setSplySpcPyeong0WithUnit( convString( cell ) );
                            break;
                        case 12:       // splySpcPyeong2WithUnit
                            pyeongDto.setSplySpcPyeong2WithUnit( convString( cell ) );
                            break;
                        case 13:       // exclsSpcPyeong2WithUnit
                            pyeongDto.setExclsSpcPyeong2WithUnit( convString( cell ) );
                            break;
                        case 14:       // exclsRate
                            pyeongDto.setExclsRate( convString( cell ) );
                            break;
                        case 15:       // ptybyTotHsehCnt
                            pyeongDto.setPtybyTotHsehCnt( convString( cell ) );
                            break;
                        case 16:       // hscpTypeCd
                            pyeongDto.setHscpTypeCd( convString( cell ) );
                            break;
                        case 17:       // ptpOrder
                            pyeongDto.setPtpOrder( convString( cell ) );
                            break;
                        case 18:       // ptpNmWithUnit
                            pyeongDto.setPtpNmWithUnit( convString( cell ) );
                            break;
                        case 19:       // splySpcWithUnit
                            pyeongDto.setSplySpcWithUnit( convString( cell ) );
                            break;
                        case 20:       // exclsSpcWithUnit
                            pyeongDto.setExclsSpcWithUnit( convString( cell ) );
                            break;
                        case 21:       // roomCnt
                            pyeongDto.setRoomCnt( convString( cell ) );
                            break;
                        case 22:       // bathroomCnt
                            pyeongDto.setBathroomCnt( convString( cell ) );
                            break;
                        case 23:       // entranceType
                            pyeongDto.setEntranceType( convString( cell ) );
                            break;
                        case 24:       // splySpc2
                            pyeongDto.setSplySpc2( convString( cell ) );
                            break;
                        case 25:       // 공급면적
                            pyeongDto.setMyeonjeog1( convString( cell ) );
                            break;
                    }
                }

                if( pyeongDto.getBunho() == null || pyeongDto.getBunho().isEmpty() ) continue;

                pyeongList.add( pyeongDto );
                if( row.getRowNum() % 100 == 0 ) {
                    sampleService.savePyeongExcel( pyeongList );

                    //log.debug("100건 단위 :: {}", rawList);
                    pyeongList = new ArrayList<>();
                }
            }

            log.debug( "남은 데이터 :: {}", pyeongList );
            sampleService.savePyeongExcel( pyeongList );

        } catch( IOException e ) {
            log.debug( "엑셀 파일을 읽는 중 오류 발생 :: {}", e.getMessage() );
        } finally {
            try {
                // 파일 스트림 닫기
                fileInputStream.close();
                workbook.close();
            } catch( IOException ioe ) {
                log.debug( "엑셀 파일을 닫는 중 오류 발생 :: {}", ioe.getMessage() );
            } catch( Exception e ) {
                log.debug( "오류 발생 :: {}", e.getMessage() );
            }
        }


        MessageDto message = new MessageDto( "성공하였습니다.", "/", RequestMethod.POST, null );
        return responseService.getSingleResult( message );
    }

    @PostMapping( "/sample/saveJiyeogExcel.do" )
    public @ResponseBody SingleResult<MessageDto> saveJiyeogExcel( Model model ) throws Exception {

        log.debug( "filePath :: {}", jiyoegFilePath );
        File file = new File( jiyoegFilePath );

        log.debug( "file.isFile() :: {}", file.isFile() );

        // 엑셀 파일 읽기
        FileInputStream fileInputStream = null;
        Workbook workbook = null;

        sampleService.deleteJiyeogAll();

        try {
            // 엑셀 파일 읽기
            fileInputStream = new FileInputStream( file );
            workbook = WorkbookFactory.create( fileInputStream );

            log.debug( "시트갯수 :: {}", workbook.getNumberOfSheets() );

            Sheet sheet = workbook.getSheetAt( 1 );   // 첫 번째 시트 선택
            JiyeogDto jiyeogDto = null;
            List<JiyeogDto> jiyeogList = new ArrayList<>();
            // 각 행을 반복하면서 데이터 읽기
            for( Row row : sheet ) {
                if( row.getRowNum() == 0 ) continue;
                //if( row.getRowNum() > 50 ) continue;
                //if( row.getRowNum() >= 44150 ) break;

                jiyeogDto = new JiyeogDto();
                // 각 셀을 반복하면서 데이터 읽기
                for( Cell cell : row ) {
                    //log.debug( "Index :: {} cell.getStringCellValue() :: {}", cell.getColumnIndex(), convString(cell) );

                    switch( cell.getColumnIndex() ) {
                        case 0:       // 도코드
                            jiyeogDto.setDoo( convString( cell ) );
                            break;
                        case 1:       // 시구코드
                            jiyeogDto.setSigu( convString( cell ) );
                            break;
                        case 2:       // 동코드
                            jiyeogDto.setDong( convString( cell ) );
                            break;
                        case 3:       // 코드8
                            jiyeogDto.setCode( convString( cell ) );
                            break;
                        case 4:       // 법정동코드
                            jiyeogDto.setBeobjeong( convString( cell ) );
                            break;
                        case 5:       // 도
                            jiyeogDto.setDo1( convString( cell ) );
                            break;
                        case 6:       // 시구
                            jiyeogDto.setSigu1( convString( cell ) );
                            break;
                        case 7:       // 동1
                            jiyeogDto.setDong1( convString( cell ) );
                            break;
                        case 8:       // 동2
                            jiyeogDto.setDong2( convString( cell ) );
                            break;
                    }
                }

                if( jiyeogDto.getDoo() == null || jiyeogDto.getDoo().isEmpty() ) continue;

                jiyeogList.add( jiyeogDto );
                if( row.getRowNum() % 100 == 0 ) {
                    sampleService.saveJiyeogExcel( jiyeogList );

                    //log.debug("100건 단위 :: {}", rawList);
                    jiyeogList = new ArrayList<>();
                }
            }

            log.debug( "남은 데이터 :: {}", jiyeogList );
            sampleService.saveJiyeogExcel( jiyeogList );

        } catch( IOException e ) {
            log.debug( "엑셀 파일을 읽는 중 오류 발생 :: {}", e.getMessage() );
        } finally {
            try {
                // 파일 스트림 닫기
                fileInputStream.close();
                workbook.close();
            } catch( IOException ioe ) {
                log.debug( "엑셀 파일을 닫는 중 오류 발생 :: {}", ioe.getMessage() );
            } catch( Exception e ) {
                log.debug( "오류 발생 :: {}", e.getMessage() );
            }
        }


        MessageDto message = new MessageDto( "성공하였습니다.", "/", RequestMethod.POST, null );
        return responseService.getSingleResult( message );
    }

    @PostMapping( "/sample/saveKbExcel.do" )
    public @ResponseBody SingleResult<MessageDto> saveKbExcel( Model model ) throws Exception {

        log.debug( "filePath :: {}", kbFilePath );
        File file = new File( kbFilePath );

        log.debug( "file.isFile() :: {}", file.isFile() );

        // 엑셀 파일 읽기
        FileInputStream fileInputStream = null;
        Workbook workbook = null;

        sampleService.deleteKbAll();

        try {
            // 엑셀 파일 읽기
            fileInputStream = new FileInputStream( file );
            workbook = WorkbookFactory.create( fileInputStream );

            log.debug( "시트갯수 :: {}", workbook.getNumberOfSheets() );

            Sheet sheet = workbook.getSheetAt( 1 );   // 첫 번째 시트 선택
            KbDto kbDto = null;
            List<KbDto> kbList = new ArrayList<>();
            // 각 행을 반복하면서 데이터 읽기
            for( Row row : sheet ) {
                if( row.getRowNum() == 0 ) continue;
                //if( row.getRowNum() > 50 ) continue;
                //if( row.getRowNum() >= 44150 ) break;

                kbDto = new KbDto();
                // 각 셀을 반복하면서 데이터 읽기
                for( Cell cell : row ) {
                    //log.debug( "Index :: {} cell.getStringCellValue() :: {}", cell.getColumnIndex(), convString(cell) );

                    switch( cell.getColumnIndex() ) {
                        case 0:       // 시구
                            kbDto.setSigu( convString( cell ) );
                            break;
                        case 1:       // url
                            kbDto.setUrl( convString( cell ) );
                            break;
                        case 2:       // 단지기본일련번호
                            kbDto.setDanji( convString( cell ) );
                            break;
                        case 3:       // 시세마감년월일
                            kbDto.setSisemagam( convString( cell ) );
                            break;
                        case 4:       // 시세물건식별자
                            kbDto.setSisemulgeon( convString( cell ) );
                            break;
                        case 5:       // 단지명
                            kbDto.setDanjinm( convString( cell ) );
                            break;
                        case 6:       // 법정동코드
                            kbDto.setBeobjek( convString( cell ) );
                            break;
                        case 7:       // 계약면적
                            kbDto.setGyeyag( convString( cell ) );
                            break;
                        case 8:       // 공급면적
                            kbDto.setGonggub( convString( cell ) );
                            break;
                        case 9:       // 전용면적
                            kbDto.setJeonyong( convString( cell ) );
                            break;
                        case 10:       // 주택형타입내용
                            kbDto.setType( convString( cell ) );
                            break;
                        case 11:       // 연결구분명
                            kbDto.setGubun( convString( cell ) );
                            break;
                        case 12:       // 매매.하위평균
                            kbDto.setMaemaega1( convString( cell ) );
                            break;
                        case 13:       // 매매.일반평균
                            kbDto.setMaemaega2( convString( cell ) );
                            break;
                        case 14:       // 매매.상위평균
                            kbDto.setMaemaega3( convString( cell ) );
                            break;
                        case 15:       // 전세.하위평균
                            kbDto.setJeonse1( convString( cell ) );
                            break;
                        case 16:       // 전세.일반평균
                            kbDto.setJeonse2( convString( cell ) );
                            break;
                        case 17:       // 전세.상위평균
                            kbDto.setJeonse3( convString( cell ) );
                            break;
                        case 18:       // 주소
                            kbDto.setJuso( convString( cell ) );
                            break;
                        case 19:       // 월세
                            kbDto.setWolse( convString( cell ) );
                            break;
                        case 20:       // naver_code
                            kbDto.setNaver( convString( cell ) );
                            break;
                        case 21:       // 공급면적_내림
                            kbDto.setVcode( convString( cell ) );
                            break;
                    }
                }

                if( kbDto.getSigu() == null || kbDto.getSigu().isEmpty() ) continue;

                kbList.add( kbDto );
                if( row.getRowNum() % 100 == 0 ) {
                    sampleService.saveKbExcel( kbList );

                    //log.debug("100건 단위 :: {}", rawList);

                    kbList = new ArrayList<>();
                }
            }

            log.debug( "남은 데이터 :: {}", kbList );
            sampleService.saveKbExcel( kbList );

        } catch( IOException e ) {
            log.debug( "엑셀 파일을 읽는 중 오류 발생 :: {}", e.getMessage() );
        } finally {
            try {
                // 파일 스트림 닫기
                fileInputStream.close();
                workbook.close();
            } catch( IOException ioe ) {
                log.debug( "엑셀 파일을 닫는 중 오류 발생 :: {}", ioe.getMessage() );
            } catch( Exception e ) {
                log.debug( "오류 발생 :: {}", e.getMessage() );
            }
        }


        MessageDto message = new MessageDto( "성공하였습니다.", "/", RequestMethod.POST, null );
        return responseService.getSingleResult( message );
    }

    /**
     * Cell 객체를 문자로 변경
     */
    public String convString( Cell cell ) {
        String returnValue = "";

        switch( cell.getCellType() ) {
            case STRING:
                returnValue = cell.getStringCellValue();
                break;
            case NUMERIC:
                returnValue = String.format( "%.0f", cell.getNumericCellValue() );
                break;
            case BOOLEAN:
                returnValue = cell.getBooleanCellValue() ? "Y" : "N";
                break;
            case FORMULA:
                returnValue = cell.getCellFormula().toString();
                break;
            default:
                returnValue = cell.getStringCellValue();
        }

        return returnValue;
    }
}
