package pl.szymanski.githubInformationFinder;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.szymanski.githubInformationFinder.Entity.Owner;
import pl.szymanski.githubInformationFinder.Exception.ExceptionEntity;
import pl.szymanski.githubInformationFinder.Exception.UserNotFoundException;
import pl.szymanski.githubInformationFinder.Manager.ExceptionManager;

@ControllerAdvice
public class UserNotFoundResponse {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionManager response(UserNotFoundException exception){
        return exception.response;
    }
}
