package com.demo.provider.controller.nsf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
@RequestMapping("/api/nsf/v1/ratelimit")
public class RateLimit {

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("queries")
    public String getQueries(@RequestParam(value = "name", defaultValue = "provider") String name) throws IOException {

//        String url = "http://127.0.0.1:18001/api/nsf/v1/demoinfo/instanceinfo";
        String url = "http://qzDemoProvider/api/nsf/v1/info/instanceinfo";

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            String a = restTemplate.getForObject(url,String.class);
            result.append(a);
        }

        return String.format( result.toString() + "Get from %s! This is provider! \n",name);

    }

    @GetMapping("threads")
    public String getThreads(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format(" --> This is demo provider threads: " + "Hello %s!", name);
    }


}
