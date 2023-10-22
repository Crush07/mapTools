package com.hysea.city.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hysea.city.entity.vo.CityVO;
import com.hysea.mock.RestMock;

import java.util.List;

public interface CityService {

    List<CityVO> cityList(String keywords, Integer city, Integer subdistrict);

}