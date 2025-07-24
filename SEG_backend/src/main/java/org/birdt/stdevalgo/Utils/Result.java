package org.birdt.stdevalgo.Utils;

public class Result {
    private Integer status;
    private String result;
    private String message;

    public Result(Integer status, String result, String message) {
        this.status = status;
        this.result = result;
        this.message = message;
    }

    public Result() {}

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Result success(){
        return new Result(1, "success", "Hello World!");
    }

    public static Result success(String message){
        return new Result(1, "success", message);
    }

    @Override
    public String toString() {
        return "Result [statue=" + status + ", result=" + result + ", message=" + message + "]";
    }
}
