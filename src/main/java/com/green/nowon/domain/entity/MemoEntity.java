package com.green.nowon.domain.entity;

import org.hibernate.annotations.DynamicUpdate;

import com.green.nowon.domain.dto.MemoListDTO;
import com.green.nowon.domain.dto.MemoUpdateDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@DynamicUpdate
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE) //빌더를 사용하려고 생성자초기화 막아주는것
@NoArgsConstructor
@Entity
@Table(name = "memo")
public class MemoEntity extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	
	@Column(nullable = false)
	private String content;
	
	
	private String writer;
	private int readCount;
	
	
	//업데이트를 하기 위한 편의메서드 (수정메서드)
	public void update(MemoUpdateDTO dto) {
		this.content=dto.getContent();
		this.writer=dto.getWriter();
		//return this;
	}
	
	
	
	public MemoListDTO toListDTO() {//엔터티를 DTO로 변경하는 메서드 (조회 시 사용하는 편의 메서드)
		
		return MemoListDTO.builder()
				.no(no).content(content).writer(writer)
				.updatedAt(updatedAt)
				.build();
	}



}
