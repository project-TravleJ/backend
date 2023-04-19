package com.travlej.backend.member.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Member")
@Table(name = "member")
@Getter
@Setter
@Builder @AllArgsConstructor @NoArgsConstructor
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "SEQ_MEMBER_CODE",
        initialValue = 1,
        allocationSize = 1
)
public class Member {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR"
    )
    @Column(name = "MEMBER_CODE")
    private int memberCode;

    @Column(name = "MEMBER_ID", unique = true)
    private String memberId;

    @Column(name = "MEMBER_NICKNAME", unique = true)
    private String memberNickname;

    @Column(name = "MEMBER_PWD")
    private String memberPwd;

    @Column(name = "STATUS")
//    @ColumnDefault("0")
    private int status;

    @Column(name = "GRADE")
//    @ColumnDefault("일반")
    private String grade;

    @CreatedDate
    @Column(name = "JOIN_DATE")
    private String joinDate;

    @LastModifiedDate
    @Column(name = "LAST_ACCESS_DATE")
    private String lastAccessDate;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Builder.Default
    @JsonManagedReference
    private List<Authority> roles = new ArrayList<>();

    public void setRoles(List<Authority> role) {
        this.roles = role;
        role.forEach(o -> o.setMember(this));
    }

//    @Column(name = "TOKEN")
//    private String token;

    @PrePersist
    public void onPrePersist(){
        this.joinDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.lastAccessDate = this.joinDate;
}

    @PreUpdate
    public void onPreUpdate(){
        this.lastAccessDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
}

}