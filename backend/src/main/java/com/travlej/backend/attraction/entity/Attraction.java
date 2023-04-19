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
    private double attractionLat;

    @Column(name = "lng")
    private double attractionLng;

    @Column(name = "def")
    private String attractionDef;

    public Attraction() {}

    public Attraction(int attractionId, String attractionName, double attractionLat, double attractionLng, String attractionDef) {
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

    public double getAttractionLat() {
        return attractionLat;
    }

    public void setAttractionLat(double attractionLat) {
        this.attractionLat = attractionLat;
    }

    public double getAttractionLng() {
        return attractionLng;
    }

    public void setAttractionLng(double attractionLng) {
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


//public class Attraction {
//    @Id
//    private Long id;
//    private String name;
//    @Column(columnDefinition = "json")
//    private String loc;
//    private String def;
//
//    public Attraction(){}
//
//    public Attraction(Long id, String name, String loc, String def) {
//        this.id = id;
//        this.name = name;
//        this.loc = loc;
//        this.def = def;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLoc() {
//        return loc;
//    }
//
//    public void setLoc(String loc) {
//        this.loc = loc;
//    }
//
//    public String getDef() {
//        return def;
//    }
//
//    public void setDef(String def) {
//        this.def = def;
//    }
//
//    @Override
//    public String toString() {
//        return "Attraction{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", loc='" + loc + '\'' +
//                ", def='" + def + '\'' +
//                '}';
//    }
//}

