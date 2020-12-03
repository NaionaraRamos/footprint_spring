//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

//package com.footprint;
//
//public class Garbage {
//
//}



//		Authentication loggedUser = SecurityContextHolder.getContext().getAuthentication();
//		String auth = request.getUserPrincipal().getName();
//		String nameLoggedUser = loggedUser.getName();
//		System.out.println("auth: " + auth);
//		System.out.println("nameLoggedUser: " + nameLoggedUser);
//		User user = new User();
//		System.out.println("user: " + user);
//		user.setName(nameLoggedUser);
		//answerDto.getUser().setName(nameLoggedUser);
		//Long id = answerRequest.getUser().getId();
		//answerRequest.setId(id);
		
//		answerDto.setUser(user);

		
//		FootprintSecurity fs = new FootprintSecurity();
//		System.out.println(fs.getUserId());


//	@GetMapping("/username")
//    @ResponseBody
//    public void currentUserName(Authentication authentication) {
//		System.out.println(authentication.getName());
//      //  return authentication.getName();
//    }
//
//	@GetMapping("/username")
//    @ResponseBody
//    public void currentUserName(HttpServletRequest authentication) {
//		
//		System.out.println(authentication.getUserPrincipal());
      //  return authentication.getName();
   // }