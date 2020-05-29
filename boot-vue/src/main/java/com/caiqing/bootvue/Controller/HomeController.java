package com.caiqing.bootvue.Controller;

import com.caiqing.bootvue.Entity.Demand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/3/3 10:08
 **/
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "login";
    }

    @RequestMapping("/jsp")
    public String index(Map<String, Object> map) {
        map.put("name", "JSP");
        return "jsp";
    }
}
