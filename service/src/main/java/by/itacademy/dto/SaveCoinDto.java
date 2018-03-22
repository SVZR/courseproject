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
public class SaveCoinDto {

    private long seriesId;
    private String coinName;
    private String designer;
    private String releaseDate;
    private String mintedBy;
    private String description;
}
