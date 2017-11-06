package com.hangsheng.kaoqin.web;
import com.hangsheng.kaoqin.domain.Staff;
import javax.validation.Valid;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;

/**
 * = StaffsCollectionThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Staff.class, type = ControllerType.COLLECTION)
@RooThymeleaf
public class StaffsCollectionThymeleafController {

	/**
     * TODO Auto-generated method documentation
     * 
     * @param staff
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PostMapping(name = "create")
    public ModelAndView create(@Valid @ModelAttribute Staff staff, BindingResult result, Model model) {
        if (result.hasErrors()) {
            populateForm(model);
            
            return new ModelAndView("staffs/create");
        }
        Staff newStaff = getStaffService().save(staff);
       // UriComponents showURI = getItemLink().to(StaffsItemThymeleafLinkFactory.SHOW).with("staff", newStaff.getId()).toUri();
        return new ModelAndView("redirect:/");
    }

	/**
     * TODO Auto-generated method documentation
     * 
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
    }
}
