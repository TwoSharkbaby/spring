package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
	
	public List<ReplyVO> getList(Criteria cri, Long bno);
	// CRUD
	public int register(ReplyVO reply);
	
	public ReplyVO get(Long rno);
	
	public int modify(ReplyVO reply);
	
	public int remove(ReplyVO reply);
	
	
}
