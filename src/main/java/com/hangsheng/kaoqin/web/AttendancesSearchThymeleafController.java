package com.hangsheng.kaoqin.web;
import com.hangsheng.kaoqin.domain.Attendance;
import com.hangsheng.kaoqin.domain.AttendanceSignInAndSignOutFormBean;
import com.hangsheng.kaoqin.domain.AttendanceStatBean;
import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.datatables.ConvertedDatatablesData;
import io.springlets.data.web.datatables.Datatables;
import io.springlets.data.web.datatables.DatatablesColumns;
import io.springlets.data.web.datatables.DatatablesPageable;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.finder.RooSearch;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * = AttendancesSearchThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Attendance.class, type = ControllerType.SEARCH)
@RooSearch(finders = { "findBySignInAfterAndSignOutBefore" })
@RooThymeleaf
public class AttendancesSearchThymeleafController {
	/**
    * @param formBean
    * @param model
    * @return ModelAndView
    */
   @GetMapping(name = "statSignInAfterAndSignOutBeforeForm", value = "/statSignInAfterAndSignOutBefore/search-form")
   public ModelAndView statSignInAfterAndSignOutBeforeForm(@ModelAttribute("formBean") AttendanceSignInAndSignOutFormBean formBean, Model model) {
       model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
       model.addAttribute("signIn_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
       model.addAttribute("signOut_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
       return new ModelAndView("attendances/statBySignInAfterAndSignOutBeforeForm");
   }
   
   /**
    * TODO Auto-generated method documentation
    * 
    * @param formBean
    * @param model
    * @return ModelAndView
    */
   @GetMapping(name = "statSignInAfterAndSignOutBefore", value = "/statSignInAfterAndSignOutBefore")
   public ModelAndView statSignInAfterAndSignOutBefore(@ModelAttribute("formBean") AttendanceSignInAndSignOutFormBean formBean, Model model) {
       model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
       model.addAttribute("signIn_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
       model.addAttribute("signOut_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    //   List<Attendance> ads = getAttendanceService().findBySignInAfterAndSignOutBefore(formBean, null, null).getContent();
       List<AttendanceStatBean> asbs = getAttendanceService().statBySignInAfterAndSignOutBefore(formBean);
       model.addAttribute("adstat", asbs);
       return new ModelAndView("attendances/statBySignInAfterAndSignOutBeforeForm");
   }
   

	/**
     * TODO Auto-generated method documentation
     * 
     * @param formBean
     * @param datatablesColumns
     * @param search
     * @param pageable
     * @param draw
     * @return ResponseEntity
     */
    @GetMapping(name = "bySignInAfterAndSignOutBeforeDt", value = "/bySignInAfterAndSignOutBefore/dt", produces = Datatables.MEDIA_TYPE)
    @ResponseBody
    public ResponseEntity<ConvertedDatatablesData<Attendance>> bySignInAfterAndSignOutBeforeDt(@ModelAttribute("formBean") AttendanceSignInAndSignOutFormBean formBean, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam(Datatables.PARAMETER_DRAW) Integer draw) {
    	System.out.println("ResponseEntity bySignInAfterAndSignOutBeforeDt");
        Page<Attendance> attendances = getAttendanceService().findBySignInAfterAndSignOutBefore(formBean,search,pageable);
        long totalAttendancesCount = attendances.getTotalElements();
        if (search != null && StringUtils.isNotBlank(search.getText())) {
            totalAttendancesCount = getAttendanceService().countBySignInAfterAndSignOutBefore(formBean);
        }
        ConvertedDatatablesData<Attendance> datatablesData = new ConvertedDatatablesData<Attendance>(attendances, totalAttendancesCount, draw, getConversionService(), datatablesColumns);
        return ResponseEntity.ok(datatablesData);
    }
}
