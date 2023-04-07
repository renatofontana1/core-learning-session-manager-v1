package com.accenture.ada.sessionManager.sessionmanager.resource;

import com.accenture.ada.baseapp.resource.BaseResource;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SessionIdResource extends BaseResource {
    private String sessionId;
}
