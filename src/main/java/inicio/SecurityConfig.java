package inicio;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // Nos indica que se trata de una clase de configuración de Seguridad
@Configuration // es una clase de configuración que va a ser consultada por Spring al iniciarse
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override // este objeto es proporcionado por el servicio de seguridad de Spring
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Definimos cuales son los usuarios que vamos a tener en el servicio web y los vamos a almacenar en memoria
		auth.inMemoryAuthentication()
		.withUser("username1")
			.password("{noop}user1")
			.roles("USER")
			.and()
		.withUser("admin")
			.password("{noop}admin")
			.roles("USER","ADMIN")
			.and();
		
		// Otra opción es tener los usuarios en una base de datos
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST,"/contactos").hasRole("ADMIN")
		.antMatchers("/contactos").authenticated()
		.and()
		.httpBasic();
	}
}
