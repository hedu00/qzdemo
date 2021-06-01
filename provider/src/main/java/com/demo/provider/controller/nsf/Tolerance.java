package com.demo.provider.controller.nsf;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("/api/nsf/v1/tolerance")
public class Tolerance {

    public static int b = 1;
    @GetMapping("errortimes")
    public String getErrorTimes()throws Exception{

        Date date =new Date();

        try{
            int a = 5;
            float result = a / b;
        }catch (Exception e){
            throw e;
        }finally {
            b++;
            if(b == 4){
                b = -1;
            }
        }

        return String.format(" --> This is demo provider errortimes: " + date.toString() + " b ");
    }


}