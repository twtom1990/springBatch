package com.tom.batch.multiWrite.repository.documents;

import com.tom.batch.multiWrite.entity.documents.Title;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-02-21
 * Time: 23:14
 */
@org.springframework.stereotype.Repository
public interface TitleRepository extends JpaRepository<Title, String> {

}
