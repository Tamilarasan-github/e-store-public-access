package com.tamilcreations.estorepublicaccess.userRoles;

import com.tamilcreations.estorepublicaccess.utils.Utils;

public class UserRoleInput {

    private String uuid;
    private String userUuid;
    private String roleUuid;
    private String createdDate;
    private String updatedDate;
    private String createdBy;
    private String updatedBy;
    private boolean deleteFlag;
    
    

    
    public UserRoleInput()
	{
		super();
	}




	public UserRoleInput(String uuid, String userUuid, String roleUuid, String createdDate, String updatedDate, String createdBy,
			String updatedBy, boolean deleteFlag)
	{
		super();
		this.uuid = uuid;
		this.userUuid = userUuid;
		this.roleUuid = roleUuid;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.deleteFlag = deleteFlag;
	}




	public String getUuid()
	{
		return uuid;
	}




	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}




	public String getUserUuid()
	{
		return userUuid;
	}




	public void setUserUuid(String userUuid)
	{
		this.userUuid = userUuid;
	}




	public String getRoleUuid()
	{
		return roleUuid;
	}




	public void setRoleUuid(String roleUuid)
	{
		this.roleUuid = roleUuid;
	}




	public String getCreatedDate()
	{
		return createdDate;
	}




	public void setCreatedDate(String createdDate)
	{
		this.createdDate = createdDate;
	}




	public String getUpdatedDate()
	{
		return updatedDate;
	}




	public void setUpdatedDate(String updatedDate)
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




	public UserRole toUserRole() {
        UserRole userRole = new UserRole();
        userRole.setUuid(this.uuid);
        //userRole.setUserUuid(this.userUuid);
        //userRole.setRoleUuid(this.roleUuid);
        userRole.setCreatedDate(Utils.convertStringToDateFormat(this.createdDate));
        userRole.setUpdatedDate(Utils.convertStringToDateFormat(this.updatedDate));
        userRole.setCreatedBy(this.createdBy);
        userRole.setUpdatedBy(this.updatedBy);
        userRole.setDeleteFlag(this.deleteFlag);
        
        return userRole;
    }
}

