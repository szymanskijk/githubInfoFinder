package pl.szymanski.githubInformationFinder.Service;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/repository")
public class RepositoryService {

//    private RepoRepository ownerRepository;
    private JSONObject myResponse = new JSONObject();
    String endPoint = "a";
    Owner user;
    ExceptionManager exceptionManager = new ExceptionManager(1, "a");
    ResponseManager[] listOfRepositories;

//    @Autowired
//    public RepositoryService(RepoRepository ownerRepo){
//        this.ownerRepository = ownerRepo;
//    }

    @GetMapping(headers = "Accept=application/json")
    public ResponseManager[] getByName(@RequestParam String name) throws IOException, InterruptedException {
//        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
//        HttpResponse<String> response = null;
//        endPoint = "https://api.github.com/users/szymdfdfanskijk";
//        URI uri = URI.create(endPoint);
//        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
//        response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        String jsonResponse = response.body();
//        if (response.statusCode()==404) {
//            ExceptionEntity exceptionEntity = new Gson().fromJson(jsonResponse, ExceptionEntity.class);
//            ExceptionManager exceptionManager = new ExceptionManager(response.statusCode(), exceptionEntity.getMessage());
//            throw new UserNotFoundException(exceptionManager);
//        }
//        user = new Gson().fromJson(jsonResponse, Owner.class);
//        return "a";
        listOfRepositories[0] = new ResponseManager();
        listOfRepositories[1] = new ResponseManager();
        listOfRepositories[2] = new ResponseManager();
        return listOfRepositories;
    }


//    public static void main(String[] args) {
//        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
//        HttpResponse<String> response = null;
//        try{
//            String endPoint = "https://api.github.com/users/szymafgbfgbbfgbnskijk";
//            URI uri = URI.create(endPoint);
//            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
//            response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            String jsonResponse = response.body();
//            if (response.statusCode()==404) {
//                throw new UserNotFoundException("name");
//            }
//            Owner user = new Gson().fromJson(jsonResponse, Owner.class);
////            System.out.println(user.getLogin());
//        }catch (Exception e){
////            System.out.println(response.statusCode());
////            System.out.println(response.body().toString());
//            e.printStackTrace();
//        }






//        try{
//            URL urlUser = new URL("https://api.github.com/users/blabererelabla");
//            InputStreamReader readUserData = new InputStreamReader(urlUser.openStream());
//            Owner user = new Gson().fromJson(readUserData, Owner.class);
//            System.out.println(user.getLogin());
//        } catch (IOException e) {
//            JSONObject response = new JSONObject();
//            response.put("status","404");
//            response.put("Message", " not found");
//            System.out.println(response);
//        }
//    }
}
