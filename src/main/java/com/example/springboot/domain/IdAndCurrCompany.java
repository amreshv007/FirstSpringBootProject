package com.example.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IdAndCurrCompany {
    int id;
    String curr_company;
}
