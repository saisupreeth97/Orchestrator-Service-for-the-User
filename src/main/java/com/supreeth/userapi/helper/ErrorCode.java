package com.supreeth.userapi.helper;

public enum ErrorCode {
    SRV_ERROR_SERVER_DOWN(
            "SRV_ERROR_SERVER_DOWN",
            "Currently we are expecting a technical issue, please try again later!"
    ),
    SRV_CLIENT_SERVER_DOWN(
            "SRV_CLIENT_SERVER_DOWN",
            "Something went wrong, please try again!"
    )
    ;
    private String error_code;
    private String error_message;

    ErrorCode(String error_code, String error_message) {
        this.error_code = error_code;
        this.error_message = error_message;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }
}
