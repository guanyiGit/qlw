/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soholy.dogmanager.entity.dogCard;

import java.io.Serializable;

/**
 *
 * @author shawn
 * @copyright Halo
 * @datetime 2016-10-21 19:06:11
 * @version 1.0
 */
public class ResponseEntity<T> implements Serializable {

    private static final long serialVersionUID = -1L; 

    public static final String SUCCESS = "000000";
    
    /**
     * 服务器响应代码
     */
    private String code;
    /**
     * 响应描述信息
     */
    private String message;
    /**
     * 响应结果
     */
    private T result;

    public ResponseEntity() {
        this.code = SUCCESS;
    }

    public ResponseEntity(T result) {
        this.result = result;
        
        this.code = SUCCESS;
    }

    public ResponseEntity(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseEntity(String code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponseEntity{" + "code=" + code + ", message=" + message + ", result=" + result + '}';
    }
}