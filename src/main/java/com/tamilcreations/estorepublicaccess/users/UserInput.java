package com.tamilcreations.estorepublicaccess.users;

import java.util.Date;

import com.tamilcreations.estorepublicaccess.utils.Utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class UserInput
{
	
	private Long userId;
	
	
	private String uuid;	
	
	private String userName;
	
	private String password;
	
	
	private String firstName;
	
	
	private String middleName;
	
	
	private String lastName;
	
	
	private String emailId;
	
	
	private String phoneNumber;
	
	
	private String gender;
	
	
	private String dateOfBirth;
	
	
	private String profilePic;
	
	
	private Date lastLoginDate; 
	
	
	private String userAccountStatus;
		
	
	private Date createdDate;
	
	
	private Date updatedDate;
	
	
	private String createdBy;
	
	
	private String updatedBy;
	
	
	private boolean deleteFlag;

	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public String getUuid()
	{
		return uuid;
	}

	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}
	
	

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getMiddleName()
	{
		return middleName;
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmailId()
	{
		return emailId;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getDateOfBirth()
	{
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	public String getProfilePic()
	{
		return profilePic;
	}

	public void setProfilePic(String profilePic)
	{
		this.profilePic = profilePic;
	}

	public Date getLastLoginDate()
	{
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate)
	{
		this.lastLoginDate = lastLoginDate;
	}

	public String getUserAccountStatus()
	{
		return userAccountStatus;
	}

	public void setUserAccountStatus(String userAccountStatus)
	{
		this.userAccountStatus = userAccountStatus;
	}

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate()
	{
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate)
	{
		this.updatedDate = updatedDate;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public String getUpdatedBy()
	{
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy)
	{
		this.updatedBy = updatedBy;
	}

	public boolean isDeleteFlag()
	{
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag)
	{
		this.deleteFlag = deleteFlag;
	}
	
	public User toUser() {
        User user = new User();
        user.setUuid(this.uuid);
        user.setUserName(this.userName);
        user.setPassword(this.password);
        user.setFirstName(this.firstName);
        user.setMiddleName(this.middleName);
        user.setLastName(this.lastName);
        user.setEmailId(this.emailId);
        user.setPhoneNumber(this.phoneNumber);
        user.setGender(this.gender);
        user.setDateOfBirth(Utils.convertStringToDateFormat(this.dateOfBirth));
        user.setProfilePic(this.profilePic);
        user.setLastLoginDate(this.lastLoginDate);
        user.setUserAccountStatus(this.userAccountStatus);
        user.setCreatedDate(this.createdDate);
        user.setUpdatedDate(this.updatedDate);
        user.setCreatedBy(this.createdBy);
        user.setUpdatedBy(this.updatedBy);
        user.setDeleteFlag(this.deleteFlag);

        // Set other fields as needed...

        return user;
    }


}
