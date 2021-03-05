package org.dennis.stringparser.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author:   dsu01
 * Date:     2021/2/28 4:16 下午
 * Description: Controller for static files.
 */
@Controller
public class WebPageController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
