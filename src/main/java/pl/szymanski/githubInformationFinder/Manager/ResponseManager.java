package pl.szymanski.githubInformationFinder.Manager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import pl.szymanski.githubInformationFinder.Entity.Branch;
import pl.szymanski.githubInformationFinder.Entity.Repo;
import pl.szymanski.githubInformationFinder.Entity.ResponseEntity;
import pl.szymanski.githubInformationFinder.Exception.ExceptionEntity;
import pl.szymanski.githubInformationFinder.Exception.UserNotFoundException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.*;

public class ResponseManager {
    List<ResponseEntity> listOfRepositories = new ArrayList<>();
    ResponseEntity responseEntity = new ResponseEntity();

    public List<ResponseEntity> getResponse(String name) throws IOException, InterruptedException {
        List<Repo> repos = getUserRepos(name);
        for (Repo repo : repos){
            if(repo.getFork() == false){
                ResponseEntity responseEntity = new ResponseEntity();
                responseEntity.setRepositoryName(repo.getName());
                responseEntity.setOwnerLogin(repo.getOwner().getLogin());
                responseEntity.setBranchesInfo(getRepositoryBranches(repo.getName(), name));
                listOfRepositories.add(responseEntity);

            }
        }
        return listOfRepositories;
    }
    public List<Repo> getUserRepos(String name) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
        String endPoint = "https://api.github.com/users/" + name + "/repos";
        URI uri = URI.create(endPoint);
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String jsonResponse = response.body();
        if (response.statusCode()==404) {
            ExceptionEntity exceptionEntity = new Gson().fromJson(jsonResponse, ExceptionEntity.class);
            ExceptionManager exceptionManager = new ExceptionManager(response.statusCode(), exceptionEntity.getMessage());
            throw new UserNotFoundException(exceptionManager);
        }
        Type repoArrayList = new TypeToken<ArrayList<Repo>>(){}.getType();
        List<Repo> repos = new Gson().fromJson(jsonResponse, repoArrayList);
        return repos;
    }

    public Map<String, String> getRepositoryBranches(String repositoryName, String name) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
        String endPoint = "https://api.github.com/repos/" + name + "/" + repositoryName + "/branches";
        URI uri = URI.create(endPoint);
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String jsonResponse = response.body();

        Type branchArrayList = new TypeToken<ArrayList<Branch>>(){}.getType();
        List<Branch> branches = new Gson().fromJson(jsonResponse, branchArrayList);
        Map<String, String> repositoryBranches = new HashMap<>();
        for (Branch branch : branches){
            repositoryBranches.put(branch.getName(), branch.getCommit().getSha());
            System.out.println(branch.getName() + branch.getCommit().getSha());
        }
        return repositoryBranches;
    }
}


