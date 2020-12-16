package org.simple.demo.test.springload;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
@Data
public class Avo {

    public Avo(){
        System.out.println("A construct");
    }
}
