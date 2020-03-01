package com.tom.batch.multiWrite.repository.batch;

import com.tom.batch.multiWrite.entity.batch.Entity1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-02-21
 * Time: 23:13
 */

@Repository
public interface Entity1Repository extends JpaRepository<Entity1, String> {
    @Query("select t from Entity1 t where t.name = :name")
    Entity1 findTom(@Param("name") String name);
}
