package com.chichaev.atipera.entity;

public class BranchEntity {

    private String name;
    private BranchCommitEntity commit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BranchCommitEntity getCommit() {
        return commit;
    }

    public void setCommit(BranchCommitEntity commit) {
        this.commit = commit;
    }

    @Override
    public String toString() {
        return "BranchEntity{" +
                "name='" + name + '\'' +
                ", commit=" + commit.getSha() +
                '}';
    }
}
