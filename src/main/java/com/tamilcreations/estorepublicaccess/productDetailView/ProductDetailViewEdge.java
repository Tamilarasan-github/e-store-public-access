package com.tamilcreations.estorepublicaccess.productDetailView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ProductDetailViewEdge
{
	private String cursor;
	private ProductDetailView node;
	
	public ProductDetailViewEdge(String cursor, ProductDetailView node)
	{
		super();
		this.cursor = cursor;
		this.node = node;
	}

	public String getCursor()
	{
		return cursor;
	}

	public void setCursor(String cursor)
	{
		this.cursor = cursor;
	}

	public ProductDetailView getNode()
	{
		return node;
	}

	public void setNode(ProductDetailView node)
	{
		this.node = node;
	}
	
	
}
