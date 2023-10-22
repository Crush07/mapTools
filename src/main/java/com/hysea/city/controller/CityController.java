package com.hysea.city.controller;

import com.hysea.city.entity.vo.CityVO;
import com.hysea.city.service.impl.CityServiceImpl;
import com.hysea.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/module/city")
public class CityController {

    @Autowired
    CityServiceImpl cityService;

    /**
     * 通过维度id和班级id获取评价列表
     */
    @GetMapping("/cityList")
    @ResponseBody
    public String cityList(@RequestParam(value = "keywords", required = false) String keywords) {

        List<CityVO> res = cityService.cityList(keywords, 3, 3);

        return ResultUtils.SUCCESS("成功",res);
    }

}
