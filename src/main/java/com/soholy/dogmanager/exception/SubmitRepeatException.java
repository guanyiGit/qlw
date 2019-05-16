package com.soholy.dogmanager.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubmitRepeatException extends Exception {
    public static final Logger logger = LoggerFactory.getLogger(SubmitRepeatException.class);
    /**
     * @Field @serialVersionUID : TODO(explain)
     */
    private static final long serialVersionUID = 1L;

    public SubmitRepeatException() {
        super();
        logger.warn("重复提交异常");
    }

    public SubmitRepeatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public SubmitRepeatException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public SubmitRepeatException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public SubmitRepeatException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
}
