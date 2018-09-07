package cn.his.core.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.his.core.model.Cost;
import cn.his.core.service.CostService;

/**
 * 后台收费模块
 * @author chenruiying
 *
 */
@Controller
public class AdminCostController {
	
	@Autowired
	private CostService costService;

	/**
	 * 收费列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/costList.do")
	public String costList(ModelMap model) {
		List<Cost> list = costService.findCostList(new Cost());
		model.addAttribute("list", list);
		return "cost";
	}
}
