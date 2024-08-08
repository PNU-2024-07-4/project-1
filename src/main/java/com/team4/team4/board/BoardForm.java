package com.team4.team4.board;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class BoardForm {

    @NotEmpty(message = "제목은 필수 항목입니다.")
    @Size(max = 50)
    private String subject;

    @NotEmpty(message = "내용은 필수 항목입니다.")
    @Size(max = 250)
    private String content;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDay;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDay;

    @NotEmpty(message = "활동 지역은 필수 항목입니다.")
    @Size(max = 50)
    private String region;

    @NotNull
    private int recruitNumber;

    @Size(max = 50)
    private String recommendedTo;

}
