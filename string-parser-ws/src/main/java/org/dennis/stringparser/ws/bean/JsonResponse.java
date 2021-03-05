package org.dennis.stringparser.ws.bean;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.dennis.stringparser.ws.exception.ErrorCode;

/**
 * Author:   dsu01
 * Date:     2021/2/28 10:21 下午
 * Description:
 */
public class JsonResponse {

    @JsonProperty("success")
    private boolean isSuccess = false;

    @JsonProperty("body")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object body;

    @JsonProperty("error")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Error error;

    /**
     * Create a default success response, the body is an empty object.
     *
     * @return
     */
    public static JsonResponse ok() {
        return new JsonResponse(new HashMap<>());
    }

    /**
     * Create a default failed response.
     *
     * @param e
     *
     * @return
     */
    public static JsonResponse failed() {
        return new JsonResponse();
    }

    private JsonResponse() {
        // empty
    }

    private JsonResponse(final Object body) {
        this.isSuccess = true;
        this.body = body;
    }

    private JsonResponse(final String errorCode, final String errorMessage) {
        this.isSuccess = false;
        this.error = new Error(errorCode, errorMessage);
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public JsonResponse withSuccess(final boolean success) {
        this.isSuccess = success;
        return this;
    }

    public Object getBody() {
        return this.body;
    }

    public JsonResponse withBody(final Object body) {
        this.body = body;
        return this;
    }

    public Error getError() {
        return this.error;
    }

    public JsonResponse withError(final Error error) {
        this.error = error;
        return this;
    }

    public JsonResponse withErrorCode(final ErrorCode errorCode) {
        if (this.error == null) {
            this.error = new Error();
        }
        this.error.setCode(errorCode.name());
        return this;
    }

    public JsonResponse withErrorMessage(final String errorMsg) {
        if (this.error == null) {
            this.error = new Error();
        }
        this.error.setMessage(errorMsg);
        return this;
    }

    public static class Error {
        private String code;
        private String message;

        public Error() {
            // empty
        }

        public Error(final String code, final String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return this.code;
        }

        public void setCode(final String code) {
            this.code = code;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(final String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "Error{" +
                    "code='" + this.code + '\'' +
                    ", message='" + this.message + '\'' +
                    '}';
        }
    }
}
