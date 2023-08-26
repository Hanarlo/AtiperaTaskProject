package com.chichaev.atipera.controller;

import com.chichaev.atipera.dto.RepoEntityDto;
import com.chichaev.atipera.entity.RepoEntity;
import com.chichaev.atipera.exception.ErrorMessage;
import com.chichaev.atipera.service.GitHubApiServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
class Controller {

    GitHubApiServiceImpl service = new GitHubApiServiceImpl();
    List<RepoEntity> repos = new ArrayList<>();

    @GetMapping("/repositories/{username}")
    public ResponseEntity<Object> getRepositories(@PathVariable String username,
                                                  @RequestHeader("Accept") String acceptHeader) {

        if ("application/xml".equals(acceptHeader)) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body(new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(), "XML format not supported."));
        }

        try {
            repos = service.getRepos(username);
        } catch (HttpClientErrorException.NotFound notFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorMessage(HttpStatus.NOT_FOUND.value(), "User " + username + " not found."));
        }

            service.getBranches(repos);

        ArrayList<RepoEntityDto> result = new ArrayList<>();
        repos.forEach(r -> result.add(new RepoEntityDto(r.getOwner().getLogin(), r.getName(), r.getBranch())));

        return ResponseEntity.ok(result);
    }
}
