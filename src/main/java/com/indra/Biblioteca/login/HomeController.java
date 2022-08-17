/**
 * 
 */
package com.indra.Biblioteca.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author aocarballo
 *
 */
@Controller
public class HomeController {
	@RequestMapping("/home")
    public String goHome() {
        return "index";
    }
}