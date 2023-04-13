package com.travlej.backend.member.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor @NoArgsConstructor @Builder
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;
    private String name;

    @JoinColumn(name = "member")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Member member;

    public void setMember(Member member) {
        this.member = member;
    }
}
