package stock_m.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;


import stock_m.dto.BoardDto;

@Mapper

public interface BoardDao {
	
    // �� ����� ó���ϴ� �޼���
    int insert(BoardDto dto);
    
    // �Խñ� ����� ��ȸ�ϴ� �޼���
    List<BoardDto> boardList(Map<String, Object> m);
    
    // ��ü �� ������ ��ȸ�ϴ� �޼���
    int count();
    int addReadcount(int qnaboardid);
    // Ư�� ���� ��ȸ�ϴ� �޼���
    BoardDto boardOne(int qnaboardid);
    
    // ���� �����ϴ� �޼���
    int updateBoard(BoardDto dto);
    
    // ���� �����ϴ� �޼���
    int deleteBoard(int qnaboardid);
    
 
    
    // Ư�� ���ǿ� �´� �Խñ� ����� ��ȸ�ϴ� �޼���
    List<BoardDto> searchBoard(Map<String, Object> m);
    
    List<BoardDto> searchDateBoard(Map<String, Object> m);
}