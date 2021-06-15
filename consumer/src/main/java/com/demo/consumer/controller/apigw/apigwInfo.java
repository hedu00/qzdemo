package com.demo.consumer.controller.apigw;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/apigw/v1/info")
public class apigwInfo {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("instanceinfo")
    public String getInstanceInfo(@RequestHeader HttpHeaders headers, String qz) {

        Date date = new Date();
        System.out.println(date.toString() + request.getServerName() + ":" + request.getServerPort());
        return date.toString() + "--> " + "响应服务地址:" + request.getServerName() + ":" + request.getServerPort() + "\r\n";

    }


    public String defaultFallback() {
        return "默认Fallback方法：暂时无法响应";
    }


    @PostMapping("postinfo")
    public String postMsgInstanceInfo(@RequestHeader HttpHeaders headers, @CookieValue(value = "token") String cook, String hedu) {
        //

        System.out.println("从header取出的hedu对应的值为---->" + headers.getFirst("hedu"));
        System.out.println("从query string取出的hedu对应的值为---->" + hedu);
        System.out.println("从cookie中取出的token对应的值为---->" + cook);

        Map<String, String> map = new HashMap<String, String>();
        //1.获取所有请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        //2.遍历
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            //根据名称获取请求头的值
            String value = request.getHeader(name);
            map.put(name, value);
        }
        JSONObject jsonObj = new JSONObject(map);
        String resultInfoOuterListStr = jsonObj.toString();

        int count = 0;
        System.out.println(request.getServerName() + ":" + request.getServerPort());
        count++;
        return "第" + count + "次响应服务地址:" + request.getServerName() + ":" + request.getServerPort() + "\r\n" + resultInfoOuterListStr;

    }


    @GetMapping("health")
    public String getInfoHealth() {
        return "状态健康，返回码200";
    }


    @GetMapping("unhealth")
    public String getInfoUnhealth(HttpServletResponse resp) {
        resp.setStatus(500);
        return "状态不健康，返回码500";
    }

}