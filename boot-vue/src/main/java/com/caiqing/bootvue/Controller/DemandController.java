package com.caiqing.bootvue.Controller;

import com.caiqing.bootvue.Entity.Demand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/3/2 13:28
 **/
@RequestMapping("/vue/demand")
@Controller
public class DemandController {

    @RequestMapping(value = "/{id}")
    @ResponseBody
    public Demand getById(@PathVariable(value = "id") Long id) {
        Demand demand = new Demand();
        return demand;
    }
}
