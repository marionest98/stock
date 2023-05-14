/*
   Date    : 2023.05.15
   name    : RevenueController
   type    : Controller
   ver     : 1.1
   connect  : confirm.jsp,rbuy.jsp,total.jsp
   content : 판매,구매내역 장부관리 컨트롤러
   writer  : 이이지
   api     : x
  */
package stock_m.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.function.Predicate;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.MimeMappings.Mapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import jakarta.websocket.server.PathParam;
import stock_m.dto.BuyDto;
import stock_m.dto.RevenueDto;
import stock_m.dto.SellDto;
import stock_m.dto.StockDto;
import stock_m.service.RevenueService;

@Controller
public class RevenueController {
	@Autowired
	RevenueService service;
 
	  @GetMapping("/company/sellinsert") 
	  public String sellwrite(@Param("userid") String userid ,@Param("pno")String pno ,@Param("price")int price, @Param("scount") int scount) {
	  		userid ="1" ; 
		  service.sellinsert(userid,pno,price,scount); 
	  return "redirect:/company/confirm"; }
	  
	  @GetMapping("/company/buyinsert") 
	  public String buywrite(@Param("userid") String userid ,@Param("pno")String pno ,@Param("price")int price, @Param("bcount") int bcount) {
	  		userid ="1" ; 
		  service.buyinsert(userid,pno,price,bcount); 
	  return "redirect:/company/rbuy"; }
	
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
			  List<SellDto> rlist = service.selectOne(userid); 
			  m.addAttribute("rlist",rlist);
			  List<SellDto> sellList = service.sellList(userid); 
			  m.addAttribute("sellList",sellList);
			  List<RevenueDto> boardList = service.boardList(startRow);
			  
			m.addAttribute("bList", boardList);
		
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
			
			}
		
			m.addAttribute("count", count);
			
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
		      System.out.println(sno);
		      service.deleteRef(sno);
		    }
		    return "redirect:/company/confirm";
		  }
		  

		  
			
			
			//@ModelAttribute("user") MemDto dto) {//1.세션서장값 dto 에넘겨줌 2. 파라미터값 저장(id는 그대로) sesssion에 저장되 내용 바뀜=>db도업데이트 해줘야함
			//dto에 아이디값은 포함되지않았음

			  @RequestMapping("/company/rbuy")
				public String rbuylist(@RequestParam(name="p", defaultValue = "1") int page, Model m ) {
				  System.out.println("is");
					//글이 있는지 체크
					int count = service.count();//글갯수
					System.out.println("par");
					if(count > 0) {
						System.out.println("am");
					int perPage = 10; // 한 페이지에 보일 글의 갯수
					int startRow = (page - 1) * perPage;//0부터시작하기 때문에 1뺌
					String userid="1";
					 
					  List<BuyDto> rbuyList = service.rbuyList(userid); 
					  m.addAttribute("rbuyList",rbuyList);
//					  List<RevenueDto> boardList = service.boardList(startRow);
//					  
//					m.addAttribute("bList", boardList);
				
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
					
					}
				
					m.addAttribute("count", count);
					
					return "/company/rbuy";
				}
			  	
				  @GetMapping("/company/revbuydel")
				   public String revbuydel(@RequestParam int bno) {
					  System.out.println(bno);
					  service.rbuydelete(bno);	
					  System.out.println("this");
					  return "/company/rbuy";
					  }
				  
				  @GetMapping("/company/revbuycheckdel")
				  public String revbuycheckdel(@RequestParam("selectedItems[]") int[] selectedItems) {
				    for (int selectedItem : selectedItems) {
				      int bno = selectedItem;
				      System.out.println(bno);
				      service.rbuydelete(bno);
				    }
				    return "redirect:/company/rbuy";
				  }
				  

					@GetMapping("/company/revbuyupdate")
					public String updateForm(List<BuyDto> dto ,Model m) {
				             service.rbuyupdate(dto);
						     m.addAttribute("dto",dto);
						return "redirect:/company/rbuy";
					}
		
					
					  @RequestMapping("/company/total")
						public String totallist(@RequestParam(name="p", defaultValue = "1") int page, Model m ) {
						  System.out.println("is");
							//글이 있는지 체크
							int count = service.count();//글갯수
							System.out.println("par");
							if(count > 0) {
								System.out.println("am");
							int perPage = 10; // 한 페이지에 보일 글의 갯수
							int startRow = (page - 1) * perPage;//0부터시작하기 때문에 1뺌
							String userid="1";
							 
							  List<BuyDto> rbuyList = service.rbuyList(userid); 
							  m.addAttribute("rbuyList",rbuyList);
							  List<SellDto> sellList = service.sellList(userid); 
							  m.addAttribute("sellList",sellList);
							  
//							  List<RevenueDto> boardList = service.boardList(startRow);
//							  
//							m.addAttribute("bList", boardList);
						
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
							
							}
						
							m.addAttribute("count", count);
							
							return "/company/total";
						}
						/*
						 * @RequestMapping("/company/total") public String selectpname(int pno) { return
						 * dao.selectpname(pno);
						 * 
						 * }
						 */
}
