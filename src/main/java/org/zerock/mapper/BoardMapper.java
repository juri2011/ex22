package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardMapper {
  //SQL을 어노테이션으로 작성할 때는 반드시 ';'(세미콜론)이 없도록 작성
  //전체 검색
  //@Select("select * from tbl_board where bno > 0") - annotation 방식
  public List<BoardVO> getList();
  
  //게시글 작성(seq_board.nextval을 이용해 자동으로 번호가 주어진다)
  public void insert(BoardVO board);
  
  //게시글 작성(bno에 들어갈 값을 sql로 먼저 처리한 다음 작성한다.)
  //자동으로 추가되는 PK값을 확인해야 하는 상황에 유용하다
  public void insertSelectKey(BoardVO board);
  
  //게시글 상세보기
  public BoardVO read(Long bno);
  
  //게시글 삭제
  public int delete(Long bnt);
  
  //게시글 수정
  public int update(BoardVO board);
}
