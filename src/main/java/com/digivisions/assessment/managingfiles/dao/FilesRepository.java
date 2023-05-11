package com.digivisions.assessment.managingfiles.dao;

import com.digivisions.assessment.managingfiles.entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilesRepository extends JpaRepository<Files, Long> {

    String fileMetadataQuery = "WITH RECURSIVE cte(id, parent_item_id, name) AS (\n" +
            "    SELECT t.id, t.parent_item_id , t.name FROM item t join files f on f.item_id = t.id where f.id=:fileId and t.type=2 \n" +
            "  UNION ALL\n" +
            "    SELECT t.id, t.parent_item_id, t.name FROM item t, cte cte  WHERE t.id = cte.parent_item_id)\n" +
            "SELECT id, name FROM cte order by id desc;";

    @Query(value = fileMetadataQuery, nativeQuery = true)
    List<Object[]> getFileMetadata(Long fileId);
}
