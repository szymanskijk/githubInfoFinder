package pl.szymanski.githubInformationFinder.Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseEntity {
    String repositoryName;
    String ownerLogin;
    List<BranchResponseEntity> listOfBranches;

    public ResponseEntity(){
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public void setOwnerLogin(String ownerLogin) {
        this.ownerLogin = ownerLogin;
    }

    public List<BranchResponseEntity> getListOfBranches() {
        return listOfBranches;
    }

    public void setListOfBranches(List<BranchResponseEntity> listOfBranches) {
        this.listOfBranches = listOfBranches;
    }

    public void setListOfBranchesByOne(String branchName, String sha){
        BranchResponseEntity branchResponseEntity = new BranchResponseEntity(branchName, sha);
        this.listOfBranches.add(branchResponseEntity);
    }
}
