package com.saiha.util.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Properties;


public class FileUtil {

    @Resource(name = "fileProperties")
    private Properties fileProperties;

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);



    /** 서버에 파일 저장시 파일명 중복을 피하기 위한 TimeStamp 생성 **/
    private String getTimeStamp() {
        String rtnStr = null;

        //문자열로 변환하기 위한 패턴 설정(년도-월-일 시:분:초:초)
        String pattern = "yyyyMMddHHmmssSSS";

        try {
            SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern, Locale.KOREA);
            Timestamp ts = new Timestamp(System.currentTimeMillis());

            rtnStr = sdfCurrent.format(ts.getTime());
        } catch (Exception e) {
            //e.printStackTrace();
            LOGGER.debug("FileUtil > getTimeStamp() > " + e.getMessage());
        }

        return rtnStr;
    }


    /** 파일업로드시 허용된 파일 확장자 여부 체크 **/
    public boolean allowFileExt(List<String> arrAllowExt, String ext) {
        boolean retFlg = false;

        try {
            if(ext == null || "".equals(ext)) {
                throw new FileNotFoundException("파일 및 확장자가 존재하지 않습니다.");
            }
            for(String strAllowExt : arrAllowExt) {
                if(ext.equalsIgnoreCase(strAllowExt)) {
                    retFlg = true;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retFlg;
    }


    /**
     * Comment : 디렉토리(파일)를 삭제한다. (파일,디렉토리 구분없이 존재하는 경우 무조건 삭제한다)
     *
     * @param filePath 삭제하고자 하는 파일의 절대경로 + 파일명
     * @return 성공하면 삭제된 절대경로, 아니면블랭크
     */
    public String deletePath(String filePath) {
        File file = new File(WebUtil.filePathBlackList(filePath));

        String result = "";

        try {
            if (file.exists()) {
                result = file.getAbsolutePath();
                if (!file.delete()) {
                    result = "";
                }
            }
        }catch (Exception e) {
            throw new RuntimeException("파일 삭제 오류");
        }

        return result;
    }



    /**
     * Comment : 파일을 삭제한다.
     *
     * @param fileDeletePath 삭제하고자 하는파일의 절대경로
     * @return 성공하면 삭제된 파일의 절대경로, 아니면블랭크
     */
    public String deleteFile(String fileDeletePath) {

        // 인자값 유효하지 않은 경우 블랭크 리턴
        if (fileDeletePath == null || fileDeletePath.equals("")) {
            return "";
        }

        String result = "";
        File file = new File(WebUtil.filePathBlackList(fileDeletePath));

        if (file.isFile()) {
            result = deletePath(fileDeletePath);
        } else {
            result = "";
        }

        return result;
    }



    /** 파일 다운로드 **/
    //public void fileDownload()


}
