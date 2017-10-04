package com.bingbinlee.blade.portal.service;


import com.bingbinlee.blade.portal.pojo.SearchResult;

public interface SearchService {

	SearchResult search(String queryString, int page);
}
