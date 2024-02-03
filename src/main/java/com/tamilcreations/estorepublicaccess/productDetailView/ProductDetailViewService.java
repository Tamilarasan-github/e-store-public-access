package com.tamilcreations.estorepublicaccess.productDetailView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tamilcreations.estorepublicaccess.utils.Constants;
import com.tamilcreations.estorepublicaccess.utils.CursorUtils;

@Service
public class ProductDetailViewService
{
	@Autowired
	ProductDetailViewRepo productDetailViewRepo;

	@Value("${message.info.stocks.limited}")
	private String limitedStocksMessage;

	@Value("${message.info.stocks.lastOne}")
	private String lastOneLeftMessage;

	@Value("${message.info.discounts.limitedTimeDeal}")
	private String limitedTimeDeal;

	@Value("${message.info.discounts.offerEndsSoon}")
	private String offerEndsSoon;

	@Transactional
	public List<ProductDetailView> getAllActiveProductDetailsWithStocksPriceAndDiscounts(String productName, int first,
			String after, String before)
	{
		List<ProductDetailView> productDetailViewListFromDB = null;
		List<ProductDetailView> productDetailViewPricesUpdatedList = new ArrayList<ProductDetailView>();

		if (after == null && before == null)
		{
			productDetailViewListFromDB = productDetailViewRepo
					.getAllActiveProductDetailsWithStocksPriceAndDiscounts(productName, first, null, null);
		} else if (after == null && before != null)
		{
			productDetailViewListFromDB = productDetailViewRepo.getAllActiveProductDetailsWithStocksPriceAndDiscounts(
					productName, first, null, CursorUtils.decodeCursor(before));
		} else if (after != null && before == null)
		{
			productDetailViewListFromDB = productDetailViewRepo.getAllActiveProductDetailsWithStocksPriceAndDiscounts(
					productName, first, CursorUtils.decodeCursor(after), null);
		}

		for (ProductDetailView productDetailView : productDetailViewListFromDB)
		{
			String discountType = productDetailView.getDiscountType();
			double finalAmount = productDetailView.getTotalPricePerUnit();
			Date discountTermDate = productDetailView.getDiscountTermDate();

			long currentTimeMillis = System.currentTimeMillis();
			long nextDayMillis = currentTimeMillis + 24 * 60 * 60 * 1000; // Add one day in milliseconds
			long threeDaysMillis = currentTimeMillis + (24 * 3) * 60 * 60 * 1000;
			
			Integer availableStock = productDetailView.getAvailableStocks();
			Integer maxPerOrder = productDetailView.getMaximumPerOrder();

			if (discountType != null)
			{
				if (Constants.FLAT.equalsIgnoreCase(discountType))
				{
					Double discountedAmount = productDetailView.getDiscountAmount();
					if (discountedAmount != null)
					{
						finalAmount = finalAmount - discountedAmount;
					}
				} else if (Constants.PERCENTAGE.equalsIgnoreCase(discountType))
				{
					Double discountedPercentage = productDetailView.getDiscountPercentage();
					if (discountedPercentage != null)
					{
						finalAmount = (productDetailView.getDiscountPercentage() / 100) * finalAmount;
					}
				}

				if (discountTermDate != null && discountTermDate.before(new Date(nextDayMillis)))
				{
					productDetailView.setDiscountMessage(offerEndsSoon);
				}
				else if (discountTermDate != null && discountTermDate.before(new Date(threeDaysMillis)))
				{
					productDetailView.setDiscountMessage(limitedTimeDeal);
				}

				productDetailView.setFinalPricePerUnit(finalAmount);

				if (maxPerOrder != null && availableStock != null)
				{
					if (availableStock <= maxPerOrder)
					{
						productDetailView.setMaximumPerOrder(availableStock);
						productDetailView.setStockMessage(limitedStocksMessage);
					}

					if (availableStock == 1)
					{
						productDetailView.setStockMessage(lastOneLeftMessage);
					}
				}

			}
			productDetailViewPricesUpdatedList.add(productDetailView);
		}
		return productDetailViewPricesUpdatedList;

	}
}
