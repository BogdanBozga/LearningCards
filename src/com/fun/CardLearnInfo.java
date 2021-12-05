package com.fun;

public class CardLearnInfo {
    private String textInfo;
    private String imageInfo;

    CardLearnInfo(String textInfo, String imageInfo){
        textInfo = new String(" ");
        imageInfo = new String(" ");
        this.textInfo = textInfo;
        this.imageInfo = imageInfo;
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
