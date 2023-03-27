package academy.mindswap.commitAir.mapper;


import academy.mindswap.commitAir.dto.BookingDto;
import academy.mindswap.commitAir.model.Booking;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BookingMapper {

    Booking fromDtoToEntity(BookingDto bookingDto);

    BookingDto fromEntityToDto(Booking booking);
}
