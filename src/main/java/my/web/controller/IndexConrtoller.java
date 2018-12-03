package my.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class IndexConrtoller {

    @GetMapping("/")
    public String index(Map<String, Object> model){
        return "index";
    }
}
