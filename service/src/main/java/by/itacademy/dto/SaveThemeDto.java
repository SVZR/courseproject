package by.itacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author kirylhrybouski
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveThemeDto {

    private String themeName;
    private long countryId;
}
