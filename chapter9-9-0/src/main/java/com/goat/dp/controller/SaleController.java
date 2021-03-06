package com.goat.dp.controller;

import com.goat.dp.service.SaleService;
//import com.goat.dp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/3/28.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/28---18:31
 */
@RestController
public class SaleController {

    @Autowired
    SaleService saleService;

//    @Autowired
//    TestService testService;

    //   http://localhost:8990/test?type=VIP&price=100
    //   http://localhost:8990/test?type=VIP1&price=100
    //   http://localhost:8990/test?type=VIP2&price=100
    @GetMapping("test")
    public String test(String type,Double price){
        saleService.sale(type,price);
        return "";
    }

    @GetMapping("test1")
    public String test1(String type,Double price){
        saleService.sale2(type,price);
        return "";
    }

    //   http://localhost:8990/test2?type=VIP2&price=100
    @GetMapping("test2")
    public String test2(String type,Double price){
        saleService.sale3(type,price);
        return "";
    }

    //   http://localhost:8990/test3?type=VIP2&price=100
    @GetMapping("test3")
    public String test3(String type,Double price){
//        testService.sale3(type,price);
        return "";
    }
}
