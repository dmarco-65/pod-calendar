package mapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Interface générique pour la conversion entre entités et VOs
 *
 * @param <E> Type de l'entité
 * @param <V> Type du VO
 */
public interface EntityVOMapper<E, V> {

    /**
     * Convertit une entité en VO
     *
     * @param entity l'entité à convertir
     * @return le VO correspondant
     */
    V toVO(E entity);

    /**
     * Convertit un VO en entité
     *
     * @param vo le VO à convertir
     * @return l'entité correspondante
     */
    E toEntity(V vo);

    /**
     * Convertit une liste d'entités en liste de VOs
     *
     * @param entities la liste d'entités
     * @return la liste de VOs
     */
    default List<V> toVOList(List<E> entities) {
        return entities.stream()
                .map(this::toVO)
                .collect(Collectors.toList());
    }

    /**
     * Convertit une liste de VOs en liste d'entités
     *
     * @param vos la liste de VOs
     * @return la liste d'entités
     */
    default List<E> toEntityList(List<V> vos) {
        return vos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}