package com.example.logstashsample;



import com.example.logstashsample.domain.RouteConfig;
import com.example.logstashsample.service.RouteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRest {

    @Autowired
    RouteConfigService routeConfigService;

    @PostMapping("/getPath")
    public String getPath(@RequestBody MyBean myBean) {

        RouteConfig routeConfig = routeConfigService.findByName(myBean.getName());

        if (routeConfig != null) {
            return routeConfig.getRoutePath();
        } else {
            return "";
        }


    }


}
