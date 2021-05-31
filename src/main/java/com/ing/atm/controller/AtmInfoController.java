package com.ing.atm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ing.atm.service.AtmInfoService;
import com.ing.atm.vo.AtmVO;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class AtmInfoController {

    private static final Log log = LogFactory.getLog(AtmInfoController.class);

    @Autowired
    private AtmInfoService atminfoService;

    @Autowired
    RestTemplate restTemplate;

    @Value("${operations.serviceURL}")
    String serviceURL;


    @GetMapping("/atms")
    public List<AtmVO> getATMs() {
        try {
            log.info("Getting info of all ATMs ");
            String atms = restTemplate.getForObject(serviceURL, String.class, "");
            return atminfoService.retrieves(atms);
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException in getATMS : " + e);
            return null;
        } catch (Exception e) {
            log.error("Exception in getATMS : " + e);
            return null;
        }
    }

    @GetMapping("/atms/{city}")
    public List<AtmVO> getATMsByCity(@PathVariable String city) throws JsonProcessingException {
        try {
            log.info("Getting info of all ATMs for a city");
            String atms = restTemplate.getForObject(serviceURL, String.class, "");
            return atminfoService.retrieves(atms, city);
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException in getATMsByCity : " + e);
            return null;
        } catch (Exception e) {
            log.error("Exception in getATMsByCity : " + e);
            return null;
        }
    }

    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }
}
