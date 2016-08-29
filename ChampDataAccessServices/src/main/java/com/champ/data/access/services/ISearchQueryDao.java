package com.champ.data.access.services;

import java.util.List;

import com.champ.core.entity.SearchQuery;
import com.champ.core.enums.Medium;

public interface ISearchQueryDao {

	public SearchQuery getSearchQueryById(Long id);
	
	public void saveOrUpdateSearchQuery(SearchQuery searchQuery);

	public List<SearchQuery> getAllSearchQuery();
	
	public List<SearchQuery> getSearchQueryByMedium(Medium medium);
}
