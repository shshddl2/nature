package com.nature.reactBoot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterForm {
    private String client_id;
    private String client_password;
    private String client_nickname;
    private String client_email;
    private String client_phone;
}
