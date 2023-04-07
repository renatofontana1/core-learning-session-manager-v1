package com.accenture.ada.sessionManager.sessionmanager.resource;

import com.accenture.ada.baseapp.model.UserContext;
import com.accenture.ada.baseapp.resource.BaseResource;
import lombok.Data;

@Data
public class ContextResource extends BaseResource {

    private String sessionId;
    private UserContext user;

}
