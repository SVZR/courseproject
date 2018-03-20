package by.itacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author kirylhrybouski
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchFilterTest {

    private String firstName;
    private String role;
    private String haveCollection;
    private Integer amountUsersOnPage;
}
