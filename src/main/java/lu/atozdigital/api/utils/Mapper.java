package lu.atozdigital.api.utils;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class Mapper<E, D> implements IMapper<E, D>{

    private final ModelMapper modelMapper;

    @Override
    public D toDTO(E entity, Class<D> target) {
        return modelMapper.map(entity, target);
    }
}
