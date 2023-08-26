package com.chichaev.atipera.service;

import com.chichaev.atipera.entity.BranchEntity;
import com.chichaev.atipera.entity.RepoEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


public class GitHubApiServiceImpl implements GitHubApiService{

    private static final String GITHUB_API_URL = "https://api.github.com";
    private final RestTemplate restTemplate = new RestTemplate();

    public List<RepoEntity> getRepos(String username) throws HttpClientErrorException.NotFound{
        String url = GITHUB_API_URL + "/users/" + username + "/repos";
        ResponseEntity<RepoEntity[]> response = restTemplate.getForEntity(url, RepoEntity[].class);
        return Arrays.stream(response.getBody()).filter(r -> !r.getFork()).toList();
    }

    public void getBranches(List<RepoEntity> repos){
        repos.forEach(r -> r.setBranch(Arrays.stream(restTemplate
                .getForEntity(r.getBranches_url().replace("{/branch}", ""),
                        BranchEntity[].class).getBody()).toList()));
    }

}
