package pl.szymanski.githubInformationFinder.Service;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.szymanski.githubInformationFinder.Entity.Owner;
import pl.szymanski.githubInformationFinder.Repository.RepoRepository;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@RestController
@RequestMapping("/repository")
public class RepositoryService {

    private RepoRepository ownerRepository;
    private JSONObject response = new JSONObject();

    @Autowired
    public RepositoryService(RepoRepository ownerRepo){
        this.ownerRepository = ownerRepo;
    }

    @GetMapping(headers = "Accept=application/json")
    public JSONObject getByName(@RequestParam String name) {
        try{
            URL urlUser = new URL("https://api.github.com/users/blabererelabla");
            InputStreamReader readUserData = new InputStreamReader(urlUser.openStream());
            Owner user = new Gson().fromJson(readUserData, Owner.class);
//            response.put()
        } catch (IOException e) {
            response.put("status","404");
            response.put("Message", " not found");
            System.out.println(response);
        }

        return response;
    }

    public static void main(String[] args) {
        try{
            URL urlUser = new URL("https://api.github.com/users/blabererelabla");
            InputStreamReader readUserData = new InputStreamReader(urlUser.openStream());
            Owner user = new Gson().fromJson(readUserData, Owner.class);
            System.out.println(user.getLogin());
        } catch (IOException e) {
            JSONObject response = new JSONObject();
            response.put("status","404");
            response.put("Message", " not found");
            System.out.println(response);
        }
    }
}
