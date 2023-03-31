package academy.mindswap.commitAir.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto implements Serializable {
    private String code;
    private String code3;
    private String name;
}
