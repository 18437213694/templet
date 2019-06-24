package com.reactx.selection.mappers;

import com.reactx.selection.models.base.BaseMapper;
import com.reactx.selection.models.data.local.KeguanShop;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface KeguanShopMapper extends BaseMapper<KeguanShop> {

//    List<KeguanShop> findPage(/*@Param("page") Page<KeguanShop> page, @Param("query") ShopQuery query*/);

      @Select("SELECT s.id,d.CityName FROM keguan_shop s LEFT JOIN keguan_district d ON s.cityid = d.id WHERE s.shopname IS NOT NULL AND s.images IS NOT NULL AND s. STATUS > 0")
      List<Map<String,String>> getAllCity();

      @Select("select * from keguan_shop where id = #{id}")
      KeguanShop findById(@Param("id") Long id);

      List<String> getAllCityByProvince(@Param("ids") List<String> ids);

      List<KeguanShop> findPage(@Param("cityName") String cityName,@Param("shopName") String shopName,
                                @Param("pageSize") Integer pageSize,@Param("pageNo") Integer pageNo);

      List<KeguanShop> findPageByCity(@Param("cityName") String cityName,@Param("shopName") String shopName,
                                @Param("pageSize") Integer pageSize,@Param("pageNo") Integer pageNo);


      @Select("SELECT d.CityName FROM keguan_shop s LEFT JOIN keguan_district d ON s.cityid = d.id where s.id= #{id}")
      String findCityName(@Param("id") Long id);

      @Select("SELECT d.CityName FROM keguan_shop s LEFT JOIN keguan_district d ON s.provinceid = d.id where s.id= #{id}")
      String findProvinceName(@Param("id") Long id);
}
