package org.dennis.stringparser.ws.exception;

/**
 * Author:   dsu01
 * Date:     2021/2/28 10:15 下午
 * Description: For server exception.
 */
public class AppException extends Exception {

    private static final long serialVersionUID = 7047223653482406256L;

    private final ErrorCode errorCode;
    private String additionalMessage;

    /**
     * Constructor with error code.
     *
     * @param errorCode
     */
    public AppException(final ErrorCode errorCode) {
        super(errorCode.getCode());
        this.errorCode = errorCode;
    }

    /**
     * Constructor with error code and additional message.
     *
     * @param errorCode
     * @param additionalMessage
     */
    public AppException(final ErrorCode errorCode, final String additionalMessage) {
        super(errorCode.getCode());
        this.errorCode = errorCode;
        this.additionalMessage = additionalMessage;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public String getAdditionalMessage() {
        return this.additionalMessage;
    }
}
