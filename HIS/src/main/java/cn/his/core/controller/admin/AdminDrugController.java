package cn.his.core.controller.admin;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;

import cn.his.common.page.Pagination;
import cn.his.common.web.ResponseUtils;
import cn.his.core.model.drug.Drug;
import cn.his.core.service.drug.DrugService;

/**
 * 后台药品模块
 * @author chenruiying
 *
 */
@Controller
public class AdminDrugController {

	@Autowired
	private DrugService drugService;
	
	/**
	 * 药品列表
	 * @param name
	 * @param pageNo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/druglist.do")
	public String druglist(String name, Integer pageNo, String msg, ModelMap model) {
		Drug drug = new Drug();
		StringBuilder params = new StringBuilder();
		if (StringUtils.isNotBlank(name)) {
			drug.setName(name);
			params.append("name=").append(name);
		}
		drug.setPageNo(Pagination.cpn(pageNo));
		drug.setPageSize(7);
		Pagination pagination = drugService.findDrugList(drug);
		String url = "/HIS/admin/druglist.do";
		pagination.pageView(url, params.toString());
		model.addAttribute("pagination", pagination);
		model.addAttribute("pageNo", Pagination.cpn(pageNo));
		model.addAttribute("name", name);
		model.addAttribute("msg", msg);
		return "drugs";
	}
	
	/**
	 * 药品详细信息
	 * @param code
	 * @param response
	 */
	@RequestMapping(value = "/admin/drug.do", method = RequestMethod.POST)
	public void drug(String code, HttpServletResponse response) {
		Drug drug = drugService.findDrugByCode(code);
		JSONObject jsonObject = new JSONObject();
		@SuppressWarnings("static-access")
		String jsonString = jsonObject.toJSONString(drug);
		ResponseUtils.renderJson(response, jsonString);
	}
	
	/**
	 * 添加药品
	 * @param drug
	 * @return
	 */
	@RequestMapping(value = "/admin/addDurg.do", method = RequestMethod.POST)
	public String addDrug(Drug drug, ModelMap model) {
		if (drug.getEffective_date() == "" || drug.getFuncction() == "" || drug.getManufacturer() == "" || drug.getName() == "" ||
				drug.getProduce_date() == "" || drug.getSale_price() ==  0 || drug.getPurchase_price() == 0 || drug.getUnit() == "" ||
				drug.getSpec() == "") {
			model.addAttribute("msg", "请填写完整表单");
		} else {
			drugService.insertDrug(drug);
			
		}
		return "redirect:/admin/druglist.do";
	}
	
	/**
	 * 更新药品信息
	 * @param drug
	 * @return
	 */
	@RequestMapping(value = "/admin/updateDrug.do")
	public String updateDrug(Drug drug, ModelMap model) {
		if (drug.getName() == "" || drug.getFuncction() == "" || drug.getManufacturer() == "" || drug.getPurchase_price() == 0 ||
				drug.getSale_price() == 0) {
			model.addAttribute("msg", "请填写完整表单");
		} else {
			drugService.updateDrug(drug);
		}
		return "redirect:/admin/druglist.do";
	}
	
	/**
	 * 删除药品
	 * @param code
	 * @return
	 */
	@RequestMapping(value = "/admin/deleteDrug.do")
	public String deleteDrug(String code) {
		drugService.deleteDrug(code);
		return "redirect:/admin/druglist.do";
	}
}
