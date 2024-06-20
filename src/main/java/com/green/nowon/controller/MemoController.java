package com.green.nowon.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.nowon.domain.dto.MemoSaveDTO;
import com.green.nowon.domain.dto.MemoUpdateDTO;
import com.green.nowon.service.MemoService;
import com.green.nowon.service.impl.MemoServiceProcess;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RequiredArgsConstructor
@Controller
public class MemoController {
	
	//자동으로 주입 DI
	private final MemoService service; //생성자 DI-IOC
	
	
	
	//db에 저장된 내용 조회화면에서 불러오기
	@GetMapping("/memo")
	public String memoList() {
		
		return "views/memo/memo-list";
	}


	
	//memo 저장 (디비에 저장)
	@ResponseBody
	@PostMapping("/memo")
	public  void memoSave(MemoSaveDTO dto) {//파라미터 데이터를 ->DTO에 매핑
		
		service.saveProcess(dto);
		
	}
	
	
	
	//삭제 비동기 컨트롤러 
	@ResponseBody //응답하는 데이터로 가라(페이지가 x) || 성공시에는 success 콜백함수의 인자로 전달
	@DeleteMapping("/memo/{no}")
	public void delete(@PathVariable("no") long no) { //보통은 string으로 하여 view를 리턴해주지만 
		 //해당 컨트롤러는 페이지로 가는것이 아닌 데이터로 가므로 
		// redirect가 아닌 리턴값은 받지 않고 void로 수정
		
		service.deleteProcess(no);
		
		
	}
	
	//Delete 컨트롤러 & 자바 스크립트 후 다시 리스트 화면 불러오는 컨트롤러
	@GetMapping("/ajax/memo")
	public String ajaxList(Model model) {
		//@ResponseBody가 없으면 View=html을 리턴해준다
		
		service.listProcess(model);
		return "views/memo/ajax-list";
	}
	
		
	
	//업데이트 비동기 컨트롤러
	//Controller에 매핑메서드에 매개변수로 객체가 선언되어있으면 spring이 객체를 생성 
	@ResponseBody
	@PutMapping("/memo/{no}")						
	public void update(@PathVariable("no") long no, MemoUpdateDTO dto) {
		
		service.updateProcess(no,dto);
		
		
		
	}
	

}
