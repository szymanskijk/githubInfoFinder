package pl.szymanski.githubInformationFinder.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.szymanski.githubInformationFinder.Entity.Branch;
import pl.szymanski.githubInformationFinder.Entity.Repo;

import java.util.*;

public class ResponseManager {
    String repoName;
    String ownerLogin;
    Map<String, String> branchesInfo = new HashMap<>();

    public ResponseManager(String repoName, String ownerLogin, Map<String, String> branchesInfo) {
        this.repoName = repoName;
        this.ownerLogin = ownerLogin;
        this.branchesInfo = branchesInfo;
    }

    public ResponseManager(){
        repoName = "testowe";
        ownerLogin = "testowy";
        branchesInfo.put("nazwa1", "sha1");
        branchesInfo.put("nazwa2", "sha2");
    }

    public void setBranchesInfo(String branchName, String lastCommitSha){
        branchesInfo.put(branchName, lastCommitSha);
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public void setOwnerLogin(String ownerLogin) {
        this.ownerLogin = ownerLogin;
    }

    public Map<String, String> getBranchesInfo() {
        return branchesInfo;
    }

    public void setBranchesInfo(Map<String, String> branchesInfo) {
        this.branchesInfo = branchesInfo;
    }

}


