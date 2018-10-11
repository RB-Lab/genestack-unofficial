var genestackApi = require('@genestack/system-api');

genestackApi.loadApplication().then(function(app) {
    genestackApi.invokeMethod({
        applicationId: app.applicationId,
        method: 'getUserInformation',
        parameters: []
    }).then(function(user){
        var appBody = document.getElementById('application_body');
        var greeting = document.createElement('h1');
        greeting.textContent = 'Hello, ' + user.name + '!';
        appBody.appendChild(greeting);
        var email = document.createElement('p');
        email.textContent = 'Your email is: ' + user.email;
        appBody.appendChild(email);
    })
});
