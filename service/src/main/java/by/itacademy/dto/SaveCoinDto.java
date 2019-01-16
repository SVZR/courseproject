package by.itacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author kirylhrybouski
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveCoinDto {

    private long seriesId;
    @NotEmpty(message = "valid.message.isEmpty")
    private String coinName;
    private String designer;
    private String releaseDate;
    private String mintedBy;
    private String description;
}
