package org.seckill.dto;

/**
 * 封装泛型
 *
 * @param <T>
 */
public class SeckillResult<T> {

    private boolean successs;

    private T data;

    private String error;

    public SeckillResult(boolean successs, T data) {
        this.successs = successs;
        this.data = data;
    }

    public SeckillResult(boolean successs, String error) {
        this.successs = successs;
        this.error = error;
    }

    public boolean isSuccesss() {
        return successs;
    }

    public void setSuccesss(boolean successs) {
        this.successs = successs;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
