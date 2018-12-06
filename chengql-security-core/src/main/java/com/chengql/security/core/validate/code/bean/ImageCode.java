package com.chengql.security.core.validate.code.bean;

import java.awt.image.BufferedImage;

/**
 * 图形验证码模型
 * @Author qlcheng
 * @date 2018/10/25
 */
public class ImageCode extends BaseValidateCode {

    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn){
        super(code, expireIn);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
