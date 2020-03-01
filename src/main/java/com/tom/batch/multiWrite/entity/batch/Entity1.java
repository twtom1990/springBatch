package com.tom.batch.multiWrite.entity.batch;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-02-21
 * Time: 23:05
 */
@Entity
@Data
public class Entity1 {
    @Id
    private String id;

    private String name;
}
