package com.web.sample_web.service.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberRequest {
    @Size(min = 4, message = "full name at least need 4 character")
    private String name;
    @Size(min = 4, message = "user name at least need 4 character")
    private String userName;
    @Size(min = 8, message = "password at least need 8 character")
    private String password;
    @Email(message = " please enter a valid email address")
    private String email;
}
