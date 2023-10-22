package com.hysea.city.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hysea.city.entity.po.City;
import com.hysea.city.entity.vo.CityVO;
import com.hysea.city.mapper.CityMapper;
import com.hysea.city.mock.CityMockImpl;
import com.hysea.city.service.CityService;
import com.hysea.mock.RestMock;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMockImpl cityMock;
    @Autowired
    CityMapper cityMapper;

    @Override
    public List<CityVO> cityList(String keywords, Integer city, Integer subdistrict) {
        List<CityVO> res = new ArrayList<>();
        if(keywords == null){
            JSONObject jsonObject = cityMock.cityList(keywords, subdistrict);
            JSONArray districts = jsonObject.getJSONArray("districts");
            CityVO cityVO = new CityVO();
            for (int i = 0; i < districts.size(); i++) {
                JSONObject jsonObject1 = districts.getJSONObject(i);
                cityVO = new CityVO();
                copyProperties(jsonObject1,cityVO);
                res.add(cityVO);
                JSONArray districts1 = jsonObject1.getJSONArray("districts");
                for (int j = 0; j < districts1.size(); j++) {
                    JSONObject jsonObject2 = districts1.getJSONObject(j);
                    JSONArray districts2 = jsonObject2.getJSONArray("districts");
                    cityVO = new CityVO();
                    copyProperties(jsonObject2,cityVO);
                    res.get(i).getDistricts().add(cityVO);
                    for (int k = 0; k < districts2.size(); k++) {
                        JSONObject jsonObject3 = districts2.getJSONObject(k);
                        JSONArray districts3 = jsonObject3.getJSONArray("districts");
                        cityVO = new CityVO();
                        copyProperties(jsonObject3,cityVO);
                        res.get(i).getDistricts().get(j).getDistricts().add(cityVO);
                        for (int l = 0; l < districts3.size(); l++) {
                            JSONObject jsonObject4 = districts3.getJSONObject(l);
                            JSONArray districts4 = jsonObject4.getJSONArray("districts");
                            cityVO = new CityVO();
                            copyProperties(jsonObject4,cityVO);
                            res.get(i).getDistricts().get(j).getDistricts().get(k).getDistricts().add(cityVO);
                        }
                    }
                }
            }
            return res;
        }
        return res;
    }
    
    void copyProperties(JSONObject jsonObject, CityVO cityVO){
        cityVO.setAdcode(jsonObject.getString("adcode"));
        cityVO.setName(jsonObject.getString("name"));
        cityVO.setLevel(jsonObject.getString("level"));
        cityVO.setCenter(jsonObject.getString("center"));
        try{
            jsonObject.getJSONArray("citycode");
        }catch (Exception e){
            cityVO.setCitycode(jsonObject.getString("citycode"));
        }
    }
}
