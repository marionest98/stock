package stock_m.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stock_m.dao.BoardDao;
import stock_m.dto.BoardDto;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {
    @Autowired
    BoardDao dao;

    // �Խñ� �� ��ȸ
    public int count() {
        return dao.count();
    }

    // Ư�� ������ �Խñ� ��� ��ȸ
    public List<BoardDto> boardList(int start) {
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("start", start);
        m.put("count", 10);
        return dao.boardList(m);
    }
    // Ư�� ���ǿ� �´� �Խñ� ��� �˻�
    public List<BoardDto> searchDateBoard(String field, String keyword, int start, Date startDate, Date endDate) {
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("field", field);
        m.put("keyword", keyword);
        m.put("start", start);
        m.put("count", 10);
        m.put("startDate", startDate);
        m.put("endDate", endDate);
        return dao.searchDateBoard(m);
    }    
    public List<BoardDto> searchBoard(String field, String keyword, int start) {
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("field", field);
        m.put("keyword", keyword);
        m.put("start", start);
        m.put("count", 10);
        return dao.searchBoard(m);
    }

    // �Խñ� ���
    public int insert(BoardDto dto) {
        return dao.insert(dto);
    }

    // Ư�� �Խñ� ��ȸ
    public BoardDto boardOne(int boardno) {
        return dao.boardOne(boardno);
    }

    // �Խñ� ����
    public int updateBoard(BoardDto dto) {
        return dao.updateBoard(dto);
    }

    // �Խñ� ����
    public int deleteBoard(int boardno) {
        return dao.deleteBoard(boardno);
    }
    public int addReadcount(int boardno) {
    	return dao.addReadcount(boardno);
    }


}