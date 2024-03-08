package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
  @Autowired
  private BoardMapper mapper;
  
  //전체 조회 단위 테스트
  @Test
  public void testGetList() {
    //람다식
    mapper.getList().forEach(board->log.info(board));
  }
  
  //작성 단위 테스트
  @Test
  public void testInsert() {
    BoardVO board = new BoardVO();
    board.setTitle("테스트용 글입니다");
    board.setContent("내용테스트~~~~!!!");
    board.setWriter("오주리");
    
    mapper.insert(board);
    
    //bno의 값이 null로 비어있는 것을 볼 수 있다.
    log.info(board);
  }
  
  //작성 단위 테스트(bno의 값을 가져옴)
  @Test
  public void testInsertSelectKey() {
    BoardVO board = new BoardVO();
    board.setTitle("insertSelectKey 테스트용 글입니다");
    board.setContent("insertSelectKey 내용테스트~~~~!!!");
    board.setWriter("오주리");
    
    mapper.insertSelectKey(board);
    
    log.info(board);
  }
  
  //상세보기 단위 테스트
  @Test
  public void testRead() {
    BoardVO board = mapper.read(4L);
    
    log.info(board);
  }
  
  //삭제 단위 테스트
  @Test
  public void testDelete() {
    log.info("DELETE count: " + mapper.delete(3L));
  }
  
  //게시글 수정 테스트
  @Test
  public void testUpdate() {
    BoardVO board = new BoardVO();
    board.setBno(4L);
    board.setTitle("수정된 제목");
    board.setContent("수정된 내용");
    board.setWriter("user00");
    
    int count = mapper.update(board);
    log.info("UPDATE COUNT: "+count);
  }
}
