package com.chichaev.atipera.dto;

import com.chichaev.atipera.entity.BranchEntity;

import java.util.List;

public class RepoEntityDto {
    private String ownerLogin;
    private String repoName;
    private List<BranchEntity> branches;

    public String getownerLogin() {
        return ownerLogin;
    }

    public void setownerLogin(String ownerLogin) {
        this.ownerLogin = ownerLogin;
    }

    public String getrepoName() {
        return repoName;
    }

    public void setrepoName(String repoName) {
        this.repoName = repoName;
    }

    public List<BranchEntity> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchEntity> branches) {
        this.branches = branches;
    }

    public RepoEntityDto() {
    }

    public RepoEntityDto(String ownerLogin, String repoName, List<BranchEntity> branches) {
        this.ownerLogin = ownerLogin;
        this.repoName = repoName;
        this.branches = branches;
    }
}
