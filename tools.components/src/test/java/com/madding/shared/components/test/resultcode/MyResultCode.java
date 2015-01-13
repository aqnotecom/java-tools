package com.madding.shared.components.test.resultcode;

import java.util.Locale;
import java.util.Map;

import com.madding.shared.components.resultcode.IRichResultCode;
import com.madding.shared.components.resultcode.ResultCodeComp;

/**
 * 类MyResultCode.java的实现描述：提示外置枚举测试类
 * 
 * @author madding.lip Sep 17, 2013 5:25:32 PM
 */
enum MyResultCode implements IRichResultCode {
    AAA(0), BBB(1), CCC(2), DDD(3);

    private int                  code;

    private final ResultCodeComp comp = new ResultCodeComp(this, Locale.CHINA);

    private MyResultCode(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return comp.getName();
    }

    public String getMessage() {
        return comp.getMessage();
    }

    public String getMessage(Object[] param) {
        return comp.getMessage(param);
    }

    public String getRichMessage(Map<String, Object> param) {
        return comp.getRichMessage(param);
    }
}
