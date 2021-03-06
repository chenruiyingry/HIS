package cn.his.core.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alipay.demo.trade.config.Configs;
import com.alipay.demo.trade.model.GoodsDetail;
import com.alipay.demo.trade.model.builder.AlipayTradePayRequestBuilder;
import com.alipay.demo.trade.model.result.AlipayF2FPayResult;
import com.alipay.demo.trade.service.AlipayTradeService;
import com.alipay.demo.trade.service.impl.AlipayTradeServiceImpl;

import cn.his.common.web.ResponseUtils;
import cn.his.common.web.SessionProvider;
import cn.his.core.model.Cost;
import cn.his.core.model.Ward;
import cn.his.core.model.doctor.Department;
import cn.his.core.model.doctor.Doctor;
import cn.his.core.model.drug.Drug;
import cn.his.core.model.drug.Drug_record;
import cn.his.core.model.patient.Medical_record;
import cn.his.core.model.patient.Patient;
import cn.his.core.service.CostService;
import cn.his.core.service.Register_costService;
import cn.his.core.service.WardService;
import cn.his.core.service.doctor.DepartmentService;
import cn.his.core.service.doctor.DoctorService;
import cn.his.core.service.drug.Drug_recordService;
import cn.his.core.service.patient.Medical_recordService;
import cn.his.core.service.patient.PatientService;

/**
 * 前台收费模块
 * @author chenruiying
 *
 */
@Controller
public class CostController {
	
	@Autowired
	private PatientService patientService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private Medical_recordService medical_recordService;
	@Autowired
	private Drug_recordService drug_recordService;
	@Autowired
	private CostService costService;
	@Autowired
	private Register_costService register_costService;
	@Autowired
	private WardService wardService;
	@Autowired
	private SessionProvider sessionProvider;

	private static AlipayTradeService tradeService;
	static {
		Configs.init("properties/zfbinfo.properties");
		tradeService = new AlipayTradeServiceImpl.ClientBuilder().build();
	}
	
	/**
	 * 去填写病人编号页面
	 * @return
	 */
	@RequestMapping(value = "toFee.action")
	public String toFee(HttpServletRequest request, HttpServletResponse response, ModelMap model)  {
		Doctor doctor = (Doctor) sessionProvider.getAttribute(request, response, "doctorsession");
		if ("CASHIER".equals(doctor.getDuty())) {
			return "tofee";
		} else {
			model.addAttribute("title", "操作失败");
			model.addAttribute("msg", "权限不足，请重试！");
			model.addAttribute("status", "error");
			return "index_s";
		}
	}
	
	/**
	 * 去收费页面
	 * @return
	 */
	@RequestMapping(value = "fee.action")
	public String fee(String code, ModelMap model) {
		try {
			Patient patient = patientService.findPatientByCode(code);
			if (patient == null) {
				model.addAttribute("title", "操作失败");
				model.addAttribute("msg", "查无此人，请核对卡号！");
				model.addAttribute("status", "error");
				model.addAttribute("code", code);
				return "tofee";
			} else {
				String outTradeNo = "HIS_PAY" + System.currentTimeMillis() + (long) (Math.random() * 10000000L);
				Medical_record medical_record = new Medical_record();
				medical_record.setPatient_code(code);
				List<Medical_record> medical_records = medical_recordService.findMedical_records(medical_record);
				medical_record = medical_records.get(medical_records.size() - 1);
				Doctor doctor = doctorService.findDoctorByCode(medical_record.getDoctor_code());
				Department department = departmentService.findDepartmentByCode(doctor.getDepartment_code());
				HashMap<String, Double> others = new HashMap<String, Double>();
				double totalfee = 0.00;
				int totalnum = 0;
				if (medical_record.getDrug_record() != null) {
					for (Drug_record drug_record2 : medical_record.getDrug_record()) {
						totalnum += 1;
						totalfee += drug_record2.getDrug().getSale_price();
					}
				}
				
				if (doctor != null) {
					double register_cost = register_costService.findRegister_costByLevel(doctor.getLevel()).getCost();
					others.put("挂号费", register_cost);
					totalfee += register_cost;
					totalnum += 1;
				}
				if (medical_record.isAssay()) {
					others.put("化验费", 100.00);
					totalfee += 100;
					totalnum += 1;
				}
				if (medical_record.isExamination()) {
					others.put("检查费", 50.00);
					totalfee += 50;
					totalnum += 1;
				}
				if (medical_record.isHospitalization()) {
					int hospitaldays = medical_record.getHospitalization_days();
					Ward ward = new Ward();
					ward.setBed_code(medical_record.getBed_number());
					ward.setWard_code(medical_record.getWard_number());
					double price = wardService.findWardByBed_codeAndWard_code(ward).getPrice();
					others.put("住院费", hospitaldays * price);
					totalfee += hospitaldays * price;
					totalnum += 1;
				}
				model.addAttribute("patient", patient);
				model.addAttribute("doctor", doctor);
				model.addAttribute("department", department);
				model.addAttribute("druglist", medical_record.getDrug_record());
				model.addAttribute("others", others);
				model.addAttribute("totalfee", totalfee);
				model.addAttribute("totalnum", totalnum);
				model.addAttribute("tradeNo", outTradeNo);
				model.addAttribute("medical_record", medical_record);
				return "fee_s";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("title", "操作失败");
			model.addAttribute("msg", "操作出现异常，请重试！");
			model.addAttribute("status", "error");
			model.addAttribute("code", code);
			return "tofee";
		}
	}
	
	/**
	 * 收款
	 * @param level
	 * @param bed_number
	 * @param hospitalization_days
	 * @param medicalcode
	 * @param patientcode
	 * @param tradeNo
	 * @param pay
	 * @param codes
	 * @param others
	 * @param authcode
	 * @param totalnum
	 * @param department
	 * @param doctorcode
	 * @param totalfee
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "pay.action", method = RequestMethod.POST)
	public String pay(String level, String bed_number, String ward_number, Integer hospitalization_days, String medicalcode, String patientcode, String tradeNo, String pay, String[] codes, String[] others, String authcode, Integer totalnum, String department, String doctorcode, double totalfee, ModelMap model) {
		try {
			Cost cost = new Cost();
			List<Cost> list = costService.findCostList(cost);
			String costcode = list.get(list.size() - 1).getCode();
			int cost_new = Integer.parseInt(costcode) + 1;
			cost.setCode(String.valueOf(cost_new));
			cost.setTotal(totalfee);
			cost.setFlow_number(tradeNo);
			cost.setMedical_code(medicalcode);
			//药费
			double drug_cost = 0;
			for (int i = 0; i < codes.length; i++) {
				Drug drug = drug_recordService.findDrug_recordByCode(codes[i]).getDrug();
				drug_cost += drug.getSale_price();
			}
			for (int i = 0; i < others.length; i++) {
				if ("检查费".equals(others[i])) {
					cost.setExamination_cost(50);
				}
				if ("化验费".equals(others[i])) {
					cost.setAssay_cost(100);
				}
				if ("挂号费".equals(others[i])) {
					double register_cost = register_costService.findRegister_costByLevel(level).getCost();
					cost.setRegister_cost(register_cost);
				}
				if ("住院费".equals(others[i])) {
					Ward ward = new Ward();
					ward.setBed_code(bed_number);
					ward.setWard_code(ward_number);
					double price = wardService.findWardByBed_codeAndWard_code(ward).getPrice();
					cost.setHospitalization_cost(price * hospitalization_days);
				}
			}
			cost.setDrug_cost(drug_cost);
			//支付宝支付
			if ("alipay".equals(pay)) {
				String subject = patientService.findPatientByCode(patientcode).getName() + department + "医院消费";
				String body = "共" + totalnum + "项，共" + totalfee + "元";
				String storeId = "16210120";
				String timeoutExpress = "5m";
				//商品
				List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();
				for (int i = 0; i < codes.length; i++) {
					Drug_record drug_record = drug_recordService.findDrug_recordByCode(codes[i]);
					Drug drug = drug_record.getDrug();
					GoodsDetail goodsDetail = GoodsDetail.newInstance(drug.getCode(), drug.getName(), Math.round(drug.getSale_price()), drug_record.getNumber());
					goodsDetailList.add(goodsDetail);
				}
				for (int i = 0; i < others.length; i++) {
					if ("检查费".equals(others[i])) {
						GoodsDetail goodsDetail = GoodsDetail.newInstance("101", "检查费", 50, 1);
						goodsDetailList.add(goodsDetail);
					}
					if ("化验费".equals(others[i])) {
						GoodsDetail goodsDetail = GoodsDetail.newInstance("102", "化验费", 100, 1);
						goodsDetailList.add(goodsDetail);
					}
					if ("挂号费".equals(others[i])) {
						double register_cost = register_costService.findRegister_costByLevel(level).getCost();
						GoodsDetail goodsDetail = GoodsDetail.newInstance("103", "挂号费", Math.round(register_cost), 1);
						goodsDetailList.add(goodsDetail);
					}
					if ("住院费".equals(others[i])) {
						Ward ward = new Ward();
						ward.setBed_code(bed_number);
						ward.setWard_code(ward_number);
						double price = wardService.findWardByBed_codeAndWard_code(ward).getPrice();
						GoodsDetail goodsDetail = GoodsDetail.newInstance("104", "住院费", Math.round(price * hospitalization_days), 1);
						goodsDetailList.add(goodsDetail);
					}
				}
				// 创建条码支付请求builder，设置请求参数
				AlipayTradePayRequestBuilder builder = new AlipayTradePayRequestBuilder()
			            .setOutTradeNo(tradeNo).setSubject(subject).setAuthCode(authcode)
			            .setTotalAmount(String.valueOf(totalfee)).setStoreId(storeId)
			            .setBody(body).setOperatorId(doctorcode)
			            .setGoodsDetailList(goodsDetailList).setTimeoutExpress(timeoutExpress);
				// 调用tradePay方法获取当面付应答
				AlipayF2FPayResult result = tradeService.tradePay(builder);
				cost.setPayment("ALIPAY");
			    switch (result.getTradeStatus()) {
			        case SUCCESS:
			        	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        	cost.setDate(dateFormat.format(new Date()));
			        	for (int i = 0; i < codes.length; i++) {
							Drug_record drug_record = drug_recordService.findDrug_recordByCode(codes[i]);
							drug_record.setStatus(0);
							drug_recordService.updateDrug_record(drug_record);
						}
			        	if (costService.insertCost(cost)) {
			    	    	model.addAttribute("title", "操作成功");
							model.addAttribute("msg", "支付宝收款成功，正在打印明细单..！");
							model.addAttribute("status", "success");
						} else {
							model.addAttribute("title", "操作失败");
							model.addAttribute("msg", "系统异常，请稍后再试！");
							model.addAttribute("status", "error");
						}
			        	return "tofee";
			        case FAILED:
				    	model.addAttribute("title", "操作失败");
						model.addAttribute("msg", "支付宝收款失败，请重新尝试！");
						model.addAttribute("status", "error");
				    	return "tofee";
			        case UNKNOWN:
				    	model.addAttribute("title", "操作失败");
						model.addAttribute("msg", "系统异常，请稍后再试！");
						model.addAttribute("status", "error");
				    	return "tofee";
			        default:
				    	model.addAttribute("title", "操作失败");
						model.addAttribute("msg", "不支持的交易状态，交易返回异常！");
						model.addAttribute("status", "error");
				    	return "tofee";
			    }
			}
			//微信支付
			else if ("wxpay".equals(pay)) {
				cost.setPayment("WECHAT");
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				cost.setDate(dateFormat.format(new Date()));
				for (int i = 0; i < codes.length; i++) {
					Drug_record drug_record = drug_recordService.findDrug_recordByCode(codes[i]);
					drug_record.setStatus(0);
					drug_recordService.updateDrug_record(drug_record);
				}
				if (costService.insertCost(cost)) {
					model.addAttribute("title", "操作成功");
					model.addAttribute("msg", "微信收款成功！");
					model.addAttribute("status", "success");
				} else {
					model.addAttribute("title", "操作失败");
					model.addAttribute("msg", "状态异常，请联系技术人员！");
					model.addAttribute("status", "error");
				}
				return "tofee";
			}
			//银行卡支付
			else if ("unionpay".equals(pay)) {
				cost.setPayment("CARD");
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				cost.setDate(dateFormat.format(new Date()));
				for (int i = 0; i < codes.length; i++) {
					Drug_record drug_record = drug_recordService.findDrug_recordByCode(codes[i]);
					drug_record.setStatus(0);
					drug_recordService.updateDrug_record(drug_record);
				}
				if (costService.insertCost(cost)) {
					model.addAttribute("title", "操作成功");
					model.addAttribute("msg", "银联收款成功！");
					model.addAttribute("status", "success");
				} else {
					model.addAttribute("title", "操作失败");
					model.addAttribute("msg", "状态异常，请联系技术人员！");
					model.addAttribute("status", "error");
				}
				return "tofee";
			}
			//现金支付
			else {
				cost.setPayment("CASH");
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				cost.setDate(dateFormat.format(new Date()));
				for (int i = 0; i < codes.length; i++) {
					Drug_record drug_record = drug_recordService.findDrug_recordByCode(codes[i]);
					drug_record.setStatus(0);
					drug_recordService.updateDrug_record(drug_record);
				}
				if (costService.insertCost(cost)) {
					model.addAttribute("title", "操作成功");
					model.addAttribute("msg", "现金收款成功！");
					model.addAttribute("status", "success");
				} else {
			    	model.addAttribute("title", "操作失败");
					model.addAttribute("msg", "状态异常，请联系技术人员！");
					model.addAttribute("status", "error");
				}
				return "tofee";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("title", "操作失败");
			model.addAttribute("msg", "状态异常，请重新尝试！");
			model.addAttribute("status", "error");
			return "tofee";
		}
	}
	
	/**
	 * 交班
	 * @param total
	 * @param request
	 * @param response
	 * @param model
	 * @throws ParseException
	 */
	@RequestMapping(value = "/balance.action")
	public void balance(Double total, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long starttime = sessionProvider.getSessionTime(request, response);
		long endtime = new Date().getTime();
		Cost cost = new Cost();
		cost.setPayment("CASH");
		List<Cost> costs = costService.findCostList(cost);
		if (costs.size() > 0) {
			for (Cost cost2 : costs) {
				if (dateFormat.parse(cost2.getDate()).getTime() >= starttime && dateFormat.parse(cost2.getDate()).getTime() <= endtime) {
					total += cost2.getTotal();
				}
			}
		}
		ResponseUtils.renderText(response, Double.toString(total));
	}
}
