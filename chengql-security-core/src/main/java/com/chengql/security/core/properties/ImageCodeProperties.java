package com.chengql.security.core.properties;

/**
 * 图形验证码配置属性
 * @Author qlcheng
 * @date 2018/10/25
 */
public class ImageCodeProperties {

    private int width;
    private int height;
    private int length;
    private int expireIn = 60;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }
}
