package stock_m.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stock_m.dao.CommentDao;
import stock_m.dto.CommentDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Transactional
    public void createComment(CommentDto commentDto) {
        // ��� ����
        commentDao.createComment(commentDto);
    }

    public List<CommentDto> commentList() {
        // ��� ��� ��ȸ
    	Map<String, Object> m = new HashMap<String, Object>();
        return commentDao.commentList(m);
    }

    public CommentDto commentForm(int commentId) {
        // ��� �� ��ȸ
        return commentDao.commentForm(commentId);
    }
}
