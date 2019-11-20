package com.forest.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("supplier")
public class SupplierAction {
	
	@RequestMapping("/toSupplier")
	public String toSupplier() {
		return "d_commodity_supplier";
	}
}
