package org.dennis.stringparser.ws.service;

import org.dennis.stringparser.ws.bean.ParseStringRequest;
import org.dennis.stringparser.ws.bean.ParseStringResponse;
import org.dennis.stringparser.ws.exception.AppException;

/**
 * Author:   dsu01
 * Date:     2021/2/28 10:58 上午
 * Description: The string parser service.
 */
public interface StringParserService {

    /**
     * Return the parsing string result.
     *
     * @param request
     * @return
     * @throws AppException
     */
    public ParseStringResponse parseString(ParseStringRequest request) throws AppException;
}
