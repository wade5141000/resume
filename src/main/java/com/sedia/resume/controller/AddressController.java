package com.sedia.resume.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sedia.resume.service.AddressService;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    final AddressService service;

    @GetMapping("/cities")
    public List<String> getCities() {
        // TODO 回傳台灣所有縣市名稱
        // TODO cache 12hr (caffeine)
        return service.getCityList();
    }

    @GetMapping("/towns/{city}")
    public List<String> getTowns(@PathVariable String city) {
        // TODO 給一個縣市名稱，回傳該縣市的鄉鎮市區資訊
        // TODO cache 12hr (caffeine)
        return service.getTownList(city);
    }

}
