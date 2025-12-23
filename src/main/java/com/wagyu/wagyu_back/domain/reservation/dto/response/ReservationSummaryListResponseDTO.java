package com.wagyu.wagyu_back.domain.reservation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ReservationSummaryListResponseDTO {
    private List<ReservationSummaryResponseDTO> reservations;
}
