package com.tamilcreations.estorepublicaccess.productDetailView;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ProductDetailView")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDetailView {
    @Id
    @Column(name = "product_id")
    private Long productId;
    
    @Column(name = "uuid", columnDefinition = "CHAR(36)")
	private String uuid;
	
    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_title")
    private String productTitle;

    @Column(name = "product_condition")
    private String productCondition;

    @Column(name = "description")
    private String description;

    @Column(name = "product_status")
    private String productStatus;

    @Column(name = "product_sub_category_id")
    private Long productSubCategoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "sub_category_name")
    private String subCategoryName;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "seller_id")
    private Long sellerId;

    @Column(name = "seller_name")
    private String sellerName;

    @Column(name = "total_price_per_unit")
    private Double totalPricePerUnit;
    
    @Transient
    private Double finalPricePerUnit;

    @Column(name = "tax_included")
    private Boolean taxIncluded;

    @Column(name = "tax_type")
    private String taxType;

    @Column(name = "tax_percentage")
    private Double taxPercentage;

    @Column(name = "currency")
    private String currency;

    @Column(name = "price_effective_date")
    private Date priceEffectiveDate;

    @Column(name = "price_term_date")
    private Date priceTermDate;

    @Column(name = "discount_type")
    private String discountType;

    @Column(name = "discount_amount")
    private Double discountAmount;

    @Column(name = "discount_percentage")
    private Double discountPercentage;

    @Column(name = "discount_effective_date")
    private Date discountEffectiveDate;

    @Column(name = "discount_term_date")
    private Date discountTermDate;
    
    @Transient
    private String discountMessage;

    @Column(name = "total_stocks")
    private Integer totalStocks;

    @Column(name = "available_stocks")
    private Integer availableStocks;

    @Column(name = "reserved_stocks")
    private Integer reservedStocks;
    
    @Column(name = "minimum_per_order")
    private Integer minimumPerOrder;
    
    @Column(name = "maximum_per_order")
    private Integer maximumPerOrder;
    
    @Transient
    private String stockMessage;

    @Column(name = "stocks_effective_date")
    private Date stocksEffectiveDate;

    @Column(name = "stocks_term_date")
    private Date stocksTermDate;

	public Long getProductId()
	{
		return productId;
	}

	public void setProductId(Long productId)
	{
		this.productId = productId;
	}

	public String getUuid()
	{
		return uuid;
	}

	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}

	public String getProductCode()
	{
		return productCode;
	}

	public void setProductCode(String productCode)
	{
		this.productCode = productCode;
	}

	public String getProductName()
	{
		return productName;
	}

	public void setProductName(String productName)
	{
		this.productName = productName;
	}

	public String getProductTitle()
	{
		return productTitle;
	}

	public void setProductTitle(String productTitle)
	{
		this.productTitle = productTitle;
	}

	public String getProductCondition()
	{
		return productCondition;
	}

	public void setProductCondition(String productCondition)
	{
		this.productCondition = productCondition;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getProductStatus()
	{
		return productStatus;
	}

	public void setProductStatus(String productStatus)
	{
		this.productStatus = productStatus;
	}

	public Long getProductSubCategoryId()
	{
		return productSubCategoryId;
	}

	public void setProductSubCategoryId(Long productSubCategoryId)
	{
		this.productSubCategoryId = productSubCategoryId;
	}

	public String getCategoryName()
	{
		return categoryName;
	}

	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}

	public String getSubCategoryName()
	{
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName)
	{
		this.subCategoryName = subCategoryName;
	}

	public String getBrandName()
	{
		return brandName;
	}

	public void setBrandName(String brandName)
	{
		this.brandName = brandName;
	}

	public String getImageUrl()
	{
		return imageUrl;
	}

	public void setImageUrl(String imageUrl)
	{
		this.imageUrl = imageUrl;
	}

	public Long getSellerId()
	{
		return sellerId;
	}

	public void setSellerId(Long sellerId)
	{
		this.sellerId = sellerId;
	}

	public String getSellerName()
	{
		return sellerName;
	}

	public void setSellerName(String sellerName)
	{
		this.sellerName = sellerName;
	}

	public Double getTotalPricePerUnit()
	{
		return totalPricePerUnit;
	}

	public void setTotalPricePerUnit(Double totalPricePerUnit)
	{
		this.totalPricePerUnit = totalPricePerUnit;
	}

	public Double getFinalPricePerUnit()
	{
		return finalPricePerUnit;
	}

	public void setFinalPricePerUnit(Double finalPricePerUnit)
	{
		this.finalPricePerUnit = finalPricePerUnit;
	}

	public Boolean getTaxIncluded()
	{
		return taxIncluded;
	}

	public void setTaxIncluded(Boolean taxIncluded)
	{
		this.taxIncluded = taxIncluded;
	}

	public String getTaxType()
	{
		return taxType;
	}

	public void setTaxType(String taxType)
	{
		this.taxType = taxType;
	}

	public Double getTaxPercentage()
	{
		return taxPercentage;
	}

	public void setTaxPercentage(Double taxPercentage)
	{
		this.taxPercentage = taxPercentage;
	}

	public String getCurrency()
	{
		return currency;
	}

	public void setCurrency(String currency)
	{
		this.currency = currency;
	}

	public Date getPriceEffectiveDate()
	{
		return priceEffectiveDate;
	}

	public void setPriceEffectiveDate(Date priceEffectiveDate)
	{
		this.priceEffectiveDate = priceEffectiveDate;
	}

	public Date getPriceTermDate()
	{
		return priceTermDate;
	}

	public void setPriceTermDate(Date priceTermDate)
	{
		this.priceTermDate = priceTermDate;
	}

	public String getDiscountType()
	{
		return discountType;
	}

	public void setDiscountType(String discountType)
	{
		this.discountType = discountType;
	}

	public Double getDiscountAmount()
	{
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount)
	{
		this.discountAmount = discountAmount;
	}

	public Double getDiscountPercentage()
	{
		return discountPercentage;
	}

	public void setDiscountPercentage(Double discountPercentage)
	{
		this.discountPercentage = discountPercentage;
	}

	public Date getDiscountEffectiveDate()
	{
		return discountEffectiveDate;
	}

	public void setDiscountEffectiveDate(Date discountEffectiveDate)
	{
		this.discountEffectiveDate = discountEffectiveDate;
	}

	public Date getDiscountTermDate()
	{
		return discountTermDate;
	}

	public void setDiscountTermDate(Date discountTermDate)
	{
		this.discountTermDate = discountTermDate;
	}

	public String getDiscountMessage()
	{
		return discountMessage;
	}

	public void setDiscountMessage(String discountMessage)
	{
		this.discountMessage = discountMessage;
	}

	public Integer getTotalStocks()
	{
		return totalStocks;
	}

	public void setTotalStocks(Integer totalStocks)
	{
		this.totalStocks = totalStocks;
	}

	public Integer getAvailableStocks()
	{
		return availableStocks;
	}

	public void setAvailableStocks(Integer availableStocks)
	{
		this.availableStocks = availableStocks;
	}

	public Integer getReservedStocks()
	{
		return reservedStocks;
	}

	public void setReservedStocks(Integer reservedStocks)
	{
		this.reservedStocks = reservedStocks;
	}

	public Integer getMinimumPerOrder()
	{
		return minimumPerOrder;
	}

	public void setMinimumPerOrder(Integer minimumPerOrder)
	{
		this.minimumPerOrder = minimumPerOrder;
	}

	public Integer getMaximumPerOrder()
	{
		return maximumPerOrder;
	}

	public void setMaximumPerOrder(Integer maximumPerOrder)
	{
		this.maximumPerOrder = maximumPerOrder;
	}

	public String getStockMessage()
	{
		return stockMessage;
	}

	public void setStockMessage(String stockMessage)
	{
		this.stockMessage = stockMessage;
	}

	public Date getStocksEffectiveDate()
	{
		return stocksEffectiveDate;
	}

	public void setStocksEffectiveDate(Date stocksEffectiveDate)
	{
		this.stocksEffectiveDate = stocksEffectiveDate;
	}

	public Date getStocksTermDate()
	{
		return stocksTermDate;
	}

	public void setStocksTermDate(Date stocksTermDate)
	{
		this.stocksTermDate = stocksTermDate;
	}

	
    
}

