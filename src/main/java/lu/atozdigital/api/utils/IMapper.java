package lu.atozdigital.api.utils;

public interface IMapper<E, D> {

    D toDTO(E entity, Class<D> target);
}