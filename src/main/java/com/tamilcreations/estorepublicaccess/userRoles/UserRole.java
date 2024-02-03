package com.tamilcreations.estorepublicaccess.userRoles;

import java.util.Date;

import com.tamilcreations.estorepublicaccess.roles.Role;
import com.tamilcreations.estorepublicaccess.users.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserRoles")
public class UserRole {

	@Id
    @Column(name = "user_roles_id")
    private Long userRolesId;
	
    @Column(name = "uuid", length = 36)
    private String uuid;

    @ManyToOne
	@JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
	@JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "created_by", nullable = false, length = 100)
    private String createdBy;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @Column(name = "delete_flag", nullable = false)
    private boolean deleteFlag;

    // Constructors, getters, setters...

    // Constructors
    public UserRole() {
        // Default constructor
    }

	public Long getUserRolesId()
	{
		return userRolesId;
	}

	public void setUserRolesId(Long userRolesId)
	{
		this.userRolesId = userRolesId;
	}

	public String getUuid()
	{
		return uuid;
	}

	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Role getRole()
	{
		return role;
	}

	public void setRole(Role role)
	{
		this.role = role;
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

   
}

