package com.green.nowon.domain.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class BaseEntity {
	
		@Column(columnDefinition = "timestamp")
		@CreationTimestamp
		protected LocalDateTime createdAt;
		
		@Column(columnDefinition = "timestamp")
		@UpdateTimestamp
		protected LocalDateTime updatedAt;

}
