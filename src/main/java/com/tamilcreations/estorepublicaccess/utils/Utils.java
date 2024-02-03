package com.tamilcreations.estorepublicaccess.utils;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.stereotype.Service;

public class Utils
{
	public static String getCurrentDateAndTime(String format)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		return dtf.format(now);
	}

	public static Date convertStringToDateFormat(String dateStringFormat)
	{
		Date convertedDate = null;

		if (dateStringFormat != null && !dateStringFormat.isEmpty())
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			try
			{
				convertedDate = dateFormat.parse(dateStringFormat);
			} catch (ParseException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return convertedDate;
	}

	public String generateUUID()
	{
		// Generate a random UUID
		UUID uuid = UUID.randomUUID();

		// Convert UUID to a string representation
		String uuidString = uuid.toString();

		return uuidString;

	}
	
	public static <T> T applyNewCreationDefaultValues(T anyObject, String userIdentity) {
        Date currentDate = new Date();
        
        try {
        	  anyObject.getClass().getMethod("setUuid", String.class).invoke(anyObject, UUID.randomUUID().toString());
        	  anyObject.getClass().getMethod("setCreatedBy", String.class).invoke(anyObject, userIdentity);
        	  anyObject.getClass().getMethod("setCreatedDate", Date.class).invoke(anyObject, currentDate);
              anyObject.getClass().getMethod("setUpdatedBy", String.class).invoke(anyObject, (String)null);
              anyObject.getClass().getMethod("setUpdatedDate", Date.class).invoke(anyObject, (Date) null);
              anyObject.getClass().getMethod("setDeleteFlag", boolean.class).invoke(anyObject, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return anyObject;
    }
	
	public static <T> T applyUpdateDefaultValues(T anyObject,  String userIdentity) {
        Date currentDate = new Date();
        
        try {
      	  	anyObject.getClass().getMethod("setUpdatedBy", String.class).invoke(anyObject, userIdentity);
            anyObject.getClass().getMethod("setUpdatedDate", Date.class).invoke(anyObject, currentDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return anyObject;
    }
	
	public static <T> T applySoftDelete(T anyObject,  String userIdentity) {
        Date currentDate = new Date();
        
        try {
      	  	anyObject.getClass().getMethod("setUpdatedBy", String.class).invoke(anyObject, userIdentity);
            anyObject.getClass().getMethod("setUpdatedDate", Date.class).invoke(anyObject, currentDate);
            anyObject.getClass().getMethod("setDeleteFlag", boolean.class).invoke(anyObject, true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return anyObject;
    }
}
