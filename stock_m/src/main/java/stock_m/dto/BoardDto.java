package stock_m.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDto {
    private int boardno;        // �� ��ȣ
    private String userid;      // ����� ID
    private String subject;     // �� ����
    private String content;     // �� ����
    private Date regdate;       // �����
    private int readcount;      // ��ȸ��
}