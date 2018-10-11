package com.samplevendor.app.helloworld;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.genestack.api.security.IUser;
import com.genestack.frontend.Application;

public class HelloWorldApplication extends Application {

    public UserInfo getUserInformation() {
        final IUser user = getSecurityFacade().getCurrentUser();
        return new UserInfo(user.getName(), user.getEMail());
    }

    private static final class UserInfo {
        @JsonProperty("name")
        private final String name;
        @JsonProperty("email")
        private final String email;

        private UserInfo(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }
}
