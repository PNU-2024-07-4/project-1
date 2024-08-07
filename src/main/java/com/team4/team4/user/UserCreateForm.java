package com.team4.team4.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "사용자ID는 필수항목입니다.")
    private String username;

    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String password2;

    @NotEmpty(message = "이메일은 필수항목입니다.")
    @Email
    private String email;

    @NotEmpty
    @Size(min = 10, max = 15, message = "연락처는 10자 이상 15자 이하로 입력해 주세요.")
    private String contactNumber;  // 연락처

    @Size(max = 200, message = "자기소개는 최대 200자까지 입력 가능합니다.")
    private String bio;  // 자기소개

    @Size(max = 255, message = "SNS 계정은 최대 255자까지 입력 가능합니다.")
    private String socialMediaHandles;  // SNS 계정
}