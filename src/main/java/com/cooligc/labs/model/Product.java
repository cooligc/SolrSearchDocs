package com.cooligc.labs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.List;

@Builder
@Setter
@Getter
@SolrDocument(solrCoreName = "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
            @Field
    private String id;

    @Field
    @Indexed
    private String name;

    @Field
    private List<String> categories;

    @Field
    private String description;

    @Field
    private String url;





}
