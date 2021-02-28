package org.dennis.stringparser.ws.controller;

import org.dennis.stringparser.ws.bean.JsonResponse;
import org.dennis.stringparser.ws.bean.ParseStringRequest;
import org.dennis.stringparser.ws.service.StringParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:   dsu01
 * Date:     2021/2/28 10:56 上午
 * Description: The string parse controller.
 */
@RestController
@RequestMapping("/api")
public class StringParserController {

    private StringParserService stringParserService;

    @RequestMapping(value = "/parse/string", method = RequestMethod.POST, produces = "application/json")
    public JsonResponse parseString(@RequestBody final ParseStringRequest request) throws Exception {
        return JsonResponse.ok().withBody(this.stringParserService.parseString(request));
    }

    @Autowired
    private void setStringParserService(final StringParserService stringParserService) {
        this.stringParserService = stringParserService;
    }
}
