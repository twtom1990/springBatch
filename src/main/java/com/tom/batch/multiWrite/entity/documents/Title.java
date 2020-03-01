package com.tom.batch.multiWrite.entity.documents;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-02-21
 * Time: 23:05
 */
@Entity
@Data
@Table(name = "document_title")
public class Title {
    @Id
    @Column(name = "title_id")
    private String titleId;

    @Column(name = "title_name")
    private String titleName;
}
