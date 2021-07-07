package com.mannajob.service;

import java.util.Date;
import java.util.List;

import com.mannajob.domain.BMatchVO;
import com.mannajob.domain.BmatchProfileVO;
import com.mannajob.domain.Criteria;
import com.mannajob.domain.CriteriaProfile;
import com.mannajob.domain.EmplVO;

public interface BMatchService {

	public List<BMatchVO> getList(BMatchVO bMatchVO);
	
	public List<BmatchProfileVO> getListProfile(BmatchProfileVO bmatchProfileVO);
	public List<BmatchProfileVO> getListProfileSearch(BmatchProfileVO bmatchProfileVO);
	
	public List<BMatchVO> getListWithPaging(Criteria cri,BMatchVO bMatchVO);
	
	public List<BMatchVO> search(BMatchVO bMatchVO);
	
	public List<BMatchVO> searchWithPaging(BMatchVO bMatchVO ,Criteria cri);
	
	public BMatchVO read(int b_num);
	
	public void update(BMatchVO bMatchVO);
	
	public void delete(int b_num);
	
	public int getTotalCount(Criteria cri,BMatchVO bMatchVO);
	
	public void insert(BMatchVO bMatchVO);
	
	public boolean StateChange(int b_num, int state);
	
	public List<EmplVO> searchEmpl(BMatchVO bMatchVO);
	
	public int getEmplCount(BMatchVO bMatchVO);
	
	public List<EmplVO> searchEmplPaging(CriteriaProfile cri, BMatchVO bMatchVO);
	
	public void cancel(int b_num);
	
	public int getPersonTotalCount(String m_id);
	
//	통계
	public int getDailycount(int daygap);
	public int getDailycount2(int daygap);
	
	public List<BMatchVO> rankCorp();
	public List<BMatchVO> rankLocation();
	public List<BMatchVO> rankTask();

	public Date getDate(int i);
	
	public int sumprice(int num);

	public int sumprice2(int num);
//	끝
	
	public List<BMatchVO> getRestBmatchList(String m_id);
}
