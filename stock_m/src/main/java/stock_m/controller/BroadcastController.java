package stock_m.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import stock_m.dto.BroadcastLimitDto;
import stock_m.dto.BroadcastPriceDto;
import stock_m.dto.ProductDto;
import stock_m.dto.RevenueDto;
import stock_m.dto.UserDto;
import stock_m.service.BroadcastService;

//@SessionAttributes("user")
@Controller
public class BroadcastController {
	
	@Autowired
	BroadcastService service;

	/*
	 * @ModelAttribute("user") public BroadcastLimitDto getDto() {//session에
	 * 저장할객체model에추가해주기 return new BroadcastLimitDto(); }
	 * 
	 */
	// 한도 알림창
	/*
	 * @GetMapping("/company/limitinsertform") public String insertForm() { return
	 * "/company/limitinsertform"; }
	 * 
	 * @PostMapping("/company/limitinsertform") public String
	 * insert(BroadcastLimitDto dto) { service.insert(dto); return
	 * "redirect:test";// 글목록 }
	 */
	/*
	 * @GetMapping("/company/limitupdateform/{userid}") public String
	 * updateForm(@PathVariable String userid, Model m) { BroadcastLimitDto dto =
	 * service.boardOne(userid); m.addAttribute("dto", dto); return
	 * "/company/limitbroadcastform"; }
	 */
	
	/*
	 * @PutMapping("/company/limitupdate") public String
	 * updateBoardcastlimit(BroadcastLimitDto dto) {
	 * service.updateBoardcastlimit(dto); return "/limitbroadcastform"; }
	 * 
	 * // limitinsertform.jsp
	 * 
	 * @RequestMapping("/company/limitalert") public String limitalert(String alert,
	 * String userid, Model m) { int broadcastlimit =
	 * service.broadcastlimit(userid); int revenuelimit =
	 * service.revenuelimit(userid);
	 * 
	 * if (broadcastlimit == revenuelimit) { int limitalert=0;//알림 번호 부여
	 * limitalert=+1; alert = "한도에 도달했습니다."; m.addAttribute("alert", alert); }
	 * 
	 * alert = "x"; m.addAttribute("alert", alert); return "/company/limitalert"; }
	 */
	  
	  // 가격알림
	  
	  @GetMapping("/company/priceinsert") 
	  public String priceinsertForm() {
		  
	  return"/company/priceinsert"; }
	  
	  @PostMapping("/company/priceinsert") 
	  public String priceinsert(String userid,int br_search,int br_param) { 
		//  System.out.println(dto.getUserid());
		  service.priceinsert(userid,br_search,br_param); 
	  return "redirect:/"; 
	  // 글목록 
	  }
	  
	  @GetMapping("/company/priceupdate/{userid}") 
	  public String priceupdateForm(@PathVariable String userid, Model m) { 
		  BroadcastPriceDto dto=service.priceselect(userid); 
		  m.addAttribute("dto", dto); 
		  return "/company/priceupdate"; }
	  
	  @PutMapping("/company/priceupdate") 
	  public String priceupdate(BroadcastPriceDto dto) { 
		  service.priceupdate(dto);
	      return "/company/priceupdate"; }
	  
	  // limitinsertform.jsp
	  
		
	  
	
	  @RequestMapping("/company/alert") 
		  public String pricealert(String alert,String userid,Model m){
			  
			  int brsearch= service.brsearch(userid);
			  int brparam =service.brparam(userid); 
			  int pno = service.pno(userid);
			  int price = service.price(userid);
		  //
			  m.addAttribute("brsearch",brsearch);
			  m.addAttribute("brparam",brparam);
			  m.addAttribute("pno",pno);
			  m.addAttribute("price",price);
				/*
				 * if(brsearch==brparam&&pno==price) { int price_alertcount=0;
				 * price_alertcount=+1; alert="가격에 맞는 상품이 입고 되었습니다";
				 * m.addAttribute("alert",alert);
				 * m.addAttribute("price_alertcount",price_alertcount); } else { alert="x";
				 * m.addAttribute("alert",alert);}
				 */
		  return "/company/alert"; }
		  
		 
	  @RequestMapping(value = "message.do")
	  public void message(HttpServletRequest request, HttpServletResponse response,String alert,String userid,Model m) {
		  int brsearch= service.brsearch(userid);
		  int brparam =service.brparam(userid); 
		  int pno = service.pno(userid);
		  int price = service.price(userid);
		  
		  if(brsearch==brparam&&pno==price) { 
	      String clientMessage = request.getParameter("message");
	      try{
	          response.setCharacterEncoding("UTF-8");
	          response.getWriter().print("클라이언트의 메시지 : " + clientMessage);
	      }catch(Exception e){
	          e.printStackTrace();
	      }
	     }
	  }

	
	
	/*
	 * @DeleteMapping("/delete")
	 * 
	 * @ResponseBody public String delete(int pno) { int i =
	 * service.deleteBoard(pno); //안보내주면 에러나서 아무값이나 return 했음 return ""+i; }
	 */
}
