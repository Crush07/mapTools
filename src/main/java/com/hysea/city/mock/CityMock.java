package com.hysea.city.mock;

import com.alibaba.fastjson.JSONObject;

public interface CityMock {

    JSONObject cityList(String keywords,Integer subdistrict);

}
