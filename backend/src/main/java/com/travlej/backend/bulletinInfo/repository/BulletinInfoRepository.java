package com.travlej.backend.bulletinInfo.repository;

import com.travlej.backend.bulletinInfo.entity.BulletinInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BulletinInfoRepository extends JpaRepository<BulletinInfo, Integer> {

    List<BulletinInfo> findByBulletinInfoSubjectContaining(String bulletinInfoSubject);
}

