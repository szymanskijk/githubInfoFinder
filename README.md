As an api consumer, given username and header “Accept: application/json”, I would like to list all his github repositories, which are not forks. Information, which I require in the response, is:
Repository Name
Owner Login
For each branch it’s name and last commit sha

As an api consumer, given not existing github user, I would like to receive 404 response in such a format:
{

        “status”: ${responseCode}

        “Message”: ${whyHasItHappened}

}

Notes:
Please use https://developer.github.com/v3 as a backing API
