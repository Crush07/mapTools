package com.hysea.city.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.hysea.city.entity.po.City;

@Mapper
public interface CityMapper{

	Integer selectCountByCityId();

	List<City> selectAllByCityId();

	Integer deleteCityByCityId();

	Integer updateCityByCityId(City city);

	Integer batchInsertCity(@Param("cityList") List<City> cityList);

	Integer insertCity(City city);

	List<City> selectAll();

}
