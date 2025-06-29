package com.facilcondo.backend.dto;

import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CondominiumDTO {
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 100)
    private String street;
    @NotBlank
    @Size(max = 10)
    private String streetNumber;
    @NotBlank
    @Size(max = 10)
    private String zipCode;
    @NotBlank
    @Size(max = 50)
    private String city;

    @Size(max = 50)
    private String province;
    @Size(max = 50)
    private String region;
    @Size(max = 50)
    private String country;
}
