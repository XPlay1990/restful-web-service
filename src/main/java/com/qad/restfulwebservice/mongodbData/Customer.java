package com.qad.restfulwebservice.mongodbData;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;
}