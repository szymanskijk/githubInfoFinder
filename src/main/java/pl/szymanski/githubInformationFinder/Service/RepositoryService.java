package pl.szymanski.githubInformationFinder.Service;

import org.springframework.web.bind.annotation.*;
import pl.szymanski.githubInformationFinder.Entity.ResponseEntity;
import pl.szymanski.githubInformationFinder.Manager.ResponseManager;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/repository")
public class RepositoryService {

    ResponseManager responseManager = new ResponseManager();

    @GetMapping(headers = "Accept=application/json")
    public List<ResponseEntity> getByName(@RequestParam String name) throws IOException, InterruptedException {return responseManager.getResponse(name);}
}
