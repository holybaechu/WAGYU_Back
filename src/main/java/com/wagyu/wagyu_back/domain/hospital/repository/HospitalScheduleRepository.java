package com.wagyu.wagyu_back.domain.hospital.repository;

import com.wagyu.wagyu_back.domain.hospital.entity.HospitalSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HospitalScheduleRepository extends JpaRepository<HospitalSchedule, Long> {
    Optional<HospitalSchedule> findByHospitalIdAndDayOffWeek(Long hospitalId, Short dayOffWeek);
}
