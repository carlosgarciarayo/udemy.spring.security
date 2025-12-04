package udemy.spring.security.web.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(path = "/aboutUs")
public class AboutUsController {

    @GetMapping
    public Map<String,String> aboutUs(){

        log.debug("About Us endpoint called");
        return Collections.singletonMap("msj","aboutUs");

    }
}
