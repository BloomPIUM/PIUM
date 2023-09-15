package com.bloom.pium.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserInfoDto {
    private String username;
    private String password;
    private String name;
    private String phone;
    private String gender;


}
