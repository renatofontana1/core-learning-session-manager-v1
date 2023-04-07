package com.accenture.ada.sessionManager.sessionmanager.command;


import com.accenture.ada.baseapp.command.BaseCommand;
import com.accenture.ada.baseapp.model.BaseContext;
import com.accenture.ada.baseapp.model.UserContext;
import com.accenture.ada.sessionManager.sessionmanager.exception.SessionNotFoundException;
import com.accenture.ada.sessionManager.sessionmanager.service.UserSessionCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class GetSessionCommand extends BaseCommand<BaseContext<UserContext>> {

    private String sessionId;

    @Autowired
    private UserSessionCacheService userSessionCacheService;

    public GetSessionCommand(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    protected BaseContext<UserContext> doExecute() {

        BaseContext<UserContext> sessionContext = userSessionCacheService.get(sessionId);

        if (sessionContext == null)
            throw new SessionNotFoundException(sessionId);

        return sessionContext;

    }

}
