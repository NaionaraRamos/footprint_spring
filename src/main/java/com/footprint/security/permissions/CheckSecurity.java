//package com.footprint.security.permissions;
//
//import static java.lang.annotation.ElementType.METHOD;
//import static java.lang.annotation.RetentionPolicy.RUNTIME;
//import java.lang.annotation.Retention;
//import java.lang.annotation.Target;
//import org.springframework.security.access.prepost.PreAuthorize;
//
//public class CheckSecurity {
//	public @interface User {
//	
//		@PreAuthorize("isAuthenticated() and " +
//				"hasAuthority('ADMIN')")
//		@Retention(RUNTIME)
//		@Target(METHOD)
//		public @interface CanInsertQuestion {
//		}
//
//		@PreAuthorize("isAuthenticated() and " +
//				"hasAuthority('USER')")
//		@Retention(RUNTIME)
//		@Target(METHOD)
//		public @interface CanDoWhateverLessInsertQuestion {
//		}	
//	}
//}