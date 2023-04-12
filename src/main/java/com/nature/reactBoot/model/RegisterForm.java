package com.nature.reactBoot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterForm {
    private String client_Id;
    private String client_Password;
    private String client_Nickname;
    private String client_Email;
    private String client_Phone;
}
