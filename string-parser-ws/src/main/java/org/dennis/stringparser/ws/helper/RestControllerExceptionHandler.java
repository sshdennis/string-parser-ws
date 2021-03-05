package org.dennis.stringparser.ws.helper;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.dennis.stringparser.ws.bean.JsonResponse;
import org.dennis.stringparser.ws.exception.AppException;
import org.dennis.stringparser.ws.exception.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author:   dsu01
 * Date:     2021/2/28 10:20 下午
 * Description: This class handles exceptions thrown by rest controllers.
 */
@ControllerAdvice
public class RestControllerExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(RestControllerExceptionHandler.class);

    /**
     * Exception handler for AppException.
     * HttpStatus = AppException.errorCode.httpStatusCode
     *
     * @param request
     * @param e
     *
     * @return
     */
    @ExceptionHandler(AppException.class)
    @ResponseBody
    public ResponseEntity<JsonResponse> handleAppException(final HttpServletRequest request, final AppException e) {
        LOG.error("Error occurred, request URI: {}, error code: {}, additional message: {}", request.getRequestURI(), e.getErrorCode(), e.getAdditionalMessage());
        LOG.error("Error", e);

        final JsonResponse jsonResponse = JsonResponse.failed().withErrorCode(e.getErrorCode()).withErrorMessage(e.getAdditionalMessage());
        return new ResponseEntity<>(jsonResponse, e.getErrorCode().getHttpStatusCode());
    }

    /**
     * Default handler for Exception.
     * HttpStatus = 400
     *
     * @param request
     * @param e
     *
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResponse handleUncaughtException(final HttpServletRequest request, final Exception e) {
        LOG.error("Error occurred, request URI: " + request.getRequestURI(), e);

        final String exceptionStrackTrace = ExceptionUtils.getStackTrace(e);
        return JsonResponse.failed().withErrorCode(ErrorCode.RUNTIME_ERROR).withErrorMessage(exceptionStrackTrace);
    }
}
