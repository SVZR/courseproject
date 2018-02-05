package by.itacademy.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CountryDto {

    private long id;
    private String name;

    public CountryDto(String name) {
        this.name = name;
    }
}
