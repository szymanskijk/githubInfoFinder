package pl.szymanski.githubInformationFinder.Service;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import pl.szymanski.githubInformationFinder.Entity.Owner;
import pl.szymanski.githubInformationFinder.Entity.ResponseEntity;
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

    ResponseManager responseManager = new ResponseManager();


    @GetMapping(headers = "Accept=application/json")
    public List<ResponseEntity> getByName(@RequestParam String name) throws IOException, InterruptedException {

//        listOfRepositories.add(new ResponseManager());
//        listOfRepositories.add(new ResponseManager());
//        listOfRepositories.add(new ResponseManager());
        return responseManager.getResponse(name);
    }

}
