package com.soholy.dogmanager.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataMismatchException  extends Exception{
    public static final Logger logger = LoggerFactory.getLogger(DataMismatchException.class);
    /**
     * @Field @serialVersionUID : TODO(explain)
     */
    private static final long serialVersionUID = 1L;

    public DataMismatchException() {
        super();
        logger.warn("参数不匹配异常");
    }

    public DataMismatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public DataMismatchException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public DataMismatchException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public DataMismatchException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
}
