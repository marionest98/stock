package stock_m.dto;

import java.util.Date;

import lombok.Data;
 @Data
 
public class QnABoardDto {
	 
    private int qnaboardid;        // �� ��ȣ
    private String userid;      // ����� ID
    private String subject;     // �� ����
    private String content;     // �� ����
    private Date regdate;       // �����
    private int readcount;      // ��ȸ��
    private boolean secret;
    private String role;
    // ������, Getter �� Setter �޼ҵ�

    // �߰����� �ʵ峪 �޼ҵ���� �ۼ��� �� �ֽ��ϴ�.
}