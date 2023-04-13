package com.travlej.backend.attraction.dto;

public class AttractionDTO {

    private int attractionId;
    private String attractionName;
    private int attractionLat;
    private int attractionLng;
    private String attractionDef;

    private AttractionDTO() {
    }

    public AttractionDTO(int attractionId, String attractionName, int attractionLat, int attractionLng, String attractionDef) {
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
        return "AttractionDTO{" +
                "attractionId=" + attractionId +
                ", attractionName='" + attractionName + '\'' +
                ", attractionLat=" + attractionLat +
                ", attractionLng=" + attractionLng +
                ", attractionDef='" + attractionDef + '\'' +
                '}';
    }
}

