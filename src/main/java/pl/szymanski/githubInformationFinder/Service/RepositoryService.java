package pl.szymanski.githubInformationFinder.Service;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import pl.szymanski.githubInformationFinder.Entity.Owner;
import pl.szymanski.githubInformationFinder.Exception.ExceptionEntity;
import pl.szymanski.githubInformationFinder.Exception.UserNotFoundException;
import pl.szymanski.githubInformationFinder.Manager.ExceptionManager;
import pl.szymanski.githubInformationFinder.Manager.ResponseManager;
import pl.szymanski.githubInformationFinder.Repository.RepoRepository;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/repository")
public class RepositoryService {

    List<ResponseManager> listOfRepositories = new ArrayList<>();


    @GetMapping(headers = "Accept=application/json")
    public List<ResponseManager> getByName(@RequestParam String name) throws IOException, InterruptedException {

//        if (response.statusCode()==404) {
//            ExceptionEntity exceptionEntity = new Gson().fromJson(jsonResponse, ExceptionEntity.class);
//            ExceptionManager exceptionManager = new ExceptionManager(response.statusCode(), exceptionEntity.getMessage());
//            throw new UserNotFoundException(exceptionManager);
//        }
        listOfRepositories.add(new ResponseManager());
        listOfRepositories.add(new ResponseManager());
        listOfRepositories.add(new ResponseManager());
        return listOfRepositories;
    }

}
