package com.accenture.ada.sessionManager.sessionmanager.command;

import com.accenture.ada.baseapp.command.BaseCommand;
import com.accenture.ada.baseapp.model.BaseContext;
import com.accenture.ada.baseapp.model.UserContext;
import com.accenture.ada.sessionManager.sessionmanager.model.entity.User;
import com.accenture.ada.sessionManager.sessionmanager.service.UserService;
import com.accenture.ada.sessionManager.sessionmanager.service.UserSessionCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Scope("prototype")
@Component
public class CreateSessionCommand extends BaseCommand<BaseContext<UserContext>> {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSessionCacheService userSessionCacheService;

    private String id;

    public CreateSessionCommand(String id) {
        this.id = id;
    }

    @Override
    protected BaseContext<UserContext> doExecute() {

     //   User user = userService.getUser(id);

        UserContext userContext = new UserContext();
        userContext.setEmail("email");
        userContext.setFirstName("firstName");
        userContext.setLastName("lLastName");
        userContext.setCompanyCode("companyCode");

        BaseContext<UserContext> context = new BaseContext<>();
        context.setUser(userContext);
        context.setSessionId(generateUUID());

        return userSessionCacheService.put(context);
    }

    // generate a UUID not already present in cache as key
    private String generateUUID() {

        BaseContext<UserContext> context;
        String randomSessionId;
        do {
            randomSessionId = UUID.randomUUID().toString();
            context = userSessionCacheService.get(randomSessionId);
        }
        while (context != null);

        logger.debug("Generated session id: " + randomSessionId);

        return randomSessionId;
    }
}
