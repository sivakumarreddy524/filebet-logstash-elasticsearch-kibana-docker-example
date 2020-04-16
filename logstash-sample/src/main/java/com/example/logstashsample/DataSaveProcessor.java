package com.example.logstashsample;


import com.example.logstashsample.domain.ApiResponse;
import com.example.logstashsample.service.ApiResponseService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataSaveProcessor implements Processor {


    ApiResponseService apiResponseService;


    public DataSaveProcessor(ApiResponseService apiResponseService) {
        this.apiResponseService = apiResponseService;
    }


    @Override
    public void process(Exchange exchange) throws Exception {

        String s = exchange.getIn().getBody(String.class);
        s = s.replaceAll("\\n", "").replaceAll("\\\"", "\"");

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setTimeStam(LocalDate.now());
        apiResponse.setApiResponse(s);
        apiResponseService.save(apiResponse);
        exchange.getIn().setBody(s);
    }
}
