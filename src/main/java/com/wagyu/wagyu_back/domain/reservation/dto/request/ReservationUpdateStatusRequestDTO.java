package com.wagyu.wagyu_back.domain.reservation.dto.request;

import com.wagyu.wagyu_back.domain.reservation.enums.ReservationStatus;
import lombok.Getter;

@Getter
public class ReservationUpdateStatusRequestDTO {
    private ReservationStatus status;
    private String hospitalComment;
}
