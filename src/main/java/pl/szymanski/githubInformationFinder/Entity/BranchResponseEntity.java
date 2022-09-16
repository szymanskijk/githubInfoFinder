package pl.szymanski.githubInformationFinder.Entity;

public class BranchResponseEntity {
    private String branchName;
    private String sha;

    public BranchResponseEntity(String branchName, String sha) {
        this.branchName = branchName;
        this.sha = sha;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }
}
