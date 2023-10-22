package com.hysea.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hysea
 * @version v1.0
 */
@Component
public class RestMock {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 生成post请求的JSON请求参数
     * 请求示例:
     * {
     * "id":1,
     * "name":"张耀烽"
     * }
     *
     * @return post请求的JSON请求参数
     */
    public HttpEntity<Map<String, Object>> generatePostJson(Map<String, Object> jsonMap) {

        //如果需要其它的请求头信息、都可以在这里追加
        HttpHeaders httpHeaders = new HttpHeaders();

        MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");

        httpHeaders.setContentType(type);

        return new HttpEntity<>(jsonMap, httpHeaders);
    }


    /**
     * 生成get参数请求url
     *
     * @param protocol 请求协议 示例: http 或者 https
     * @param uri      请求的uri 示例: 0.0.0.0:80
     * @param params   请求参数
     * @return get参数请求url
     */
    public String generateRequestParameters(String protocol, String uri, Map<String, String> params) {
        StringBuilder sb = new StringBuilder(protocol).append("://").append(uri);
        if (!params.isEmpty()) {
            sb.append("?");
            for (Map.Entry<String,String> map : params.entrySet()) {
                sb.append(map.getKey())
                        .append("=")
                        .append(map.getValue())
                        .append("&");
            }
            uri = sb.substring(0, sb.length() - 1);
            return uri;
        }
        return sb.toString();
    }

    /**
     * get请求、请求参数为?拼接形式的
     * <p>
     * 最终请求的URI如下：
     * <p>
     *
     *
     * @return 请求、请求参数为?拼接形式的
     */
    public String sendGet(String protocol, String uri, Map<String, String> params) {

        ResponseEntity<String> responseEntity = restTemplate.getForEntity
                (
                        generateRequestParameters(protocol, uri, params),
                        String.class
                );
        return responseEntity.getBody();

    }

    /**
     * post请求、请求参数为json
     *
     */
    public String sendPost(String protocol, String uri, Map<String, Object> jsonMap) {

        ResponseEntity<String> apiResponse = restTemplate.postForEntity
                (
                        protocol + "://" + uri,
                        generatePostJson(jsonMap),
                        String.class
                );
        return apiResponse.getBody();
    }

    /**
     * post请求、请求参数为json
     *
     */
    public String sendPost(String protocol, String uri, Map<String, String> query, Map<String, Object> jsonMap) {

        ResponseEntity<String> apiResponse = restTemplate.postForEntity
                (
                        generateRequestParameters(protocol,uri,query),
                        generatePostJson(jsonMap),
                        String.class
                );
        return apiResponse.getBody();
    }

}

