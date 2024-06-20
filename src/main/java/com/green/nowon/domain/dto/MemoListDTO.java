package com.green.nowon.domain.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder 
public class MemoListDTO {
	
	private long no;
	private String content;
	private String writer;
	private LocalDateTime updatedAt;

}
