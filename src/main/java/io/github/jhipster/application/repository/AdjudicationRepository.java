package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.Adjudication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Adjudication entity.
 */
@Repository
public interface AdjudicationRepository extends JpaRepository<Adjudication, Long> {

    @Query(value = "select distinct adjudication from Adjudication adjudication left join fetch adjudication.amounts left join fetch adjudication.amounts left join fetch adjudication.amounts",
        countQuery = "select count(distinct adjudication) from Adjudication adjudication")
    Page<Adjudication> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct adjudication from Adjudication adjudication left join fetch adjudication.amounts left join fetch adjudication.amounts left join fetch adjudication.amounts")
    List<Adjudication> findAllWithEagerRelationships();

    @Query("select adjudication from Adjudication adjudication left join fetch adjudication.amounts left join fetch adjudication.amounts left join fetch adjudication.amounts where adjudication.id =:id")
    Optional<Adjudication> findOneWithEagerRelationships(@Param("id") Long id);

}
