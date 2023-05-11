package stock_m.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.MimeMappings.Mapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.websocket.server.PathParam;
import stock_m.dto.BuyDto;
import stock_m.dto.RevenueDto;
import stock_m.dto.SellDto;
import stock_m.service.RevenueService;

@Controller
public class RevenueController {
	@Autowired
	RevenueService service;

	
	  @GetMapping("/company/rinsert") 
	  public String writeform() { 
		  return"/company/rinsert"; }
	  
	  @PostMapping("/company/rinsert") 
	  public String write(RevenueDto dto) {
	  service.insert(dto); 
	  return "redirect:/"; }
	 
	
	//@ModelAttribute("user") MemDto dto) {//1.세션서장값 dto 에넘겨줌 2. 파라미터값 저장(id는 그대로) sesssion에 저장되 내용 바뀜=>db도업데이트 해줘야함
	//dto에 아이디값은 포함되지않았음

	  @RequestMapping("/company/confirm")
		public String list(@RequestParam(name="p", defaultValue = "1") int page, Model m ) {
		  System.out.println("is");
			//글이 있는지 체크
			int count = service.count();//글갯수
			System.out.println("par");
			if(count > 0) {
				System.out.println("am");
			int perPage = 10; // 한 페이지에 보일 글의 갯수
			int startRow = (page - 1) * perPage;//0부터시작하기 때문에 1뺌
			String userid="1";
			  List<RevenueDto> rlist = service.selectOne(userid); 
			  m.addAttribute("rlist",rlist);
			  List<SellDto> sellList = service.sellList(userid); 
			  m.addAttribute("sellList",sellList);
			  List<BuyDto> buyList = service.buyList(userid); 
			  m.addAttribute("buyList",buyList);
			  List<RevenueDto> boardList = service.boardList(startRow);
			  
			m.addAttribute("bList", boardList);
			System.out.println("2am");
			int pageNum = 5;//보여질 페이지 번호수
			int totalPages = count / perPage + (count % perPage > 0 ? 1 : 0); //전체 페이지 수
			
			int begin = (page - 1) / pageNum * pageNum + 1;
			int end = begin + pageNum -1;
			if(end > totalPages) {
				end = totalPages;
			}
			 m.addAttribute("begin", begin);
			 m.addAttribute("end", end);
			 m.addAttribute("pageNum", pageNum);
			 m.addAttribute("totalPages", totalPages);
			 System.out.println("3am");
			}
			System.out.println("4am");
			m.addAttribute("count", count);
			System.out.println("5am");
			return "/company/confirm";
		}
	  	
		  @GetMapping("/company/rdelete")
		   public String delete(@RequestParam int sno) {
			  System.out.println(sno);
			  service.deleteRef(sno);	
			  System.out.println("this");
			  return "/company/confirm";
			  }
		  
		  @GetMapping("/company/rcheckdelete")
		  public String rcheckdelete(@RequestParam("selectedItems[]") int[] selectedItems) {
		    for (int selectedItem : selectedItems) {
		      int sno = selectedItem;
		      service.deleteRef(sno);
		    }
		    return "redirect:/company/confirm";
		  }
		  
		  @GetMapping("/company/rcheckupdate")
		  public String rupcheckit(@RequestParam("selectedItems[]")List<SellDto> dto) {
			
			  for (SellDto dt: dto) {
			  System.out.println(dt.getSno());}
			 //service.updateRefOne(sn); 
		    
			 return "redirect:/company/confirm";
		  }

		
}
