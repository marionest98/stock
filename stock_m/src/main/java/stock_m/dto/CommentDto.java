package stock_m.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CommentDto {
    private int commentid;       // ��� ��ȣ
    private int qnaboardid;      // ���� �Խñ� ��ȣ
    private String userid;       // �ۼ��� ID
    private String content;      // ��� ����
    private Date regdate;        // �����
}
