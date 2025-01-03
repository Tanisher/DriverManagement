package com.logistics.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {
    private Long id;
    private String name;
    private String lastName;
    private String idNumber;
    private String licenseNumber;
    private String mobileNumber;
    private String address;
    private String nextOfKin;
    private String nextOfKinContact;
    private UserDTO user;

}
