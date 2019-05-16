package com.soholy.dogmanager.entity.user;

import com.soholy.dogmanager.entity.TOrganization;
import com.soholy.dogmanager.entity.TRoles;
import com.soholy.dogmanager.entity.TUsers;

import java.util.List;

public class EditRoleAndOrg {
    private List<TUsers> users;

    private TRoles role;

    private TOrganization organization;

    public List<TUsers> getUsers() {
        return users;
    }

    public void setUsers(List<TUsers> users) {
        this.users = users;
    }

    public TRoles getRole() {
        return role;
    }

    public void setRole(TRoles role) {
        this.role = role;
    }

    public TOrganization getOrganization() {
        return organization;
    }

    public void setOrganization(TOrganization organization) {
        this.organization = organization;
    }
}
