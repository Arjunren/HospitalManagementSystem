package com.arjunren.hospital.repository;
import com.arjunren.hospital.entity.PatientProfile;import java.util.Optional;import org.springframework.data.domain.*;import org.springframework.data.jpa.repository.JpaRepository;
public interface PatientRepository extends JpaRepository<PatientProfile,Long>{Optional<PatientProfile>findByUserId(Long id);boolean existsByMedicalRecordNumberIgnoreCase(String medicalRecordNumber);Page<PatientProfile>findByMedicalRecordNumberContainingIgnoreCase(String q,Pageable p);}
