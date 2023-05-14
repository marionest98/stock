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
    
    // Ư�� ���� ��ȸ�ϴ� �޼���
    BoardDto boardOne(int boardno);
    
    // ���� �����ϴ� �޼���
    int updateBoard(BoardDto dto);
    
    // ���� �����ϴ� �޼���
    int deleteBoard(int boardno);
    
    // Ư�� ���ǿ� �´� �Խñ� ����� ��ȸ�ϴ� �޼���
    List<BoardDto> searchBoard(Map<String, Object> m);
}