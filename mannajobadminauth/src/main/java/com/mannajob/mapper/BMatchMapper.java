package com.mannajob.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mannajob.domain.BMatchVO;
import com.mannajob.domain.BmatchProfileVO;
import com.mannajob.domain.Criteria;
import com.mannajob.domain.CriteriaProfile;
import com.mannajob.domain.EmplVO;

public interface BMatchMapper {
//	전체검색
	public List<BMatchVO> getList(String b_category);
	
	public List<BmatchProfileVO> getListProfile(String b_category);
	public List<BmatchProfileVO> getListProfileSearch(@Param("b_category") String b_category, @Param("b_corp") String b_corp);
	
	public List<BMatchVO> getListWithPaging(@Param("cri") Criteria cri, @Param("b_category")String b_category);
	
	public void insert(BMatchVO bMatchVO);
	
	public BMatchVO read(int b_num);
	
	public void delete(int b_num);
	
	public void update(BMatchVO bMatchVO);
	
	public int getTotalCount(@Param("cri") Criteria cri, @Param("bMatchVO")BMatchVO bMatchVO);
//	완료처리
	public void stateFinish(int b_num);
//	취소처리
	public void stateCancel(int b_num);
//  검색
	public List<BMatchVO> search(BMatchVO bMatchVO);
	
	public List<BMatchVO> searchWithPaging(@Param("bMatchVO")BMatchVO bMatchVO,@Param("cri")Criteria cri);

	public List<EmplVO> searchEmpl(BMatchVO bMatchVO);
	
	public int getemplTotalCount(@Param("bMatchVO")BMatchVO bMatchVO);
	
	public List<EmplVO> searchEmplPaging(@Param("bMatchVO")BMatchVO bMatchVO,@Param("cri")CriteriaProfile cri);
	
	public void cancel(int b_num);
	
	public int getPersonTotalCount(String m_id);
//	통계 시작
	public int getDailycount(int daygap);
	
	public int getDailycount2(int daygap);
	
	public List<BMatchVO> rankCorp();
	
	public List<BMatchVO> rankLocation();
	
	public List<BMatchVO> rankTask();

	public Date getDate(@Param("i") int i);

	public int sumprice(@Param("num") int num);

	public int sumprice2(@Param("num") int num);
//	통계 끝
	
//	좋아요, 총 매칭 수 구하기
	public int totalMat(@Param("m_id") String m_id);
	
	public int countG(@Param("m_id") String m_id);
//	끝
	
	public List<BMatchVO> getRestBmatchList(String m_id);
}
