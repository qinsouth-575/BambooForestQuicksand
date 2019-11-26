package com.forest.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Bcashier")
public class BcashierAction {
				
				/**
				 * 进入收银页面
				 * @return
				 */
				@RequestMapping("toBcashier")
				public String toBcashier() {
					return "b_cashier";
				}
}
