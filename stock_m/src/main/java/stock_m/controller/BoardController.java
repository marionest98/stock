package stock_m.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import stock_m.dto.BoardDto;
import stock_m.dto.UserDto;
import stock_m.service.BoardService;
import java.util.List;

@SessionAttributes("user")
@Controller
public class BoardController {

    @Autowired
    BoardService service;
    
    // "user"��� �̸����� UserDto ��ü�� Model�� �߰��ϴ� �޼���
    @ModelAttribute("user")
    public UserDto getDto() {
        return new UserDto();
    }

    // �� �ۼ� ���� �����ִ� GET ��û ó�� �޼���
    @GetMapping("/normal/write")
    public String writeForm(@ModelAttribute("user")UserDto dto) {
        return "normal/write";// normal/write ���ø��� ��ȯ�Ͽ� �� �ۼ� ���� ������
    }
    
    // �� �ۼ��� ó���ϴ� POST ��û ó�� �޼���
    @PostMapping("/normal/write")
    public String write(BoardDto dto) {
        service.insert(dto);// ���޹��� �� �����͸� �����ͺ��̽��� ����
        return "redirect:list";  // �� �ۼ� �� �� ��� �������� �����̷�Ʈ
    }
    
    // �� ����� ��ȸ�ϴ� GET ��û ó�� �޼���
    @GetMapping("/normal/list")
    public String list(@RequestParam(name = "p", defaultValue = "1") int page,
            @RequestParam(name = "field", required = false) String field,
            @RequestParam(name = "keyword", required = false) String keyword,
            Model m)  {

 
        int count = service.count(); // ��ü �� ���� ��ȸ
        if(count > 0) {

        int perPage = 10; // �� �������� ���� ���� ����
        int startRow = (page - 1) * perPage;

        List<BoardDto> boardList;
        // �˻�� ���� ��� �˻� ���ǿ� ���� �Խñ��� �˻�
        if (keyword != null && !keyword.isEmpty()) {
            boardList = service.searchBoard(field, keyword, startRow);
        } else {
            boardList = service.boardList(startRow); // �ش� �������� �´� �� ��� ��ȸ

        }

        m.addAttribute("bList", boardList);

        int pageNum = 5;  // ����¡�� ������ ������ ��ȣ�� ����
        int totalPages = count / perPage + (count % perPage > 0 ? 1 : 0); // ��ü ������ ��

        int begin = (page - 1) / pageNum * pageNum + 1; // ���� ������ ��ȣ
        int end = begin + pageNum - 1;  // �� ������ ��ȣc
        if (end > totalPages) {
            end = totalPages;
        }
        m.addAttribute("begin", begin);
        m.addAttribute("end", end);
        m.addAttribute("pageNum", pageNum);
        m.addAttribute("totalPages", totalPages);

        }
        m.addAttribute("count", count);
        return "normal/list";// normal/list ���ø��� ��ȯ�Ͽ� �� ����� ������
    }

 // �� ������ �����ִ� GET ��û ó�� �޼���
    @GetMapping("normal/content/{boardno}")
    public String content(@ModelAttribute("user") UserDto user, @PathVariable int boardno, Model m) {
        // ��û URL���� {boardno}�� �ش��ϴ� �� ��ȣ�� �޾ƿ�
        // �ش� �� ��ȣ�� ����Ͽ� service�� boardOne �޼��带 ȣ���Ͽ� �ش� ���� ������ ������
        BoardDto dto = service.boardOne(boardno);
        // ������ �� ������ Model�� �߰��Ͽ� ��� ����
        m.addAttribute("dto", dto);
        // normal/content ���ø��� ��ȯ�Ͽ� �ش� ���� ������ ������
        return "normal/content";
    }

    // �� ���� ���� �����ִ� GET ��û ó�� �޼���
    @GetMapping("normal/update/{boardno}")
    public String updateForm(@PathVariable int boardno, Model m) {
        // ��û URL���� {boardno}�� �ش��ϴ� �� ��ȣ�� �޾ƿ�
        // �ش� �� ��ȣ�� ����Ͽ� service�� boardOne �޼��带 ȣ���Ͽ� �ش� ���� ������ ������
        BoardDto dto = service.boardOne(boardno);
        // ������ �� ������ Model�� �߰��Ͽ� ��� ����
        m.addAttribute("dto", dto);
        // normal/updateform ���ø��� ��ȯ�Ͽ� �ش� ���� ���� ���� ������
        return "normal/updateform";
    }

    // �� ������ ó���ϴ� PUT ��û ó�� �޼���
    @PutMapping("/normal/update")
    public String update(BoardDto dto) {
        // ���޹��� ������ �� ������ service�� updateBoard �޼��带 ȣ���Ͽ� ������Ʈ
        service.updateBoard(dto);
        // �� ���� �� �� ��� �������� �����̷�Ʈ
        return "redirect:list";
    }

    // �� ������ ó���ϴ� DELETE ��û ó�� �޼���
    @DeleteMapping("/normal/delete")
    @ResponseBody
    public String delete(int boardno) {
        // ��û �Ķ���ͷ� ���޹��� �� ��ȣ�� ����Ͽ� service�� deleteBoard �޼��带 ȣ���Ͽ� �� ����
        int i = service.deleteBoard(boardno);
        // ������ ���� ���� ���ڿ��� ��ȯ
        return "" + i;
    }
}