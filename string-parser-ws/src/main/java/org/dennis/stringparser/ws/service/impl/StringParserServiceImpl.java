package org.dennis.stringparser.ws.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.dennis.stringparser.ws.bean.ParseStringRequest;
import org.dennis.stringparser.ws.bean.ParseStringResponse;
import org.dennis.stringparser.ws.exception.AppException;
import org.dennis.stringparser.ws.exception.ErrorCode;
import org.dennis.stringparser.ws.service.StringParserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Author:   dsu01
 * Date:     2021/2/28 11:00 上午
 * Description:
 */
@Service
public class StringParserServiceImpl implements StringParserService {
    private static final Logger LOG = LoggerFactory.getLogger(StringParserServiceImpl.class);

    private static final int STRING_PARSING_RESULT_LIMIT = 5;

    @Override
    public ParseStringResponse parseString(final ParseStringRequest request) throws AppException {
        LOG.info("Parsing string, input string: {}, limit: {}", request.getInputString(), request.getLimit());

        if (StringUtils.isBlank(request.getInputString())) {
            throw new AppException(ErrorCode.PARAMETER_MISSING, "input_string");
        }

        final NavigableSet<Long> resultSet = Arrays.stream(request.getInputString().split(","))
                .filter(StringUtils::isNotBlank)
                .filter(StringUtils::isNumeric)
                .map(Long::valueOf)
                .collect(Collectors.toCollection(
                        TreeSet::new
                ))
                .descendingSet();
        if (resultSet.size() == 0) {
            throw new AppException(ErrorCode.PARAMETER_MISSING, "input_string");
        }

        final int limit = request.getLimit() == null ? STRING_PARSING_RESULT_LIMIT : request.getLimit();
        final List<Long> results = new ArrayList<>(resultSet).subList(0, Math.min(resultSet.size(), limit));
        return new ParseStringResponse(results);
    }
}
