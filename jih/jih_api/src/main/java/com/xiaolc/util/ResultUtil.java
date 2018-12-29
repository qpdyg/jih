package com.xiaolc.util;

/**
 * 返回结果
 */
public class ResultUtil {

    /**
     * 返回成功方法
     *
     * @param message: 成功信息
     * @return JSONResponse对象
     */
    public static JSONResponse success(String message){
        JSONResponse jsonResponse = new JSONResponse();
        ReturnData returnData = new ReturnData();
        returnData.setMessage(message);
        returnData.setSuccess(true);
        jsonResponse.setCode(200);
        jsonResponse.setData(returnData);
        return jsonResponse;
    }

    /**
     * 返回成功方法
     *
     * @param message 成功信息
     * @param object 成功返回的数据
     * @return JSONResponse对象
     */
    public static JSONResponse success(String message, Object object) {
        JSONResponse jsonResponse = new JSONResponse();
        ReturnData returnData = new ReturnData();
        returnData.setSuccess(true);
        returnData.setMessage(message);
        returnData.setData(object);
        jsonResponse.setCode(200);
        jsonResponse.setData(returnData);
        return jsonResponse;
    }

    /**
     * 错误返回的方法
     *
     * @param message 错误信息
     * @return JSONResponse对象
     */
    public static JSONResponse error(String message){
        JSONResponse jsonResponse = new JSONResponse();
        ReturnData returnData = new ReturnData();
        returnData.setSuccess(false);
        returnData.setMessage(message);
        jsonResponse.setData(returnData);
        jsonResponse.setCode(200);
        return jsonResponse;
    }

    /**
     * 错误返回的方法
     *
     * @param message 错误信息
     * @return JSONResponse对象
     */
    public static JSONResponse error(String message, Object object){
        JSONResponse jsonResponse = new JSONResponse();
        ReturnData returnData = new ReturnData();
        returnData.setSuccess(false);
        returnData.setMessage(message);
        returnData.setData(object);
        jsonResponse.setData(returnData);
        jsonResponse.setCode(200);
        return jsonResponse;
    }
}
