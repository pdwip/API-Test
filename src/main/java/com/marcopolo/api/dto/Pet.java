package com.marcopolo.api.dto;


import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Pet {

    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;
    private Status status;

}
