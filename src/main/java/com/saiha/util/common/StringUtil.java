package com.saiha.util.common;

import java.security.SecureRandom;

public class StringUtil {

    /**
     * String이 비었거나("") 또는 null 인지 검증한다.
     *
     * StringUtil.isEmpty(null)         = true
     * StringUtil.isEmpty("")           = true
     * StringUtil.isEmpty(" ")          = false
     * StringUtil.isEmpty("bob")        = false
     * StringUtil.isEmpty("  bob  ")    = false
     *
     * @param str - 체크 대상 스트링오브젝트이며 null을 허용함
     * @return true - 입력받은 String이 빈 문자열 또는 null인 경우
     *
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isEmpty(Object obj) {
        if(obj == null) {
            return true;
        }

        return false;
    }


    /**
     * 기존 문자열에 포함된 모든 대상 문자(char)를 제거한다.
     *
     * StringUtil.remove(null, *)           = null
     * StringUtil.remove("", *)             = ""
     * StringUtil.remove("queued", 'u')     = "qeed"
     * StringUtil.remove("queued", 'z')     = "queued"
     *
     * @param str       입력받는 기준 문자열
     * @param remove    입력받는 문자열에서 제거할 대상 문자열
     * @return          제거대상 문자열이 제거된 입력문자열, 입력문자열이 null인 경우 출력문자열은 null
     */
    public static String remove(String str, char remove) {
        if (isEmpty(str) || str.indexOf(remove) == -1) {
            return str;
        }
        char [] chars = str.toCharArray();
        int pos = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != remove) {
                chars[pos++] = chars[i];
            }
        }

        return new String(chars, 0, pos);
    }


    /**
     * 문자열 내부의 콤마 character(,)를 모두 제거한다.
     *
     * StringUtil.removeCommaChar(null)         = null
     * StringUtil.removeCommaChar("")           = ""
     * StringUtil.removeCommaChar("asdf, qwer") = "asdfqwer"
     *
     * @param str   입력받는 기준 문자열
     * @return      " , "가 제거된 입력문자열
     * 입력문자열이 null인 경우 출력문자열은 null
     */
    public static String removeCommaChar(String str) {
        return remove(str, ',');
    }


    /**
     * 문자열 내부의 마이너스 character(-)를 모두 제거한다.
     *
     * StringUtil.removeMinusChar(null)         = null
     * StringUtil.removeMinusChar("")           = ""
     * StringUtil.removeMinusChar("asdf-qwer)   = "asdfqwer"
     *
     * @param str       입력받는 기준 문자열
     * @return          " - "가 제거된 입력문자열
     * 입력문자열이 null인 경우 출력문자열은 null
     */
    public static String removeMinusChar(String str) {
        return remove(str, '-');
    }

    /**
     * str 중 searchStr의 시작(index) 위치를 반환.
     *
     * 입력값 중 null이 있을 경우 -1을 반환.
     *
     * StringUtil.indexOf(null, *)          = -1
     * StringUtil.indexOf(*, null)          = -1
     * StringUtil.indexOf("", "")           = 0
     * StringUtil.indexOf("aabaa", "a")     = 0
     * StringUtil.indexOf("aabaa", "b")     = 2
     * StringUtil.indexOf("aabaa", "ab")    = 1
     * StringUtil.indexOf("aabaa", "")      = 0
     *
     * @param str           검색 문자열
     * @param searchStr     검색 대상문자열
     * @return              검색 문자열 중 검색 대상문자열이 있는 시작 위치 (검색대상 문자열이 없거나 null인 경우 -1)
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1;
        }

        return str.indexOf(searchStr);
    }


    /**
     * 객체가 null인지 확인하고 null인 경우 ""로 바꾸는 메서드
     * @param object    원본 객체
     * @return          resultVal 문자열
     */
    public static String isNullToString(Object object) {
        String string = "";

        if (object != null) {
            string = object.toString().trim();
        }

        return string;
    }


    /**
     * Html 코드가 들어간 문서를 표시할 때 태그에 손상없이 보이기 위한 메서드
     *
     * @param strString
     * @return      HTML 태그를 치환한 문자열
     */
    public static String checkHtmlView(String strString) {
        String strNew = "";

        try {
            StringBuffer strTxt = new StringBuffer("");

            char charBuff;
            int len = strString.length();

            for (int i = 0; i < len; i++) {
                charBuff = (char)strString.charAt(i);

                switch (charBuff) {
                    case '<':
                        strTxt.append("&lt;");
                        break;
                    case'>':
                        strTxt.append("&gt;");
                        break;
                    case'"':
                        strTxt.append("&quot;");
                        break;
                    case 10:
                        strTxt.append("<br>");
                        break;
                    case '&':
                        strTxt.append("&amp;");
                        break;
                    default:
                        strTxt.append(charBuff);
                }
            }

            strNew = strTxt.toString();
        } catch (Exception e) {
            return null;
        }

        return strNew;
    }


    /**
     * #toLowerCase()를 이용하여 소문자로 변환한다.
     *
     * StringUtil.lowerCase(null)   =null
     * StringUtil.lowerCase("")     =""
     * stringUtil.lowerCase("aBc")  ="abc"
     *
     * @param str
     * @return
     */
    public static String lowerCase(String str) {
        if (str == null) {
            return null;
        }

        return str.toLowerCase();
    }


    /**
     * #toUpperCase()를 이용하여 대문자로 변환한다.
     *
     * StringUtil.upperCase(null)   = null
     * StringUtil.upperCase("")     = ""
     * StringUtil.upperCase("aBc")  = "ABC"
     *
     * @param str
     * @return
     */
    public static String upperCase(String str) {
        if (str == null) {
            return null;
        }

        return str.toUpperCase();
    }


    /**
     * 문자열 A에서 Z사이의 랜덤 문자열을 구하는 기능을 제공 시작문자열과 종료문자열 사이의 랜덤 문자열을 구하는 기능
     *
     * @param startChr  - 첫 문자
     * @param endChr    - 마지막 문자
     * @return          - 랜덤문자
     */
    public static String getRandomStr(char startChr, char endChr) {
        int randomInt;
        String randomStr = null;

        //시작문자 및 종료문자를 아스키숫자로 변환한다.
        int startInt = Integer.valueOf(startChr);
        int endInt = Integer.valueOf(endChr);

        //시작문자열이 종료문자열보다 클경우
        if (startInt > endInt) {
            throw new IllegalArgumentException("Start String : " + startChr + "End String : " + endChr);
        }

        try {
            //랜덤 객체 생성
            SecureRandom rnd = new SecureRandom();

            do {
                //시작문자 및 종류문자 중에서 랜덤 숫자를 발생시킨다.
                randomInt = rnd.nextInt(endInt + 1);
            } while (randomInt < startInt);     // 입력받은 문자 'A'(65)보다 작으면 다시 랜덤 숫자 발생.

            //랜던 숫자를 문자로 변환 후 스트링으로 다시 변환
            randomStr = (char)randomInt + "";
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        //랜덤문자열을 리턴
        return randomStr;
    }




}
