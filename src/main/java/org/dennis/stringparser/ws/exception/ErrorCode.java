package org.dennis.stringparser.ws.exception;

import org.springframework.http.HttpStatus;

/**
 * Author:   dsu01
 * Date:     2021/2/28 10:16 下午
 * Description: The error code enum.
 */
public enum ErrorCode {
    /**
     * General runtime error.
     */
    RUNTIME_ERROR("RUNTIME_ERROR"),
    RESOURCE_NOT_FOUND("RESOURCE_NOT_FOUND", HttpStatus.NOT_FOUND),
    PARAMETER_MISSING("PARAMETER_MISSING");

    private final String code;

    private final HttpStatus httpStatusCode;

    /**
     * Constructor with the given error code and http status code.
     *
     * @param theCode
     * @param theHttpStatusCode
     */
    private ErrorCode(final String theCode, final HttpStatus theHttpStatusCode) {
        this.code = theCode;
        this.httpStatusCode = theHttpStatusCode;
    }

    /**
     * Constructor with the given error code, and the default http status code is 400.
     *
     * @param theCode the error code to set
     */
    private ErrorCode(final String theCode) {
        this(theCode, HttpStatus.BAD_REQUEST);
    }

    /**
     * Returns the error code.
     *
     * @return the error code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Returns the http status code.
     *
     * @return
     */
    public HttpStatus getHttpStatusCode() {
        return this.httpStatusCode;
    }
}
