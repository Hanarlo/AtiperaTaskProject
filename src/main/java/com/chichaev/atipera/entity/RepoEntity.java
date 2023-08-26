package com.chichaev.atipera.entity;

import java.util.List;

public class RepoEntity {

    private OwnerEntity owner;
    private String name;
    private Boolean fork;
    //this name is needed for parser
    private String branches_url;
    private List<BranchEntity> branch;

    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranches_url() {
        return branches_url;
    }

    public void setBranches_url(String branches_url) {
        this.branches_url = branches_url;
    }

    public Boolean getFork() {
        return fork;
    }

    public void setFork(Boolean fork) {
        this.fork = fork;
    }

    public List<BranchEntity> getBranch() {
        return branch;
    }

    public void setBranch(List<BranchEntity> branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "RepoEntity{" +
                "owner=" + owner.getLogin() +
                ", name='" + name + '\'' +
                '}';
    }
}
