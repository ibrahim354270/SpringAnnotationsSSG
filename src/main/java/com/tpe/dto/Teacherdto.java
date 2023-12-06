package com.tpe.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacherdto {

    @NotNull(message = "name can not be null")
    @NotBlank(message = "name can not be space")
    @Size(min = 2,max = 25)
    private String name;

    @NotNull(message = "name can not be null")
    @NotBlank(message = "name can not be space")
    @Size(min = 2,max = 25)
    private String surname;
    @Email
    private String email;
    private String phone;
    private String brans;
}
