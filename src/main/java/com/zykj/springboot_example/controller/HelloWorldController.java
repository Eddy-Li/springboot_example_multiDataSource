package com.zykj.springboot_example.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * RestController: 该注解的类下所有方法返回json格式数据,相当于Controller注解+ResponseBody注解
 */
@RequestMapping("/HelloWorld")
@RestController
public class HelloWorldController {

    @RequestMapping("/helloWorldString")
    public String test1() {
        return "hello springboot";
    }

    @RequestMapping("/helloWorldMap")
    public Map test2() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "candy");
        map.put("age", 18);
        map.put("lover", "eddy");
        return map;
    }

    @RequestMapping("/errorTest")
    public String test3() {
        return 0 / 0 + "";
    }

    @RequestMapping("/logTest")
    public String test4(String name, String age) {
        System.out.println("name=" + name + ",age=" + age);
        return "success";
    }

}
