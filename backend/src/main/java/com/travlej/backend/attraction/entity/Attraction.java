package com.travlej.backend.attraction.entity;

import javax.persistence.*;

@Entity(name = "ATTRACTION")
@Table(name = "request_regit")
@SequenceGenerator(
        name = "ATTRACTION_SEQ_GENERATOR",
        sequenceName = "SEQ_ATTRACTION_CODE",
        initialValue = 1,
        allocationSize = 1
)
public class Attraction {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ATTRACTION_SEQ_GENERATOR"
    )
    @Column(name = "id")
    private int attractionId;

    @Column(name = "name")
    private String attractionName;

    @Column(name = "lat")
    private int attractionLat;

    @Column(name = "lng")
    private int attractionLng;

    @Column(name = "def")
    private String attractionDef;

    public Attraction() {}

    public Attraction(int attractionId, String attractionName, int attractionLat, int attractionLng, String attractionDef) {
        this.attractionId = attractionId;
        this.attractionName = attractionName;
        this.attractionLat = attractionLat;
        this.attractionLng = attractionLng;
        this.attractionDef = attractionDef;
    }

    public int getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(int attractionId) {
        this.attractionId = attractionId;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public int getAttractionLat() {
        return attractionLat;
    }

    public void setAttractionLat(int attractionLat) {
        this.attractionLat = attractionLat;
    }

    public int getAttractionLng() {
        return attractionLng;
    }

    public void setAttractionLng(int attractionLng) {
        this.attractionLng = attractionLng;
    }

    public String getAttractionDef() {
        return attractionDef;
    }

    public void setAttractionDef(String attractionDef) {
        this.attractionDef = attractionDef;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "attractionId=" + attractionId +
                ", attractionName='" + attractionName + '\'' +
                ", attractionLat=" + attractionLat +
                ", attractionLng=" + attractionLng +
                ", attractionDef='" + attractionDef + '\'' +
                '}';
    }
}
