package stock_m.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import stock_m.dto.AdminstockDto;
import stock_m.dto.BroadcastPriceDto;
import stock_m.dto.NameAndPrice_sabDto;
import stock_m.service.BroadcastService;
import stock_m.service.MarketService;
import stock_m.service.SabService;
import stock_m.service.StockService;

@Controller

public class SabController {

	@Autowired
	SabService sab_service;

	@Autowired
	StockService stock_service;

	@Autowired
	BroadcastService broad_service;
	
	@Autowired
	MarketService market_service;

	@GetMapping("event2")
	public String event() {
		return "test";
	}

	@GetMapping("company/main")
	public String companyindex(Model m, HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		List<AdminstockDto> adminstockList = stock_service.option();
		m.addAttribute("adminstockList", adminstockList);
		List<NameAndPrice_sabDto> npList = sab_service.namePrice(userid);
		m.addAttribute("npList", npList);
		m.addAttribute("uid", userid);
		return "company/index";
	}

	
	@GetMapping("normal/main")
	public String normalindex() {
		return "/normal/marketform";
	}
	
	/*
	 * @GetMapping("/company/buy") public String buyForm(Model model) {
	 * 
	 * URI uri = UriComponentsBuilder .fromUriString("http://www.kobis.or.kr")
	 * .path(
	 * "/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
	 * .queryParam("key","f5eef3421c602c6cb7ea224104795888")
	 * .queryParam("targetDt","20230418") .encode() .build() .toUri();
	 * 
	 * MovieList list =restTemplate.getForObject(uri, MovieList.class);
	 * model.addAttribute("boxOfficeList", list); return "movie/boxOffice";
	 * 
	 * 
	 * return "company/buy"; }
	 */
	
	@GetMapping("/company/{sno}")
	@ResponseBody // view없이 바로 보냄
	public int snoCount(Model m, @PathVariable int sno) {
		int count = sab_service.selecCount(sno);
		return count;
	}

	@GetMapping("/company/Vol/{sno}/{p_count}")
	@ResponseBody // view없이 바로 보냄
	public int snoSearch(Model m, @PathVariable int sno, @PathVariable int p_count) {
		int Vol = sab_service.selecVol(sno);
		if((sno-p_count)<=0) {
			return 0;
		}
		else {
			return Vol;
		}
		
	}

	@GetMapping("/company/buy")
	public String buy(Model model, HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		List<AdminstockDto> adminstockList = stock_service.option();
		List<Map<String,Object>> companybuyList = sab_service.companybuy(userid);
		model.addAttribute("userid", userid);
		model.addAttribute("adminstockList", adminstockList);
		model.addAttribute("companybuyList", companybuyList);
		return "company/buy";
	}

	@GetMapping("/company/sell")
	public String sellForm(Model m, HttpSession session) {
		String userid = (String) session.getAttribute("userid");
		List<NameAndPrice_sabDto> npList = sab_service.namePrice(userid);
		List<Map<String,Object>> companyproductList = sab_service.companyproduct(userid);
		m.addAttribute("npList", npList);
		m.addAttribute("uid", userid);
		m.addAttribute("companyproductList", companyproductList);
		return "company/sell";
	}

	@PostMapping("/company/sell")
	public String sellpost(int sno, String pname, int price, int p_count,HttpServletRequest request) {

		sab_service.updateAndInsert(sno, pname, price, p_count);
		String url = request.getHeader("Referer");
		return "redirect:" + url;
	}

	@GetMapping("/broadprice")
	@ResponseBody
	public String broadprice(int sno) {

		String bno = String.valueOf(sab_service.broadprice(sno));

		return bno;
	}

	@GetMapping("/broadCprice")
	@ResponseBody
	public String broadCprice(Model m, int pno, int param) {
		List<String> userList = broad_service.broadPriceCheck(pno, param);
		Gson gson = new Gson();
		String ulist = gson.toJson(userList);
		return ulist;
	}

}
