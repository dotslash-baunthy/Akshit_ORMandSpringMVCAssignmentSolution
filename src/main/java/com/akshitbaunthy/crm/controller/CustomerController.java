package com.akshitbaunthy.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akshitbaunthy.crm.entity.Customer;
import com.akshitbaunthy.crm.service.CustomerService;

@Controller
@RequestMapping("/crm")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// Endpoint to get all customer in the table
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.getAll();

		model.addAttribute("Customers", customers);

		return "list-Customers";
	}

	// Endpoint to show form for inserting new customer
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// Get the customer from the service

		Customer customer = new Customer();
		// Set customer as a model attribute to pre-populate the form
		theModel.addAttribute("Customer", customer);

		// Send over to customer form
		return "Customer-form";
	}

	// Endpoint to show form for updating old customer
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {

		// Get the Customer from the service
		Customer fetchedCustomer = customerService.getById(id);

		// Set Customer as a model attribute to pre-populate the form
		model.addAttribute("Customer", fetchedCustomer);

		// Send over to customer form
		return "Customer-form";
	}

	// Endpoint for updating old customer or inserting old customer based on whether the ID passed in the argument is 0 or not
	@PostMapping("/insert")
	public String insertCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		Customer fetchedCustomer;
		
		if (id != 0) {
			fetchedCustomer = customerService.getById(id);
			fetchedCustomer.setFirstName(firstName);
			fetchedCustomer.setLastName(lastName);
			fetchedCustomer.setEmail(email);
		} else
			fetchedCustomer = new Customer(firstName, lastName, email);
		// Save the customer
		customerService.insert(fetchedCustomer);

		// Use a redirect to prevent duplicate submissions
		return "redirect:/crm/list";

	}

	// Endpoint for deleting existing customer
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {

		// Delete the Customer
		customerService.delete(id);

		// Redirect to /crm/list
		return "redirect:/crm/list";

	}

}
