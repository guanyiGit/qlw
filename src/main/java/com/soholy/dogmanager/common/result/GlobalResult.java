package com.soholy.dogmanager.common.result;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Collection;
import java.util.Map;

/**
 * Title: 统一响应结构
 * { "meta": { "success": true, "message": "ok" }, "data": ... }
 */
public class GlobalResult {

    private static final String OK = "OK";
    private static final String ERROR = "ERROR";

    private Meta meta; // 元数据
    private Object data; // 响应内容

    public GlobalResult success() {
        this.meta = new Meta(true, OK);
        return this;
    }

    public String successJSON() {
        this.meta = new Meta(true, OK);
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }

    public String boolResultJSON(boolean isOk) {
        if (isOk) {
            this.meta = new Meta(true, OK);
        } else {
            this.meta = new Meta(false, ERROR);
        }
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }


    public String resultJSON(Object data, String msg) {
        return JSON.toJSONString(this.result(data, msg));
    }

    public String resultJSON(Object data) {
        return JSON.toJSONString(this.result(data, null), SerializerFeature.DisableCircularReferenceDetect);
    }

    public GlobalResult result(Object data) {
        return this.result(data, null);
    }

    /**
     * @param data
     * @param msg
     * @return
     */
    public GlobalResult result(Object data, String msg) {
        if (data == null) {
            msg = msg == null || msg.trim().length() == 0 ? msg : ERROR;
            this.meta = new Meta(false, msg);
        } else {
            this.meta = new Meta(true, msg);
            if (data instanceof Collection) {
                if (((Collection) data).size() > 0) {
                    msg = msg == null || msg.trim().length() == 0 ? msg : OK;
                    this.meta = new Meta(true, msg);
                } else {
                    msg = msg == null || msg.trim().length() == 0 ? msg : ERROR;
                    this.meta = new Meta(false, msg);
                }
            } else if (data instanceof Map) {
                if (((Map) data).size() > 0) {
                    msg = msg == null || msg.trim().length() == 0 ? msg : OK;
                    this.meta = new Meta(true, msg);
                } else {
                    msg = msg == null || msg.trim().length() == 0 ? msg : ERROR;
                    this.meta = new Meta(false, msg);
                }
            }
            this.data = data;
        }

        return this;
    }

    /**
     * @param data
     * @return
     * @Description (空值返回err)
     */
    public String objResultJSON(Object data) {
        if (data != null) {
            this.meta = new Meta(true, OK);
            this.meta = new Meta(true, OK);
            this.data = data;

        } else {
            this.meta = new Meta(false, ERROR);
        }
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }

    public GlobalResult success(Object data) {
        this.meta = new Meta(true, OK);
        this.data = data;
        return this;
    }

    public String successJSON(Object data) {
        this.meta = new Meta(true, OK);
        this.data = data;
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }

    public String successJSON(Object... data) {
        this.meta = new Meta(true, OK);
        this.data = data;
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }

    public GlobalResult failure() {
        this.meta = new Meta(false, ERROR);
        return this;
    }

    public String failureJSON() {
        this.meta = new Meta(false, ERROR);
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }

    public GlobalResult failure(String message) {
        this.meta = new Meta(false, message);
        return this;
    }

    public String failureJSON(String message) {
        this.meta = new Meta(false, message);
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }

    public Meta getMeta() {
        return meta;
    }

    public Object getData() {
        return data;
    }

    /**
     * Title: 请求元数据
     */
    public class Meta {

        private boolean success;
        private String message;

        public Meta(boolean success) {
            this.success = success;
        }

        public Meta(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
