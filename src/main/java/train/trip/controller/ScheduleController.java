package train.trip.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import train.trip.form.ActionForm;
import train.trip.form.DepArrInfoForm;
import train.trip.mbg.entity.DepArrInfo;
import train.trip.service.ScheduleService;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	private ScheduleService service;
	
	@ModelAttribute("daiForm")
	public DepArrInfoForm setForm() {
		return new DepArrInfoForm();
	}
	
	@ModelAttribute("actionForm")
	public ActionForm setActionForm() {
		return new ActionForm();
	}
	
	@RequestMapping(value="/add-input", params="train-info")
	public String insertTrainInput(Model model, 
			@ModelAttribute("daiForm") DepArrInfoForm form, 
			@RequestParam("train-trip-id") String trainTripId, 
			@RequestParam("day-number") String strDayNumber) {
		int id = Integer.parseInt(trainTripId);
		int dayNumber = Integer.parseInt(strDayNumber);
		form.setTrainTripId(id);
		form.setDayNumber(dayNumber);
		model.addAttribute("next", service.getNextDayNumber(id));
		return "schedule/add";
	}
	
	@RequestMapping(value= "/add-conf", params="back")
	public String back(RedirectAttributes redirectAttribute,
			@RequestParam("trainTripId") String id,
			@RequestParam("dayNumber") String dayNumber) {
		redirectAttribute.addAttribute("id", id);
		redirectAttribute.addAttribute("dayNumber", dayNumber);
		return "redirect:/train-trip/view";
	}
	
	@RequestMapping(value= "/add-conf", params="conf")
	public String insertScheduleConf(@Validated @ModelAttribute("daiForm") DepArrInfoForm form, BindingResult rs) {
		if (rs.hasErrors()) {
			return "schedule/add";
		}
		return "schedule/addConf";
	}
	
	@RequestMapping(value="/add-done", params="back")
	public String insertScheduleBack(@ModelAttribute("daiForm") DepArrInfoForm form) {
		return "schedule/add";
	}

	@RequestMapping(value="/add-done", params="done")
	public String insertScheduleDone(Model model, 
			RedirectAttributes redirectAttribute,
			@ModelAttribute("daiForm") DepArrInfoForm form) {
		try {
			service.addTrainSchedule(form);
			
		} catch (Exception e) {
			model.addAttribute("err", ExceptionUtils.getStackTrace(e));
			return "error";
		}

		redirectAttribute.addFlashAttribute("id", form.getTrainTripId());
		redirectAttribute.addFlashAttribute("dayNumber", form.getDayNumber());
		return "redirect:/schedule/add-end";
	}
	
	@RequestMapping("/add-end")
	public String addEnd() {
		// 引数に設定 @ModelAttribute("trainTripId") Integer trainTripId
		//System.out.println("************************ trainTripId");
		//System.out.println(trainTripId);
		return "schedule/done";
	}
	
	
	@RequestMapping(value="/submit-handle", params="delete")
	public String deleteSchedule(Model model, RedirectAttributes redirect,
				@RequestParam("trainTripId") String trainTripId, 
				@RequestParam("scheduleId") String scheduleId, 
				@RequestParam("dayNumber") String dayNumber) {
		try {
			service.deleteSchedule(Integer.parseInt(scheduleId));
			
		} catch (Exception e) {
			model.addAttribute("err", ExceptionUtils.getStackTrace(e));
			return "error";
		}
		redirect.addAttribute("id", trainTripId);
		redirect.addAttribute("dayNumber", dayNumber);
		
		return "redirect:/train-trip/view";
	}
	
	@RequestMapping(value="/submit-handle", params="event")
	public String addEvent(Model model,
			@RequestParam("trainTripId") String trainTripId, 
			@RequestParam("depArrInfoId") String id,
			@RequestParam("dayNumber") String dayNumber,
			@ModelAttribute("actionForm") ActionForm form) {
		DepArrInfo entity = service.selectDepArrInfo(Integer.parseInt(id));
		form.setTrainTripId(Integer.parseInt(trainTripId));
		form.setDayNumber(Integer.parseInt(dayNumber));
		form.setArrTime(entity.getDepArrTime());
		return "schedule/addAction";
	}
	
	@RequestMapping(value="/add-action-conf", params="back")
	public String backAction(RedirectAttributes redirect,
			@ModelAttribute("actionForm") ActionForm form) {
		redirect.addAttribute("id", form.getTrainTripId());
		redirect.addAttribute("dayNumber", form.getDayNumber());
		return "redirect:/train-trip/view";
	}
	
	@RequestMapping(value="/add-action-conf", params="conf")
	public String addActionConf(@Validated @ModelAttribute("actionForm") ActionForm form, BindingResult rs) {
		if (rs.hasErrors()) {
			return "schedule/addAction";
		}
		return "schedule/addActionConf";
	}
	
	@RequestMapping(value="/add-action-done", params="back")
	public String backActionInput(@ModelAttribute("actionForm") ActionForm form) {
		return "schedule/addAction";
	}

	@RequestMapping(value="/add-action-done", params="done")
	public String insertEventDone(@ModelAttribute("actionForm") ActionForm form, Model model, RedirectAttributes redirect) {
		try {
			service.addActionSchedule(form);
			
		} catch (Exception e) {
			model.addAttribute("err", ExceptionUtils.getStackTrace(e));
			return "error";
		}
		redirect.addAttribute("id", form.getTrainTripId());
		redirect.addAttribute("dayNumber", form.getDayNumber());
		
		return "redirect:/train-trip/view";
	}
}

