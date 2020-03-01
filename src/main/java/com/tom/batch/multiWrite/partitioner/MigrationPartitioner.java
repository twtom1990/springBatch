package com.tom.batch.multiWrite.partitioner;

import com.tom.batch.multiWrite.repository.batch.Entity1Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-02-23
 * Time: 18:54
 */
@Component
@Slf4j
public class MigrationPartitioner implements Partitioner {

    @Autowired
    private Entity1Repository entity1Repository;

    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        long allNum = entity1Repository.count();
        log.info("partition  gridsize is " + gridSize + ", all number is :" + allNum);
        Map<String, ExecutionContext> result = new HashMap<>();
        long evePiece = allNum / gridSize;
        for (int i = 1; i <= gridSize; i++) {
            ExecutionContext value = new ExecutionContext();

            value.putLong("start", (i-1)*evePiece+1);
            if(i == gridSize){
                value.putLong("end",allNum);
            }else{
                value.putLong("end", i*evePiece);
            }
            value.putString("name", "Thread" + i);
            result.put("partition" + i, value);
        }
        return result;
    }
}
