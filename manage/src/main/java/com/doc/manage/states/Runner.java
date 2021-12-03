package com.doc.manage.states;

import com.doc.manage.states.enums.TaskEvents;
import com.doc.manage.states.enums.TaskStates;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Component;
import com.doc.manage.states.TaskMachineConfig;

@Component
public class Runner implements ApplicationRunner {

    private final StateMachineFactory<TaskStates, TaskEvents> factory;

    Runner(StateMachineFactory<TaskStates, TaskEvents> factory){
        this.factory = factory;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        StateMachine<TaskStates, TaskEvents> machine = this.factory.getStateMachine("111");

    }
}
