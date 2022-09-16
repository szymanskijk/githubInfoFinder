package pl.szymanski.githubInformationFinder.Entity;

import java.util.HashMap;
import java.util.Map;

public class ResponseEntity {
    String repoName;
    String ownerLogin;
    Map<String, String> branchesInfo = new HashMap<>();

    public ResponseEntity(String repoName, String ownerLogin, Map<String, String> branchesInfo) {
        this.repoName = repoName;
        this.ownerLogin = ownerLogin;
        this.branchesInfo = branchesInfo;
    }

    public ResponseEntity(){
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
