package com.hysea.city.mock;

import com.alibaba.fastjson.JSONObject;
import com.hysea.mock.RestMock;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CityMockImpl extends RestMock implements CityMock{

    @Override
    public JSONObject cityList(String keywords,Integer subdistrict) {

        HashMap<String,String> query = new HashMap<>();
        query.put("key","4cc24b2e7967aaef5b2dcb313b01463c");

        if(keywords != null){
            query.put("keywords",keywords);
        }
        if(subdistrict != null){
            query.put("subdistrict",String.valueOf(subdistrict));
        }

        String response = sendGet("https", "restapi.amap.com/v3/config/district", query);

        return JSONObject.parseObject(response);

    }
}
