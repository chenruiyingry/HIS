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
	public String wardList(ModelMap model, String msg) {
		List<Ward> wards = wardService.selectWardList();
		model.addAttribute("wards", wards);
		model.addAttribute("msg", msg);
		return "ward";
	}
	
	/**
	 * 修改病房信息
	 * @param ward
	 * @return
	 */
	@RequestMapping(value = "/admin/updateWard.do", method = RequestMethod.POST)
	public String updateWard(Ward ward, String oldWard_code, ModelMap model) {
		if (ward.getWard_code() == "") {
			model.addAttribute("msg", "请填写完整表单");
		} else {
			List<Ward> wards = wardService.selectWardList();
			boolean flag = false;
			for (Ward ward2 : wards) {
				if (ward2.getWard_code().equals(ward.getWard_code())) {
					model.addAttribute("msg", "不能使用相同的病房号！");
					flag = true;
					break;
				}
			}
			if (!flag) {
				wardService.updateWardByWard_code(ward, oldWard_code);
			}
		}
		return "redirect:/admin/ward.do";
	}
	
	/**
	 * 修改病床信息
	 * @param ward
	 * @return
	 */
	@RequestMapping(value = "/admin/updateBed.do", method = RequestMethod.POST)
	public String updateBed(Ward ward, ModelMap model) {
		if (ward.getBed_code() == "" || ward.getPrice() == 0) {
			model.addAttribute("msg", "请填写完整表单");
		} else {
			List<Ward> beds = wardService.selectBedListByWard_code(ward.getWard_code());
			boolean flag = false;
			for (Ward bed : beds) {
				if (ward.getBed_code().equals(bed.getBed_code())) {
					model.addAttribute("msg", "不能使用相同的病床号！");
					flag = true;
					break;
				}
			}
			if (!flag) {
				wardService.updateWardById(ward);
			}
		}
		return "redirect:/admin/ward.do";
	}
	
	/**
	 * 新增病房
	 * @param ward
	 * @return
	 */
	@RequestMapping(value = "/admin/addWard.do", method = RequestMethod.POST)
	public String addWard(Ward ward, ModelMap model) {
		if (ward.getWard_code() == "") {
			model.addAttribute("msg", "请填写完整表单");
		} else {
			List<Ward> wards = wardService.selectWardList();
			boolean flag = false;
			for (Ward ward2 : wards) {
				if (ward2.getWard_code().equals(ward.getWard_code())) {
					model.addAttribute("msg", "不能使用相同的病房号！");
					flag = true;
					break;
				}
			}
			if (!flag) {
				wardService.insertWard(ward);
			}
		}
		return "redirect:/admin/ward.do";
	}
	
	/**
	 * 新增病床
	 * @param ward
	 * @return
	 */
	@RequestMapping(value = "/admin/addBed.do", method = RequestMethod.POST)
	public String addBed(Ward ward, ModelMap model) {
		if (ward.getBed_code() == "" || ward.getPrice() == 0) {
			model.addAttribute("msg", "请填写完整表单");
		} else {
			List<Ward> beds = wardService.selectBedListByWard_code(ward.getWard_code());
			boolean flag = false;
			for (Ward bed : beds) {
				if (ward.getBed_code().equals(bed.getBed_code())) {
					model.addAttribute("msg", "不能使用相同的病床号！");
					flag = true;
					break;
				}
			}
			if (!flag) {
				wardService.insertWard(ward);
			}
		}
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
		int num = wardService.getBedCountByWard_code(ward.getWard_code());
		if (num > 0) {
			model.addAttribute("msg", "该病房还存在病床，不能删除");
		} else {
			wardService.deleteWard(id);
			
		}	
		return "redirect:/admin/ward.do";
	}
	
	/**
	 * 删除病床
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/deleteBed.do")
	public String deleteBed(int id, ModelMap model) {
		Ward ward = wardService.selectWardByID(id);
		if (ward.isOccupy()) {
			model.addAttribute("msg", "该病床正在使用，不能删除");
		} else {
			wardService.deleteWard(id);
		}
		return "redirect:/admin/ward.do";
	}
}
