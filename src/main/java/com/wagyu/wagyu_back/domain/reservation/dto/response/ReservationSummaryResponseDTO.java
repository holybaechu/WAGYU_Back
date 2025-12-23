package com.wagyu.wagyu_back.domain.reservation.dto.response;

import com.wagyu.wagyu_back.domain.reservation.enums.ReservationStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Builder
public class ReservationSummaryResponseDTO {
    private Long id;
    private String hospitalName;
    private String petName;
    private LocalDate date;
    private LocalTime time;
    private ReservationStatus status;
}
