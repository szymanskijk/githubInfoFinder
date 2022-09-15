package pl.szymanski.githubInformationFinder.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.szymanski.githubInformationFinder.Entity.Branch;
import pl.szymanski.githubInformationFinder.Entity.Repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ResponseManager {
    Branch[] branchesResponse;
    Repo repository = new Repo();

    public ResponseManager(Branch[] branches, Repo repo){
        this.branchesResponse = branches;
        this.repository = repo;
    }

    public ResponseManager getUserInfo(String name){

        return this;
    }
}
