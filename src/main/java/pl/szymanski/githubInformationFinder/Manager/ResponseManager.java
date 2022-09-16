package pl.szymanski.githubInformationFinder.Manager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
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
            responseEntity.setRepoName(repo.getName());
            responseEntity.setOwnerLogin(repo.getOwner().getLogin());
            listOfRepositories.add(responseEntity);
        }




        return listOfRepositories;
    }
    public List<Repo> getUserRepos(String name) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
//        HttpResponse<String> response = null;
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

}


