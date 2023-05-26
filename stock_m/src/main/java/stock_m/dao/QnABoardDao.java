package stock_m.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

import stock_m.dto.QnABoardDto;

@Mapper
public interface QnABoardDao {

    // �� ����� ó���ϴ� �޼���
    int qnainsert(QnABoardDto dto);
    
    // �Խñ� ����� ��ȸ�ϴ� �޼���
    
    
    // ��ü �� ������ ��ȸ�ϴ� �޼���
    int count();
    
    // Ư�� ���� ��ȸ�ϴ� �޼���
    QnABoardDto qnaboardOne(int qnaboardid);
    
    // ���� �����ϴ� �޼���
    int qnaupdateBoard(QnABoardDto dto);
    
    // ���� �����ϴ� �޼���
    int qnadeleteBoard(int qnaboardid);
    
    // Ư�� ���ǿ� �´� �Խñ� ����� ��ȸ�ϴ� �޼���


    // Q&A �Խ��� ����� ��ȸ�ϴ� �޼���
    List<QnABoardDto> qnaboardList(Map<String, Object> m);

    // Q&A �Խ��ǿ��� Ư�� ���ǿ� �´� �Խñ� ����� ��ȸ�ϴ� �޼���
    List<QnABoardDto> qnasearchBoard(Map<String, Object> m);

    // Q&A �Խ��ǿ��� Ư�� ���ǿ� �´� �Խñ� ����� ��¥�� �˻��ϴ� �޼���
    List<QnABoardDto> qnasearchDateBoard(Map<String, Object> m);



	int qnaaddReadcount(int qnaboardid);
}

