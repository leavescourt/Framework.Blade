package com.bingbinlee.blade.search.dao;


import com.bingbinlee.blade.search.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;

public interface SearchDao {

	SearchResult search(SolrQuery query) throws Exception;
}
