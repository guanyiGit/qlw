package com.soholy.dogmanager.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName GyException
 * @Description (mvc异常-gy)
 * @author guanY
 * @Date 2016年7月9日 下午1:41:12
 * @version 1.0.0
 */
public class GyException extends Exception {

    public static final Logger logger = LoggerFactory.getLogger(GyException.class);
    /**
     * @Field @serialVersionUID : TODO(explain)
     */
    private static final long serialVersionUID = 1L;

    public GyException() {
        super();
        logger.warn("Guan Yi 控制器异常");
    }

    public GyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public GyException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public GyException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public GyException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
