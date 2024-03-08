package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardMapper {
  //SQL을 어노테이션으로 작성할 때는 반드시 ';'(세미콜론)이 없도록 작성
  //전체 검색
  //@Select("select * from tbl_board where bno > 0") - annotation 방식
  public List<BoardVO> getList();
}
