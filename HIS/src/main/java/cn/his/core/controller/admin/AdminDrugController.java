package cn.his.core.controller.admin;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import cn.his.common.page.Pagination;
import cn.his.common.web.ResponseUtils;
import cn.his.core.model.drug.Drug;
import cn.his.core.service.drug.DrugService;

@Controller
public class AdminDrugController {

	@Autowired
	private DrugService drugService;
	
	@RequestMapping(value = "/admin/durglist.do")
	public String druglist(String name, Integer pageNo, ModelMap model) {
		Drug drug = new Drug();
		drug.setName(name);
		StringBuilder params = new StringBuilder();
		if (StringUtils.isNotBlank(name)) {
			drug.setName(name);
			params.append("name=").append(name);
		}
		drug.setPageNo(Pagination.cpn(pageNo));
		drug.setPageSize(7);
		Pagination pagination = drugService.findDrugList(drug);
		String url = "/HIS/admin/durglist.do";
		pagination.pageView(url, params.toString());
		model.addAttribute("pagination", pagination);
		model.addAttribute("pageNo", Pagination.cpn(pageNo));
		return "drugs";
	}
	
	@RequestMapping(value = "/admin/drug.do")
	public void drug(String code, HttpServletResponse response) {
		Drug drug = drugService.findDrugByCode(code);
		JSONObject jsonObject = new JSONObject();
		String jsonString = jsonObject.toJSONString(drug);
		ResponseUtils.renderJson(response, jsonString);
	}
	
	@RequestMapping(value = "/admin/addDurg.do")
	public String addDrug(Drug drug) {
		drugService.insertDrug(drug);
		return "redirect:/admin/durglist.do";
	}
}
