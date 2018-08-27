import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.his.core.model.Sex;
import cn.his.core.model.patient.Patient;
import cn.his.core.service.patient.PatientService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestPatientService {

	@Autowired
	private PatientService patientService;
	
	@Test
	public void TestInsertPatient() throws Exception {
		Patient patient= new Patient();
		patient.setAge(18);
		patient.setAllergy("没毛病");
		patient.setCode("10012");
		patient.setDoctor_code("326525");
		patient.setInsurance_type("社保类型");
		patient.setName("张晓松");
		patient.setPast_illness("过敏");
		patient.setPhone("13152526252");
		patient.setPresent_illness("感冒");
		patient.setSex(Sex.WOMAN);
		patient.setStatus(1);
		System.out.println(patient.toString());
		patientService.insertPatient(patient);
		System.out.println("添加成功");
	}
	
	@Test
	public void TestFindPatientList() {
		Patient patient= new Patient();
		patient.setDoctor_code("326525");
		System.out.println(patientService.findPatientList(patient));
	}
	
	@Test
	public void TestFindPatientByCode() {
		Patient patient = patientService.findPatientByCode("10011");
		System.out.println(patient);
	}
	
	@Test
	public void deletePatientByCode() {
		patientService.deletePatient("10010");
		System.out.println("删除成功！");
	}
	
	@Test
	public void updatePatient() {
		Patient patient= patientService.findPatientByCode("10011");
		System.out.println(patient.toString());
		patient.setAge(20);
		patient.setAllergy("神经病");
		patient.setInsurance_type("城镇保");
		patient.setName("刘欢");
		patient.setPast_illness("发骚");
		patient.setPhone("13123236252");
		patient.setPresent_illness("头疼");
		patient.setSex(Sex.WOMAN);
		patient.setStatus(2);
		System.out.println(patient.toString());
		patientService.updatePatient(patient);
		System.out.println("修改成功");
	}
}
