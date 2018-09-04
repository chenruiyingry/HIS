package cn.his.core.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.his.core.model.drug.Drug;
import cn.his.core.service.drug.DrugService;

@Controller
public class AdminDrugController {

	@Autowired
	private DrugService drugService;
	
	@RequestMapping(value = "/admin/durglist.do")
	public String druglist() {
		Drug drug = new Drug();
		
		drugService.findDrugList(drug);
		return "drugs";
	}
}
