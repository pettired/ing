package com.ing.atm.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.atm.exception.ATMNotFoundException;
import com.ing.atm.vo.AtmVO;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AtmInfoService {

    private static final Log log = LogFactory.getLog(AtmInfoService.class);

    @Autowired
    RestTemplate restTemplate;

    public List<AtmVO> retrieves(String atms) throws JsonProcessingException {
        log.info("formatting info of all ATMs");
        String jsonFormat = formatString(atms);
        AtmVO[] atmsList = getAtmVOS(jsonFormat);
        return Arrays.asList(atmsList);
    }

    public List<AtmVO> retrieves(String atms, String city) throws JsonProcessingException {
        log.info("formatting info of all ATMs for a city");
        String jsonFormat = formatString(atms);
        AtmVO[] atmsList = getAtmVOS(jsonFormat);
        List<AtmVO> atmsPerCity = new ArrayList<>();
        for (AtmVO atm : atmsList) {
            if (atm != null && atm.getAddress() != null
                    && city.equalsIgnoreCase(atm.getAddress().getCity())) {
                atmsPerCity.add(atm);
            }
        }
        if (atmsPerCity != null && atmsPerCity.size() == 0) {
            throw new ATMNotFoundException("City provided : " + city);
        }
        return atmsPerCity;
    }

    private String formatString(String atms) {
        return atms.replace(")]}',", "");
    }

    private AtmVO[] getAtmVOS(String jsonFormat) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonFormat, AtmVO[].class);
    }

}
