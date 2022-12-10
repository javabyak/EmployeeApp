package in.nareshit.raghu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.nareshit.raghu.entity.Employee;
import in.nareshit.raghu.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private IEmployeeService service;
   
	
	@GetMapping("/register")
	public String showRegister() {
		return "EmployeeRegister";
	}
	
	/*	@PostMapping("/register")
		public String registerEmployee(@ModelAttribute Employee emp,Model model) {
			 //call service method
			 String msg="Employee Register with id ::"+service.registerEmp(emp);
			 //place result in model attribute
			 model.addAttribute("msg", msg);
			 //return lvn
			return "EmployeeRegister";
		}*/
	/**
	 * using PGR patten we can solve the problem of double saving recored when we apply the refresh button
	 * @param emp
	 * @param attr
	 * @return
	 */
	@PostMapping("/register")
	public String registerEmployee(@ModelAttribute Employee emp,RedirectAttributes attr) {
		 //call service method
		 String msg="Employee Register with id ::"+service.registerEmp(emp);
		 //place result in model attribute
		attr.addFlashAttribute("msg", msg);
		 //return lvn
		return "redirect:register";
	}
	
	@GetMapping("/all")
	public String getAllEmp(Model model) {
		//all service method
		List<Employee> list=service.fetchEmployeeData();
		  list.forEach(System.out::println);
		//place result in model attribute
		model.addAttribute("list", list);
		//result result
		return "EmployeeRecord";
	}
	
	@GetMapping("/delete")
	public String deleteEmpById(@RequestParam Integer id,RedirectAttributes attrs) {
		//call service method
		service.removeEmpById(id);
		//generate msg
		String removedMsg=id+":: id deleted sucessfully";
		//place in model attribute
		attrs.addFlashAttribute("msg",removedMsg);
		//return Lvn
		return "redirect:all";
	}
	
	@GetMapping("/edit")
	public String getEmpByid(@RequestParam Integer id,Model model) {
		//call service method
		Employee empdata=service.getEmpdataBYId(id);
		//place result in model attribute
		model.addAttribute("emp", empdata);
		//return Lvn
		return "EmployeeEdit";
		
	}
	
	@PostMapping("/update" )
	public String UpadateEmpById(@ModelAttribute Employee emp,RedirectAttributes attr) {
		//call service method
		  String msg=service.UpdateEmpdata(emp);
		  //put the result in model attribute
		  attr.addFlashAttribute("msg", msg);
		  //redirect lvn
		  return "redirect:all";
	}
}
