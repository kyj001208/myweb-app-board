package com.green.nowon.service;

import org.springframework.ui.Model;

import com.green.nowon.domain.dto.MemoSaveDTO;
import com.green.nowon.domain.dto.MemoUpdateDTO;

public interface MemoService {

	void saveProcess(MemoSaveDTO dto);

	void listProcess(Model model);

	void deleteProcess(long no);

	void updateProcess(long no, MemoUpdateDTO dto);

}
