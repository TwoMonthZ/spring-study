package com.rly.springresources.di;


import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ResourceBean {

    private Resource resource;

    public void parse(){
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());
    }

}
