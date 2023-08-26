package com.chichaev.atipera.service;

import com.chichaev.atipera.entity.RepoEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

public interface GitHubApiService {

    public List<RepoEntity> getRepos(String username) throws HttpClientErrorException.NotFound;

    public void getBranches(List<RepoEntity> repos) throws HttpClientErrorException.NotFound;
}
