package com.goat.controller;


import com.goat.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/hello")
public class HelloController {

   @Autowired IEmpService iEmpService;

//    http://localhost:8441/hello/test1
    @RequestMapping("/test1")
    public Map findById(){
        Map maps = iEmpService.findById(33);
        System.out.println(maps);
        return maps;
    }


    //    http://localhost:8441/hello/test2
    @RequestMapping("/test2")
    public void findById2(){
        iEmpService.findById2(33);
    }
}
