package com.accenture.ada.sessionManager.sessionmanager.controller;

import com.accenture.ada.baseapp.controller.StatelessController;
import com.accenture.ada.baseapp.model.BaseContext;
import com.accenture.ada.baseapp.model.UserContext;
import com.accenture.ada.sessionManager.sessionmanager.assembler.ContextResourceAssembler;
import com.accenture.ada.sessionManager.sessionmanager.assembler.SessionIdResourceAssembler;
import com.accenture.ada.sessionManager.sessionmanager.command.CreateSessionCommand;
import com.accenture.ada.sessionManager.sessionmanager.command.GetSessionCommand;
import com.accenture.ada.sessionManager.sessionmanager.command.RemoveSessionCommand;
import com.accenture.ada.sessionManager.sessionmanager.resource.ContextResource;
import com.accenture.ada.sessionManager.sessionmanager.resource.SessionIdResource;
import com.accenture.ada.sessionManager.sessionmanager.dto.CreateSessionDto;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
public class SessionManagerController extends StatelessController {

    @Autowired
    private BeanFactory beanFactory;

    @PostMapping("/sessions")
    public ResponseEntity<SessionIdResource> createSession(@RequestBody CreateSessionDto dto) throws Exception {

        CreateSessionCommand command = beanFactory.getBean(CreateSessionCommand.class, dto.getId());

        SessionIdResourceAssembler assembler = new SessionIdResourceAssembler();

        SessionIdResource resource = assembler.toModel(command.execute());

        return ResponseEntity.status(HttpStatus.CREATED).body(resource);
    }


    @GetMapping("/sessions/{sessionId}")
    public ResponseEntity<ContextResource> getSession(@PathVariable(value = "sessionId") String sessionId) throws Exception {

        GetSessionCommand command = beanFactory.getBean(GetSessionCommand.class, sessionId);

        BaseContext<UserContext> context = command.execute();

        ContextResourceAssembler assembler = new ContextResourceAssembler();

        return ResponseEntity.ok(assembler.toModel(context));
    }

    @DeleteMapping("/sessions/{sessionId}")
    public ResponseEntity<Void> removeSession(@PathVariable(value = "sessionId") String sessionId) throws Exception {

        RemoveSessionCommand removeSessionCommand = beanFactory.getBean(RemoveSessionCommand.class, sessionId);

        removeSessionCommand.execute();

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
