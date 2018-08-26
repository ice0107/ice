//package com.huawei.web;
//
//import com.huawei.service.RegionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("region")
//public class RegionController {
//
//    @Autowired
//    private RegionService regionService;
//
//    @RequestMapping("getRegionIdByRegionName")
//    @ResponseBody
//    public Integer getRegionIdByRegionName(@RequestParam String regionName) {
//        Integer regionId = regionService.getRegionIdByRegionName(regionName);
//
//        return regionId;
//    }
//
//    @RequestMapping("getAllRegion")
//    @ResponseBody
//    public List<Region> getAllRegion() {
//
//        return regionService.getAllRegion();
//    }
//}
