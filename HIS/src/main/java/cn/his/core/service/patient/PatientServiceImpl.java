package cn.his.core.service.patient;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.his.core.dao.patient.Medical_recordDao;
import cn.his.core.dao.patient.PatientDao;
import cn.his.core.model.patient.Medical_record;
import cn.his.core.model.patient.Patient;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
	
	@Resource
	private PatientDao patientDao;
	
	@Resource
	private Medical_recordDao medical_recordDao;
	
	@Transactional(readOnly = true)
	@Override
	public Patient findMedical_recordByCode(Medical_record medical_record) {
		Patient patient = patientDao.findMedical_recordByCode(medical_record);
		medical_record.setPatient_code(patient.getCode());
		List<Medical_record> medical_records = medical_recordDao.findMedical_recordList(medical_record);
		patient.setMedical_record(medical_records);
		return patient;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Patient> findPatientList(Patient patient) {
		List<Patient> patients = patientDao.findPatientList(patient);
		Medical_record medical_record = new Medical_record();
		for (Patient patient2 : patients) {
			medical_record.setPatient_code(patient2.getCode());
			List<Medical_record> medical_records = medical_recordDao.findMedical_recordList(medical_record);
			if (medical_records.size() > 0) {
				patient2.setMedical_record(medical_records);
			}
		}
		return patients;
	}

	@Transactional(readOnly = true)
	@Override
	public int getPatientCount(String code) {
		return patientDao.getPatientCount(code);
	}

	@Transactional(readOnly = true)
	@Override
	public Patient findPatientByCode(String code) {
		Patient patient = patientDao.findPatientByCode(code);
		Medical_record medical_record = new Medical_record();
		medical_record.setPatient_code(code);
		List<Medical_record> medical_records = medical_recordDao.findMedical_recordList(medical_record);
		patient.setMedical_record(medical_records);
		return patient;
	}

	@Override
	public boolean insertPatient(Patient patient) {
		return patientDao.insertPatient(patient);
	}

	@Override
	public boolean updatePatient(Patient patient) {
		return patientDao.updatePatient(patient);
	}

	@Override
	public boolean deletePatient(String code) {
		return patientDao.deletePatient(code);
	}

}