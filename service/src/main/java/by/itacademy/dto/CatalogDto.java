package by.itacademy.dto;

import by.itacademy.entity.Theme;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CatalogDto {

    private String countryName;
    private List<Theme> themes;
}
