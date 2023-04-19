package com.travlej.backend.bulletinInfo.dto;

public class BulletinInfoDTO {

    private int bulletinInfoCode;
    private String bulletinInfoSubject;
    private String bulletinInfoDate;
    private String bulletinInfoCase;
    private String bulletinInfoNick;

    private BulletinInfoDTO() {}

    public BulletinInfoDTO(int bulletinInfoCode, String bulletinInfoSubject, String bulletinInfoDate, String bulletinInfoCase, String bulletinInfoNick) {
        this.bulletinInfoCode = bulletinInfoCode;
        this.bulletinInfoSubject = bulletinInfoSubject;
        this.bulletinInfoDate = bulletinInfoDate;
        this.bulletinInfoCase = bulletinInfoCase;
        this.bulletinInfoNick = bulletinInfoNick;
    }

    public int getBulletinInfoCode() {
        return bulletinInfoCode;
    }

    public void setBulletinInfoCode(int bulletinInfoCode) {
        this.bulletinInfoCode = bulletinInfoCode;
    }

    public String getBulletinInfoSubject() {
        return bulletinInfoSubject;
    }

    public void setBulletinInfoSubject(String bulletinInfoSubject) {
        this.bulletinInfoSubject = bulletinInfoSubject;
    }

    public String getBulletinInfoDate() {
        return bulletinInfoDate;
    }

    public void setBulletinInfoDate(String bulletinInfoDate) {
        this.bulletinInfoDate = bulletinInfoDate;
    }

    public String getBulletinInfoCase() {
        return bulletinInfoCase;
    }

    public void setBulletinInfoCase(String bulletinInfoCase) {
        this.bulletinInfoCase = bulletinInfoCase;
    }

    public String getBulletinInfoNick() {
        return bulletinInfoNick;
    }

    public void setBulletinInfoNick(String bulletinInfoNick) {
        this.bulletinInfoNick = bulletinInfoNick;
    }

    @Override
    public String toString() {
        return "BulletinInfoDTO{" +
                "bulletinInfoCode=" + bulletinInfoCode +
                ", bulletinInfoSubject='" + bulletinInfoSubject + '\'' +
                ", bulletinInfoDate='" + bulletinInfoDate + '\'' +
                ", bulletinInfoCase='" + bulletinInfoCase + '\'' +
                ", bulletinInfoNick='" + bulletinInfoNick + '\'' +
                '}';
    }
}