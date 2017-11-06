// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.hangsheng.kaoqin.web;

import com.hangsheng.kaoqin.web.StaffsItemThymeleafController;
import com.hangsheng.kaoqin.web.StaffsItemThymeleafLinkFactory;
import io.springlets.web.mvc.util.MethodLinkFactory;
import io.springlets.web.mvc.util.SpringletsMvcUriComponentsBuilder;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

privileged aspect StaffsItemThymeleafLinkFactory_Roo_LinkFactory {
    
    declare parents: StaffsItemThymeleafLinkFactory implements MethodLinkFactory<StaffsItemThymeleafController>;
    
    declare @type: StaffsItemThymeleafLinkFactory: @Component;
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String StaffsItemThymeleafLinkFactory.SHOW = "show";
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String StaffsItemThymeleafLinkFactory.SHOWINLINE = "showInline";
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String StaffsItemThymeleafLinkFactory.EDITFORM = "editForm";
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String StaffsItemThymeleafLinkFactory.UPDATE = "update";
    
    /**
     * TODO Auto-generated attribute documentation
     * 
     */
    public static final String StaffsItemThymeleafLinkFactory.DELETE = "delete";
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @return Class
     */
    public Class<StaffsItemThymeleafController> StaffsItemThymeleafLinkFactory.getControllerClass() {
        return StaffsItemThymeleafController.class;
    }
    
    /**
     * TODO Auto-generated method documentation
     * 
     * @param methodName
     * @param parameters
     * @param pathVariables
     * @return UriComponents
     */
    public UriComponents StaffsItemThymeleafLinkFactory.toUri(String methodName, Object[] parameters, Map<String, Object> pathVariables) {
        if (methodName.equals(SHOW)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).show(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(SHOWINLINE)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).showInline(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(EDITFORM)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).editForm(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(UPDATE)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).update(null, null, null, null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(DELETE)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).delete(null)).buildAndExpand(pathVariables);
        }
        throw new IllegalArgumentException("Invalid method name: " + methodName);
    }
    
}