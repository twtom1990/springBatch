package com.tom.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-02-16
 * Time: 17:29
 */
@Entity(name = "t_read_file_1")
@Data
public class ReadFile1Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name1;
    private String name2;
    private String name3;
    private String name4;
    private String name5;
}
