package com.wagyu.wagyu_back.domain.hospital.service;

import com.wagyu.wagyu_back.domain.hospital.dto.HospitalSummaryResponse;
import com.wagyu.wagyu_back.domain.hospital.entity.Hospital;
import com.wagyu.wagyu_back.domain.hospital.entity.HospitalSchedule;
import com.wagyu.wagyu_back.domain.hospital.entity.HospitalScheduleException;
import com.wagyu.wagyu_back.domain.hospital.repository.HospitalRepository;
import com.wagyu.wagyu_back.domain.hospital.repository.HospitalScheduleExceptionRepository;
import com.wagyu.wagyu_back.domain.hospital.repository.HospitalScheduleRepository;
import com.wagyu.wagyu_back.global.exception.CustomException;
import com.wagyu.wagyu_back.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    private final HospitalScheduleRepository hospitalScheduleRepository;
    private final HospitalScheduleExceptionRepository hospitalScheduleExceptionRepository;

    public Page<HospitalSummaryResponse> getAllHospitals(Pageable pageable) {
        List<Hospital> hospitals = hospitalRepository.findAll(pageable);
        List<HospitalSummaryResponse> hospitalSummaryResponses = hospitals.stream().map(hospital -> {

            Optional<HospitalScheduleException> optExSchedule = hospitalScheduleExceptionRepository
                    .findByHospitalIdAndDate(hospital.getId(), LocalDate.now());
            if (optExSchedule.isPresent()) {
                HospitalScheduleException exSchedule = optExSchedule.get();
                return HospitalSummaryResponse.builder()
                        .id(hospital.getId())
                        .name(hospital.getName())
                        .address(hospital.getAddress())
                        .openTime(exSchedule.getOpenTime())
                        .closeTime(exSchedule.getCloseTime())
                        .isClosed(exSchedule.isClosed())
                        .build();
            }

            HospitalSchedule schedule = hospitalScheduleRepository
                    .findByHospitalIdAndDayOffWeek(hospital.getId(), (short) LocalDate.now().getDayOfWeek().getValue())
                    .orElseThrow(() -> new CustomException(ErrorCode.HOSPITAL_NO_SCHEDULE));
            return HospitalSummaryResponse.builder()
                    .id(hospital.getId())
                    .name(hospital.getName())
                    .address(hospital.getAddress())
                    .openTime(schedule.getOpenTime())
                    .closeTime(schedule.getCloseTime())
                    .isClosed(schedule.isClosed())
                    .build();
        }).toList();
        return new PageImpl<>(hospitalSummaryResponses, pageable, hospitals.size());
    }
}
