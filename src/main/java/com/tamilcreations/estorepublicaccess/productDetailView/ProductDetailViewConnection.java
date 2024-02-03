package com.tamilcreations.estorepublicaccess.productDetailView;

import java.util.List;

import graphql.relay.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ProductDetailViewConnection
{
	private PageInfo pageInfo;
	private List<ProductDetailViewEdge> edges;
		
	public ProductDetailViewConnection(PageInfo pageInfo, List<ProductDetailViewEdge> edges)
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

	public List<ProductDetailViewEdge> getEdges()
	{
		return edges;
	}

	public void setEdges(List<ProductDetailViewEdge> edges)
	{
		this.edges = edges;
	}
	
	
	
	
}
