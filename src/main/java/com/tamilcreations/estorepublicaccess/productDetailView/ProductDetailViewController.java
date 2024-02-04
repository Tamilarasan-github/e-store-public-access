package com.tamilcreations.estorepublicaccess.productDetailView;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.tamilcreations.estorepublicaccess.utils.CursorUtils;

import graphql.relay.DefaultPageInfo;
import graphql.relay.PageInfo;
import io.micrometer.common.lang.Nullable;

@Controller
public class ProductDetailViewController
{
	@Autowired
	ProductDetailViewService productDetailViewService;
	

	@QueryMapping
	public ProductDetailViewConnection getAllActiveProductDetailsWithStocksPriceAndDiscounts( @Argument @Nullable String productName,  @Argument @Nullable int first, @Argument @Nullable String after, @Argument @Nullable String before)
	{
		 // Log or print parameter values
	    System.out.println("productName: " + productName);
	    System.out.println("after: " + after);
	    System.out.println("before: " + before);
	    System.out.println("limit: " + first);
	    
		List<ProductDetailView> productDetailViewList = null;
		int fetch = first + 1;
		productDetailViewList = productDetailViewService.getAllActiveProductDetailsWithStocksPriceAndDiscounts(productName, fetch, after, before);

        List<ProductDetailViewEdge> edges = productDetailViewList.stream()
            .map(productDetailView -> new ProductDetailViewEdge(CursorUtils.encodedCursorFor(productDetailView.getProductId()).getValue(), productDetailView))
            .collect(Collectors.toList());

        PageInfo pageInfo = new DefaultPageInfo(
        		CursorUtils.encodedCursorFor(productDetailViewList.get(0).getProductId()),  // startCursor
        		CursorUtils.encodedCursorFor(productDetailViewList.get(productDetailViewList.size() - 1).getProductId()),  // endCursor
        		productDetailViewList.size() > first,  // hasNextPage
                after != null  // hasPreviousPage
            );
        
        return new ProductDetailViewConnection(pageInfo, edges);
		 
	}
}
