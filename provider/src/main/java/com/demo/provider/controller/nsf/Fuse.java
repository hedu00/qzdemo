package com.demo.provider.controller.nsf;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nsf/v1/fuse")
public class Fuse {

    @GetMapping("errorRate")
    public String getErrorRate(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format(" --> This is demo provider errorrate: " + "Hello %s!", name);
    }

    @GetMapping("sleep")
    public String getTimeLay() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Get provider/nsf timelay");
        return "timelay 3000ms";
    }


}
