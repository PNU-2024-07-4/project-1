package com.team4.team4.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModifyForm {
    @NotEmpty
    @Size(min = 10, max = 15, message = "연락처는 10자 이상 15자 이하로 입력해 주세요.")
    private String contactNumber;  // 연락처

    @Size(max = 1000, message = "자기소개는 최대 1000자까지 입력 가능합니다.")
    private String bio;  // 자기소개

    @Size(max = 255, message = "SNS 계정은 최대 255자까지 입력 가능합니다.")
    private String socialMediaHandles;  // SNS 계정
}