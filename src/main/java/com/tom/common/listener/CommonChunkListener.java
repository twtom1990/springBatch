package com.tom.common.listener;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.stereotype.Component;

/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-02-16
 * Time: 19:36
 */
@Component
public class CommonChunkListener implements ChunkListener {
    @Override
    public void beforeChunk(ChunkContext chunkContext) {
        System.out.println("CommonChunkListener -> beforeChunk : " + chunkContext.getStepContext());
    }

    @Override
    public void afterChunk(ChunkContext chunkContext) {
        System.out.println("CommonChunkListener -> afterChunk : " + chunkContext.getStepContext());
    }

    @Override
    public void afterChunkError(ChunkContext chunkContext) {
        System.out.println("CommonChunkListener -> afterChunkError : " + chunkContext.getStepContext());
    }
}
