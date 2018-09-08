package cn.his.core.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.his.core.model.Ward;
import cn.his.core.service.WardService;

@Controller
public class AdminWardController {

	@Autowired
	private WardService wardService;
	
	/**
	 * 病房列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/ward.do")
	public String wardList(ModelMap model) {
		List<Ward> wards = wardService.selectWardList();
		model.addAttribute("wards", wards);
		return "ward";
	}
	
	/**
	 * 修改病房信息
	 * @param ward
	 * @return
	 */
	@RequestMapping(value = "/admin/updateWard.do", method = RequestMethod.POST)
	public String updateWard(Ward ward, String oldWard_code) {
		if (ward.getWard_code() != null) {
			wardService.updateWardByWard_code(ward, oldWard_code);
		} else {
			wardService.updateWardById(ward);
		}
		return "redirect:/admin/ward.do";
	}
	
	/**
	 * 新增病房
	 * @param ward
	 * @return
	 */
	@RequestMapping(value = "/admin/addWard.do", method = RequestMethod.POST)
	public String addWard(Ward ward) {
		wardService.insertWard(ward);
		return "redirect:/admin/ward.do";
	}
	
	/**
	 * 删除病房
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/deleteWard.do")
	public String deleteWard(int id, ModelMap model) {
		Ward ward = wardService.selectWardByID(id);
		if (ward.getBed_code() == null) {
			int num = wardService.getBedCountByWard_code(ward.getWard_code());
			if (num > 0) {
				model.addAttribute("msg", "该病房还存在病床，不能删除");
			} else {
				wardService.deleteWard(id);
			}	
		}
		return "redirect:/admin/ward.do";
	}
}
