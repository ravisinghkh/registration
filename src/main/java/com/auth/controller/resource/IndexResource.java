package com.auth.controller.resource;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;
/**
 * Created by ravink on 4/11/2016.
 */
public class IndexResource extends ResourceSupport{
    private final String content;

    @JsonCreator
    public IndexResource(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
