package com.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Publish_Controller {
	
    @GetMapping("/publish/publishmain")
    public String getPublishmainListPage() throws Exception {

    	
   
       

       return "/publish/publishmain";
    }
    
    @GetMapping("/publish/publishsub")
    public String getPublishsubListPage() throws Exception {

    	
   
       

       return "/publish/publishsub";
    }

}
