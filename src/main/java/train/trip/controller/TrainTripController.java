package train.trip.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import train.trip.dto.ScheduleListDto;
import train.trip.form.TrainTripForm;
import train.trip.mbg.entity.TrainTrip;
import train.trip.service.TrainTripService;
import train.trip.util.Util;

@Controller
@RequestMapping("/train-trip")
public class TrainTripController {
	
	@Autowired
	private TrainTripService service;
	
	@ModelAttribute("trainForm")
	public TrainTripForm setForm() {
		return new TrainTripForm();
	}

	@RequestMapping("/")
	public String index(Model model) {
		return top(model);
	}
	@RequestMapping(value= "/add-conf", params="back")
	public String backA(Model model) {
		return top(model);
	}
	@RequestMapping(value= {"/edit-conf"}, params="back")
	public String backE(Model model) {
		return top(model);
	}
	
	@RequestMapping("/add-input")
	public String addInput() {
		return "trainTrip/add";
	}

	@RequestMapping("/add-conf")
	public String addConf(@Validated @ModelAttribute("trainForm") TrainTripForm form, BindingResult rs) {
		if (rs.hasErrors()) {
			return "trainTrip/add";
		}
		return "trainTrip/addConf";
	}
	
	@RequestMapping(value="/add-done", params="back")
	public String insertBack(@ModelAttribute("trainForm") TrainTripForm form) {
		return "trainTrip/add";
	}

	@RequestMapping(value="/add-done", params="done")
	public String insertDone(@ModelAttribute("trainForm") TrainTripForm form, Model model) {
		ModelMapper modelMapper = new ModelMapper();
		TrainTrip entity = modelMapper.map(form, TrainTrip.class);
		
		try {
			service.add(entity);
			
		} catch (Exception e) {
			model.addAttribute("err", ExceptionUtils.getStackTrace(e));
			return "error";
		}

		return "redirect:/train-trip/add-end";
	}
	
	@RequestMapping("/add-end")
	public String addEnd() {
		return "trainTrip/done";
	}

	@RequestMapping("edit")
	public String editInput(@RequestParam("id") Integer id, Model model) {
		TrainTrip entity = service.get(id);
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addConverter(Util.cnvDateToString());
		TrainTripForm form = modelMapper.map(entity, TrainTripForm.class);
		model.addAttribute("trainForm", form);
		return "trainTrip/edit";
	}
	
	@RequestMapping("/edit-conf")
	public String editConf(@Validated @ModelAttribute("trainForm") TrainTripForm form, BindingResult rs) {
		if (rs.hasErrors()) {
			return "trainTrip/edit";
		}
		return "trainTrip/editConf";
	}
	
	@RequestMapping(value="/edit-done", params="back")
	public String editBack(@ModelAttribute("trainForm") TrainTripForm form) {
		return "trainTrip/edit";
	}

	@RequestMapping(value="/edit-done", params="done")
	public String editDone(@ModelAttribute("trainForm") TrainTripForm form, Model model) {
		ModelMapper modelMapper = new ModelMapper();
		TrainTrip entity = modelMapper.map(form, TrainTrip.class);
		
		try {
			service.edit(entity);
			
		} catch (Exception e) {
			model.addAttribute("err", ExceptionUtils.getStackTrace(e));
			return "error";
		}

		return "redirect:/train-trip/edit-end";
	}
	
	@RequestMapping("/edit-end")
	public String editEnd() {
		return "trainTrip/done";
	}

	@RequestMapping("/view")
	public String noteShow(@RequestParam("id") Integer id, @RequestParam("dayNumber") Integer dayNumber, Model model) {
		Integer max = service.getMaxDayNumber(id);
		List<ScheduleListDto> list = new ArrayList<>();
		service.getScheduleList(list, id, dayNumber);
		String currentDay = service.getCurrentDay(id, dayNumber);

		model.addAttribute("dayNumber", dayNumber);
		model.addAttribute("currentDay", currentDay);
		model.addAttribute("max", max);
		model.addAttribute("entity", service.get(id));
		model.addAttribute("list", list);
		return "trainTrip/view";
	}
	
	private String top(Model model) {
		List<TrainTrip> list = service.getList();
		model.addAttribute("list", list);
		return "trainTrip/index";
	}
}

