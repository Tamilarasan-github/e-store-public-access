package com.tamilcreations.estorepublicaccess.users;

import java.util.List;

import graphql.relay.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserConnection
{
	private PageInfo pageInfo;
	private List<UserEdge> edges;
	
	public UserConnection(PageInfo pageInfo, List<UserEdge> edges)
	{
		super();
		this.pageInfo = pageInfo;
		this.edges = edges;
	}

	public PageInfo getPageInfo()
	{
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo)
	{
		this.pageInfo = pageInfo;
	}

	public List<UserEdge> getEdges()
	{
		return edges;
	}

	public void setEdges(List<UserEdge> edges)
	{
		this.edges = edges;
	}
	
	
	
	
}
