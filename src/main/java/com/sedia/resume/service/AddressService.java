
package com.sedia.resume.service;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.sedia.resume.repository.AddressMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
@RequiredArgsConstructor
@CacheConfig(cacheNames = "caffeineCacheManager")
public class AddressService {

    final AddressMapper addressMapper;
 
    Cache<String, Object> cache = Caffeine.newBuilder()
    	       .expireAfterWrite(12, TimeUnit.HOURS)
    	       .initialCapacity(100)
    	                .maximumSize(1000)
    	                .build();
    	 
    @Cacheable(value = "cache",key = "getCityList")
    public List<String> getCityList() {
    	System.out.print("取得所有城市資料");
        return addressMapper.getAllCities();
    }  

    @Cacheable(value = "cache",key = "#city")
    public List<String> getTownList(String city) {
    	System.out.print("取得所有鄉鎮資料");
        return addressMapper.getAllTowns(city);
    }
    
//    public String selectCity(int id) {
//        return addressMapper.selectCityById(id);
//    }
//    
//    public String selectTown(int id) {
//        return addressMapper.selectTownById(id);
//    }


}
