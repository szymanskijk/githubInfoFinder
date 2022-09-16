package pl.szymanski.githubInformationFinder.Exception;

import pl.szymanski.githubInformationFinder.Manager.ExceptionManager;

import java.io.IOException;
import java.net.http.HttpResponse;

public class UserNotFoundException extends RuntimeException {

    public ExceptionManager response = null;

    public UserNotFoundException(ExceptionManager response) {
        this.response = response;
    }
}
