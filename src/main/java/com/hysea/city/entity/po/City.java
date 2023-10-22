package com.hysea.city.entity.po;

import lombok.Data;

@Data
public class City {

    private Integer cityId;
    private Integer parentId;
    private String adcode;
    private String name;
    private String center;
    private String level;
    private String citycode;

}
