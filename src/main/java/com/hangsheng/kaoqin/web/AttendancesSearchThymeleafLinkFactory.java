package com.hangsheng.kaoqin.web;
import io.springlets.web.mvc.util.SpringletsMvcUriComponentsBuilder;
import java.util.Map;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooLinkFactory;
import org.springframework.web.util.UriComponents;

/**
 * = AttendancesSearchThymeleafLinkFactory
 TODO Auto-generated class documentation
 *
 */
@RooLinkFactory(controller = AttendancesSearchThymeleafController.class)
public class AttendancesSearchThymeleafLinkFactory {

	/**
     * TODO Auto-generated method documentation
     * 
     * @param methodName
     * @param parameters
     * @param pathVariables
     * @return UriComponents
     */
    public UriComponents toUri(String methodName, Object[] parameters, Map<String, Object> pathVariables) {
    	System.out.println(methodName);
    	System.out.println(parameters);
    	System.out.println(pathVariables);
        if (methodName.equals(STATSIGNINAFTERANDSIGNOUTBEFOREFORM)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).statSignInAfterAndSignOutBeforeForm(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(STATSIGNINAFTERANDSIGNOUTBEFORE)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).statSignInAfterAndSignOutBefore(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(BYSIGNINAFTERANDSIGNOUTBEFOREFORM)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).bySignInAfterAndSignOutBeforeForm(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(BYSIGNINAFTERANDSIGNOUTBEFORE)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).bySignInAfterAndSignOutBefore(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(BYSIGNINAFTERANDSIGNOUTBEFOREDT)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).bySignInAfterAndSignOutBeforeDt(null, null, null, null, null)).buildAndExpand(pathVariables);
        }
        throw new IllegalArgumentException("Invalid method name: " + methodName);
    }
}
