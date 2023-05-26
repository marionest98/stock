package stock_m.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stock_m.dao.QnABoardDao;

import stock_m.dto.QnABoardDto;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QnABoardService {
    @Autowired
    QnABoardDao dao;

    // �Խñ� �� ��ȸ
    public int count() {
        return dao.count();
    }

    // Ư�� ������ �Խñ� ��� ��ȸ


    // Ư�� ���ǿ� �´� �Խñ� ��� �˻�

    // �Խñ� ���
    public int qnainsert(QnABoardDto dto) {
        return dao.qnainsert(dto);
    }

    // Ư�� �Խñ� ��ȸ
    public QnABoardDto qnaboardOne(int qnaboardid) {
        return dao.qnaboardOne(qnaboardid);
    }

    // �Խñ� ����
    public int qnaupdateBoard(QnABoardDto dto) {
        return dao.qnaupdateBoard(dto);
    }

    // �Խñ� ����
    public int qnadeleteBoard(int qnaboardid) {
        return dao.qnadeleteBoard(qnaboardid);
    }


    // Q&A �Խ��� ��� ��ȸ
    public List<QnABoardDto> qnaboardsList(int start) {
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("start", start);
        m.put("count", 10);
        // Q&A �Խ��ǿ� Ưȭ�� ��ȸ ������ �ۼ��ϼ���.
        // ��: m.put("category", "Q&A");
        return dao.qnaboardList(m);
    }

    // Q&A �Խ��� �˻�
    public List<QnABoardDto> qnaboardsSearch(String field, String keyword, int start, Date startDate, Date endDate) {
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("field", field);
        m.put("keyword", keyword);
        m.put("start", start);
        m.put("count", 10);
        m.put("startDate", startDate);
        m.put("endDate", endDate);
        return dao.qnasearchBoard(m);
    }

	public int qnaaddReadcount(int qnaboardid) {
		return dao.qnaaddReadcount(qnaboardid);
		// TODO Auto-generated method stub
		
	}
}
