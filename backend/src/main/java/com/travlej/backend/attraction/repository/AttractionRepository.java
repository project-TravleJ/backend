package com.travlej.backend.attraction.repository;

import com.travlej.backend.attraction.dto.AttractionDTO;
import com.travlej.backend.attraction.entity.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/* Repository : 기능이 거의 없음
 * CrudRepository : 기본적인 CRUD 기능을 추가 제공함
 * PagingAndSortingRepository : 페이징 및 정렬 처리하는 기능을 추가 제공
 * JpaRepository : CrudRepository 의 기능과 PagingAndSortingRepository 기능을 모두 제공한
 *                 추가적으로 JPA에 특하된 메소드 기능을 제공
 * 쿼리 메소드
 * : JPQL을 메소드로 대신 터리할 수 있도록 제공하는 기능
 * 메소드의 이름으로 필요한 쿼리를 만들어주는 기능으로 "find + 엔티티이름 + BY + 변수이름"과 같이 네이밍
 * ex) findAttractionByAttractinId() : Attraction 엔티티에서 Id 속성에 대해 조건처리
 * 엔티티의 이름을 생략하고 쓸수있는데 이는 해당 Repository 인터페이스의 타입 파라메터로 정의한 부분을 자동으롤 인식하기때문
 * ex> findByAttracionId() <- 생략가능
 * */

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Integer> {

//    List<Attraction> findByAttractionNameContaining(String attractionName);

    List<Attraction> findByAttractionNameContaining(String attractionName);
}

//public interface AttractionRepository extends JpaRepository<Attraction, Long> {}




