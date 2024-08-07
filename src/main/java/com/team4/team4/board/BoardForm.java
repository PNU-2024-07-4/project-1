package com.team4.team4.board;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class BoardForm {

    @NotEmpty(message = "제목은 필수 항목입니다.")
    @Size(max = 50)
    private String subject;

    @NotEmpty(message = "내용은 필수 항목입니다.")
    @Size(max = 250)
    private String content;

//    @NotEmpty(message = "시작날자는 필수 항목입니다.")
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate startDay;

//    @NotEmpty(message = "종료날자는 필수 항목입니다.")
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate endDay;

    @NotEmpty(message = "활동 지역은 필수 항목입니다.")
    @Size(max = 50)
    private String region;

//    @NotEmpty(message = "필요한 인원은 필수 항목입니다.")
    @NotNull
    private int recruitNumber;

    @Size(max = 50)
    private String recommendedTo;

}
