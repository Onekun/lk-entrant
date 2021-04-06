package ru.esstu.entrant.lk.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalInformationDto {
    private String id;
    private String index;
    private String region;
    private String area;
    private String city;
    private String street;
    private String number_of_building;
    private String number_of_apartments;
}
