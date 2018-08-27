package cn.his.core.service.doctor;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.his.common.page.Pagination;
import cn.his.core.dao.doctor.DoctorDao;
import cn.his.core.dao.patient.Medical_recordDao;
import cn.his.core.dao.patient.PatientDao;
import cn.his.core.model.doctor.Doctor;
import cn.his.core.model.patient.Medical_record;
import cn.his.core.model.patient.Patient;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {
	
	@Resource
	private DoctorDao doctorDao;
	
	@Resource
	private Medical_recordDao medical_recordDao;
	
	@Resource
	private PatientDao patientDao;

	@Override
	public boolean insertDoctor(Doctor doctor) {
		return doctorDao.insertDoctor(doctor);
	}

	@Transactional(readOnly = true)
	@Override
	public Doctor findDoctorByCode(String code) {
		Medical_record medical_record = new Medical_record();
		medical_record.setDoctor_code(code);
		List<Medical_record> medical_records = medical_recordDao.findMedical_recordList(medical_record);
		Patient patient = new Patient();
		patient.setDoctor_code(code);
		List<Patient> patients = patientDao.findPatientList(patient);
		Doctor doctor = doctorDao.findDoctorByCode(code);
		doctor.setMedical_record(medical_records);
		doctor.setPatient(patients);
		return doctor;
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		return doctorDao.updateDoctor(doctor);
	}
	
	@Override
	public boolean deleteDoctorByCode(String code) {
		return doctorDao.deleteDoctorByCode(code);
	}

	@Transactional(readOnly = true)
	@Override
	public Pagination findDoctorListWithPage(Doctor doctor) {
		Pagination pagination = new Pagination(doctor.getPageNo(), doctor.getPageSize(), doctorDao.getDoctorCount(doctor));
		List<Doctor> doctors = doctorDao.findDoctorListWithPage(doctor);
		Patient patient = new Patient();
		Medical_record medical_record = new Medical_record();
		for (Doctor doctor2 : doctors) {
			patient.setDoctor_code(doctor2.getCode());
			doctor2.setPatient(patientDao.findPatientList(patient));
			medical_record.setDoctor_code(doctor2.getCode());
			doctor2.setMedical_record(medical_recordDao.findMedical_recordList(medical_record));	
		}
		pagination.setList(doctors);
		return pagination;
	}

}
