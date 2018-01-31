package com.douban.web.support;

/**
 * Created by ruikai.lin  on 2018/1/30 下午5:51.
 * Description:
 */
public class ServiceException extends RuntimeException {
    private int errCode = -1;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(int errCode, String message) {
        super(message);
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
