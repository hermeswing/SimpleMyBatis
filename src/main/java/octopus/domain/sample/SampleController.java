package octopus.domain.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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
                if( row.getRowNum() <= 44100 ) continue;
                if( row.getRowNum() >= 44150 ) break;

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
                    //sampleService.saveRrawExcel( rawList );

                    //log.debug("100건 단위 :: {}", rawList);

                    rawList = new ArrayList<>();
                }
            }

            log.debug( "남은 데이터 :: {}", rawList );
            //sampleService.saveRrawExcel( rawList );

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

        sampleService.deleteRawAll();

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
                if( row.getRowNum() <= 50 ) continue;
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

                if( danjiDto.getDoo() == null || danjiDto.getDoo().isEmpty() ) continue;

                danjiList.add( danjiDto );
                if( row.getRowNum() % 100 == 0 ) {
                    //sampleService.rawExcelSave( rawList );

                    //log.debug("100건 단위 :: {}", rawList);

                    danjiList = new ArrayList<>();
                }
            }

            log.debug( "남은 데이터 :: {}", danjiList );
            //sampleService.rawExcelSave( rawList );

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
