package pl.szymanski.githubInformationFinder.Entity;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Branch {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("commit")
    @Expose
    private Commit commit;
    @SerializedName("protected")
    @Expose
    private Boolean _protected;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }

    public Boolean getProtected() {
        return _protected;
    }

    public void setProtected(Boolean _protected) {
        this._protected = _protected;
    }

}
