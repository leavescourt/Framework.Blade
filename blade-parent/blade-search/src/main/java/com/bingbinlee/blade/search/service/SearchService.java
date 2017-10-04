package com.bingbinlee.blade.search.service;


import com.bingbinlee.blade.search.pojo.SearchResult;

public interface SearchService {

	SearchResult search(String queryString, int page, int rows) throws Exception;
}
