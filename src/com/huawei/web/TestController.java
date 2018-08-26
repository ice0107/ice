package com.huawei.web;

import com.huawei.pojo.Test;
import com.huawei.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public List<Test> test() {
        List<Test> testList = testService.getAllTest();
        System.out.println(testList);
        return testList;
    }
}
