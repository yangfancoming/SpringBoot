package com.goat.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 64274 on 2019/6/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/6/4---13:36
 */
@Controller
@RequestMapping("transfer")
public class TransferController {

    //    http://localhost:8216/transfer/select
    @GetMapping("/select")
    public String select() {
        return "select";
    }




    //    http://localhost:8216/transfer/form
    @GetMapping("/form")
    public String form() {
        return "form";
    }



    //    http://localhost:8216/transfer/model
    @GetMapping("/model")
    public String model() {
        return "model";
    }

    //    http://localhost:8216/transfer/qrcode
    @GetMapping("/qrcode")
    public String qrcode() {
        return "qrcode";
    }
}
