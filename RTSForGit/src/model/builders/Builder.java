/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.builders;

import ressources.definitions.BuilderLibrary;
import ressources.definitions.DefElement;
import ressources.definitions.Definition;
import tools.LogUtil;

/**
 *
 * @author Benoît
 */
public class Builder {
    protected Definition def;
    protected BuilderLibrary lib;
    
    public Builder(Definition def, BuilderLibrary lib){
        this.def = def;
        this.lib = lib;
    }    
    
    public String getId(){
        return def.id;
    }
    
    public void printUnknownElement(String elementName){
        LogUtil.logger.warning("Element '"+elementName+"' unknown in definition '"+getId()+"'.");
    }
    
    public void printUnknownArgument(String elementName, String argumentName){
        LogUtil.logger.warning("Argument '"+argumentName+"' unknown for element '"+elementName+"' in definition '"+getId()+"'.");
    }

    public void printUnknownValue(String elementName, String value){
        LogUtil.logger.warning("value '"+value+"' unknown for element '"+elementName+"' in definition '"+getId()+"'.");
    }
}