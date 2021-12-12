package com.fun;

public class CardLearnInfo {
    private String textInfo;
    private String imageInfo;

    CardLearnInfo(String textInfo_, String imageInfo_){
        textInfo = new String(" ");
        imageInfo = new String(" ");
        this.textInfo = textInfo_;
        this.imageInfo = imageInfo_;
    }

    public CardLearnInfo(String textInfo) {
        this(textInfo," ");
    }

    public String getTextInfo() {
        return textInfo;
    }

    public String getImageInfo() {
        return imageInfo;
    }

    boolean hasText(){
        return false;
    }
    boolean hasImage(){
        return false;
    }
}
