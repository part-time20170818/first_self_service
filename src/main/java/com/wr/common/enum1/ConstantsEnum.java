package com.wr.common.enum1;

/**
 * Created by 文歌 on 2017/9/3.
 */
public enum  ConstantsEnum {
    SUCCESS("0000", "成功"),
    FAILURE("0001","失败"),
    HANDLING("0002", "处理中"),
    LOGIN_PASSWORD_ERROR("0003", "密码错误"),
    LOGIN_CHECK_NUMBER_ERROR("0004", "验证码错误");
    private String code;

    private String msg;

    /**
     * 获取code
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public boolean equalsCode(String code) {
        return this.code.equals(code);
    }

    ConstantsEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
