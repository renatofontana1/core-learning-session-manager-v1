package com.accenture.ada.sessionManager.sessionmanager.assembler;

import com.accenture.ada.baseapp.assembler.BaseResourceAssemblerSupport;
import com.accenture.ada.baseapp.model.BaseContext;
import com.accenture.ada.baseapp.model.UserContext;
import com.accenture.ada.sessionManager.sessionmanager.controller.SessionManagerController;
import com.accenture.ada.sessionManager.sessionmanager.resource.ContextResource;

public class ContextResourceAssembler extends BaseResourceAssemblerSupport<BaseContext<UserContext>, ContextResource> {

    public ContextResourceAssembler() {
        super(SessionManagerController.class, ContextResource.class);
    }

    @Override
    public ContextResource toModel(BaseContext<UserContext> entity) {
        ContextResource resource = new ContextResource();
        resource.setSessionId(entity.getSessionId());
        resource.setUser(entity.getUser());
        return resource;
    }
}
