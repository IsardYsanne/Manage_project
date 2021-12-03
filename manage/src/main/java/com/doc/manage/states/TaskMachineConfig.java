package com.doc.manage.states;

import com.doc.manage.states.enums.TaskEvents;
import com.doc.manage.states.enums.TaskStates;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

@Configuration
@EnableStateMachineFactory
public class TaskMachineConfig extends StateMachineConfigurerAdapter<TaskStates, TaskEvents> {

    @Override
    public void configure(StateMachineTransitionConfigurer<TaskStates, TaskEvents> transitions) throws Exception {
        transitions
                .withExternal().source(TaskStates.PREPARED).target(TaskStates.COMPLETED).event(TaskEvents.EXECUTION)
                .and()
                .withExternal().source(TaskStates.COMPLETED).target(TaskStates.MONITORED).event(TaskEvents.CONTROL)
                .and()
                .withExternal().source(TaskStates.MODIFIED).target(TaskStates.COMPLETED).event(TaskEvents.CONTROL)
                .and()
                .withExternal().source(TaskStates.COMPLETED).target(TaskStates.MONITORED).event(TaskEvents.CONTROL)
                .and()
                .withExternal().source(TaskStates.MONITORED).target(TaskStates.ACCEPTED).event(TaskEvents.RECEPTION);

    }

    @Override
    public void configure(StateMachineStateConfigurer<TaskStates, TaskEvents> states) throws Exception {
        states
                .withStates()
                .initial(TaskStates.PREPARED)
                .state(TaskStates.COMPLETED)
                .state(TaskStates.MONITORED)
                .state(TaskStates.MODIFIED)
                .end(TaskStates.ACCEPTED);
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<TaskStates, TaskEvents> config) throws Exception {
        StateMachineListenerAdapter<TaskStates, TaskEvents> adapter = new StateMachineListenerAdapter<TaskStates, TaskEvents>(){
            @Override
            public void stateChanged(State<TaskStates, TaskEvents> from, State<TaskStates, TaskEvents> to) {

            }
        };
        config.withConfiguration().autoStartup(false).listener(adapter);
    }
}
