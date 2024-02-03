package com.tamilcreations.estorepublicaccess.roles;

import com.tamilcreations.estorepublicaccess.utils.Utils;



public class RoleInput {

    private Long roleId;
    
    
    private String uuid;

    
    private String roleName;

    
    private String createdDate;

    
    private String updatedDate;

    
    private String createdBy;

    
    private String updatedBy;

    
    private boolean deleteFlag;

    // Constructors
    public RoleInput() {
        // Default constructor
    }

    
    public RoleInput(Long roleId, String uuid, String roleName, String createdDate, String updatedDate, String createdBy,
			String updatedBy, boolean deleteFlag)
	{
		super();
		this.roleId = roleId;
		this.uuid = uuid;
		this.roleName = roleName;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.deleteFlag = deleteFlag;
	}



	public Long getRoleId() {
        return roleId;
    }
    
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
    
    public String getUuid()
	{
		return uuid;
	}



	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}



	public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
    
    public Role toRole() {
        Role role = new Role();
        role.setUuid(this.uuid); 
        role.setRoleName(this.roleName);
        role.setCreatedDate(Utils.convertStringToDateFormat(this.createdDate));
        role.setUpdatedDate(Utils.convertStringToDateFormat(this.updatedDate)); // Assuming updatedDate starts as null for a new role
        role.setCreatedBy(this.createdBy);
        role.setUpdatedBy(this.updatedBy); // Assuming updatedBy starts as null for a new role
        role.setDeleteFlag(this.deleteFlag);
   
        return role;
    }
}

