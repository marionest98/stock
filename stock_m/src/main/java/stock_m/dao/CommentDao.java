package stock_m.dao;


import org.apache.ibatis.annotations.Mapper;
import java.util.Map;
import stock_m.dto.CommentDto;

import java.util.List;

@Mapper
public interface CommentDao {

    // ��� ����

    void createComment(CommentDto commentDto);

    // ��� ��� ��ȸ

    List<CommentDto> commentList(Map<String, Object> m);

    // ��� �� ��ȸ

    CommentDto commentForm(int qnaboardid);
}
