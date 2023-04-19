package com.travlej.backend.bulletinInfo.entity;

import javax.persistence.*;

@Entity(name = "BULLETININFO")
@Table(name = "bulletin")
@SequenceGenerator(
        name = "BULLETININFO_SEQ_GENERATOR",
        sequenceName = "SEQ_BULLETININFO_CODE",
        initialValue = 1,
        allocationSize = 1
)
public class BulletinInfo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "BULLETININFO_SEQ_GENERATOR"
    )
    @Column(name = "code")
    private int bulletinInfoCode;
    @Column(name = "subject")
    private String bulletinInfoSubject;
    @Column(name = "date")
    private String bulletinInfoDate;
    @Column(name = "case")
    private String bulletinInfoCase;
    @Column(name = "nick")
    private String bulletinInfoNick;

    public BulletinInfo() {}

    public BulletinInfo(int bulletinInfoCode, String bulletinInfoSubject, String bulletinInfoDate, String bulletinInfoCase, String bulletinInfoNick) {
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
        return "BulletinInfo{" +
                "bulletinInfoCode=" + bulletinInfoCode +
                ", bulletinInfoSubject='" + bulletinInfoSubject + '\'' +
                ", bulletinInfoDate='" + bulletinInfoDate + '\'' +
                ", bulletinInfoCase='" + bulletinInfoCase + '\'' +
                ", bulletinInfoNick='" + bulletinInfoNick + '\'' +
                '}';
    }
}
