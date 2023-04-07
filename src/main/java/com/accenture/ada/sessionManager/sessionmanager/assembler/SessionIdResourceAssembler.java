package com.accenture.ada.sessionManager.sessionmanager.assembler;

import com.accenture.ada.baseapp.assembler.BaseResourceAssemblerSupport;
import com.accenture.ada.baseapp.model.BaseContext;
import com.accenture.ada.baseapp.model.UserContext;
import com.accenture.ada.sessionManager.sessionmanager.controller.SessionManagerController;
import com.accenture.ada.sessionManager.sessionmanager.resource.SessionIdResource;

public class SessionIdResourceAssembler extends BaseResourceAssemblerSupport<BaseContext<UserContext>, SessionIdResource> {

    public SessionIdResourceAssembler() {
        super(SessionManagerController.class, SessionIdResource.class);
    }

    @Override
    public SessionIdResource toModel(BaseContext<UserContext> entity) {
        return new SessionIdResource(entity.getSessionId());
    }
}
