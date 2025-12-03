package com.wagyu.wagyu_back.domain.hospital.repository;

import com.wagyu.wagyu_back.domain.hospital.entity.Hospital;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HospitalRepository extends CrudRepository<Hospital, Long> {
    List<Hospital> findAll(Pageable pageable);
}
