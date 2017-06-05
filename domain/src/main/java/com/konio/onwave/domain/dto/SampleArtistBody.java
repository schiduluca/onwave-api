package com.konio.onwave.domain.dto;

import java.util.LinkedList;

/**
 * Created by lschidu on 5/12/17.
 */
public class SampleArtistBody {

    private Integer resultCount;
    private LinkedList<Artist> results;

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public LinkedList<Artist> getResults() {
        return results;
    }

    public void setResults(LinkedList<Artist> results) {
        this.results = results;
    }
}
