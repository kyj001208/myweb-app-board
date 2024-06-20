package com.green.nowon.service.impl;

import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dto.MemoSaveDTO;
import com.green.nowon.domain.dto.MemoUpdateDTO;
import com.green.nowon.domain.entity.MemoEntity;
import com.green.nowon.domain.entity.MemoEntityRepository;
import com.green.nowon.service.MemoService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
//빈(어노케이션)은 컨테이너에서 관리 
@Service //->spring container : -> ApplicationContext 
public class MemoServiceProcess implements MemoService {

	private final MemoEntityRepository repository;
	
	//db에 저장해주는 service_오버라이드
	@Override
	public void saveProcess(MemoSaveDTO dto) {
		
		repository.save(dto.toEntity());//entity에 보내주기 위한 편의메서드 생성 
	}

	//db에 저장된것을 조회해주는 service
	@Override
	public void listProcess(Model model) {
		
		//model.addAttribute("list", repository.findAll()); 이렇게도 가능하지만 바로 엔터티로 감
		
		Sort sort=Sort.by(Direction.DESC, "no"); //정렬처리
		Pageable pageable=PageRequest.of(0, 5,sort); //페이지 처리
		
		
		//페이지, 정렬, DTO 매핑해서 전달
		model.addAttribute("list", repository.findAll(pageable).stream()
							//.map(ent->ent.toListDTO()) //이렇게만으로도 가능
							.map(MemoEntity::toListDTO)
							.collect(Collectors.toList()));
		
	}
	//삭제 처리해주는 service
	@Override
	public void deleteProcess(long no) {
		//jpa pk로 삭제처리하는 기능제공 
		repository.deleteById(no); //deleteById():id(pk)를 통해 삭제한다는 메서드(pk만!!!) 
	
	}

	//업데이트 처리해주는 service
	
	@Transactional
	@Override
	public void updateProcess(long no, MemoUpdateDTO dto) {
		//1. 존재하는 조회 후 -sqlSession 유지되어 있으면 update 처리됨
		//2. entity객체를 수정하세요 
		repository.findById(no).orElseThrow().update(dto);
		//.update(dto) :편의 메서드 
		
	}

}
