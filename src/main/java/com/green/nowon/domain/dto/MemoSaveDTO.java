package com.green.nowon.domain.dto;

import com.green.nowon.domain.entity.MemoEntity;

import lombok.Setter;

@Setter //파라미터 값과 일치하려면 setter 메서드 필요(매핑해주는 역할)
public class MemoSaveDTO {
	
	private String writer;
	private String content;
	

	
	public MemoEntity toEntity() {
		
		return MemoEntity.builder()
				.writer(writer).content(content)
				.build();
	}
	

}
