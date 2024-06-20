package com.green.nowon.domain.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Setter
@Getter
public class MemoUpdateDTO {
	
	private String content;
	private String writer;

	
}
