package academy.mindswap.commitAir.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AirLabsResponseCitiesDto {
   public List<CityDto> response;
}
