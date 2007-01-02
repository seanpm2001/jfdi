package org.codehaus.jfdi.interpreter;

import java.util.HashMap;
import java.util.Map;

public class DefaultValueHandlerFactory extends AbstractValueHandlerFactory {
    
    public Map variables;       
    
    public DefaultValueHandlerFactory(TypeResolver typeResolver) {
        super( typeResolver );
   }
    
    public DefaultValueHandlerFactory(TypeResolver typeResolver, HashMap variables) {
        super( typeResolver );
        this.variables = variables;
   }    
    
    public void setVariables(Map variables) {
        this.variables = variables;
    }

    public void addVariable(String identifier,
                            Object instance) {
        this.variables.put( identifier,
                            instance );
    }

    public ValueHandler createExternalVariable(String identifier) {        
        registerExternalVariable( identifier );
        
        VariableValueHandler handler = new DefaultExternalVariable( identifier,
                                                                    this.variables );
                
        return handler;
    }

    public boolean isValidVariable(String identifier) {        
        return variables.containsKey( identifier );
    }    
}
