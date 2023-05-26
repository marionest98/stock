package stock_m.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stock_m.dao.BroadcastDao;

@Service
public class BroadcastService {

	@Autowired
	BroadcastDao Broadcast_dao;

	public List<String> broadPriceCheck(int pno, int param) {
		List<String> userList = Broadcast_dao.broadPriceCheck(pno, param);
		return userList;
	}

	public int broadStock(int sno, String userid) {

		int useridTF = Broadcast_dao.broadStock(sno,userid);
		System.out.println("this is useridTF : "+useridTF);
		System.out.println("this is sno : "+sno);
		if (useridTF == 1) {
			System.out.println("/////////+++++++++++++++++++++"+sno);
			return sno;
		}else{
			System.out.println("/////////-------------------------"+sno);
			return 0;
		}

	}
	
	public void stockMessage(String userid,String content) {
		Broadcast_dao.insertMessage(userid,content);
	}
	
	public int countMsg(String userid){
		return Broadcast_dao.countMsg(userid);
	}
	
	
}
