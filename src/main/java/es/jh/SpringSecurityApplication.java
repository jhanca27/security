package es.jh;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.jh.persistence.entity.PermissionEntity;
import es.jh.persistence.entity.RoleEnum;
import es.jh.persistence.entity.RolesEntity;
import es.jh.persistence.entity.UserEntity;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init() {
		return arg ->{
			PermissionEntity createPermissionEntity = PermissionEntity.builder()
					.name("CREATE")
					.build();
			
			PermissionEntity readPermissionEntity = PermissionEntity.builder()
					.name("READ")
					.build();
			
			PermissionEntity updatePermissionEntity = PermissionEntity.builder()
					.name("UPDATE")
					.build();
			
			PermissionEntity deletePermissionEntity = PermissionEntity.builder()
					.name("DELETE")
					.build();
			
			PermissionEntity refactorPermissionEntity = PermissionEntity.builder()
					.name("REFACTOR")
					.build();
			
			RolesEntity roleAdmin = RolesEntity.builder()
					.role(RoleEnum.ADMIN)
					.permissionsList(Set.of(createPermissionEntity, readPermissionEntity, updatePermissionEntity, deletePermissionEntity))
					.build();
			
			RolesEntity roleUser = RolesEntity.builder()
					.role(RoleEnum.USER)
					.permissionsList(Set.of(createPermissionEntity, readPermissionEntity))
					.build();
			
			RolesEntity roleInvited = RolesEntity.builder()
					.role(RoleEnum.INVITED)
					.permissionsList(Set.of(readPermissionEntity))
					.build();
			
			RolesEntity roleDeveloper = RolesEntity.builder()
					.role(RoleEnum.DEVELOPER)
					.permissionsList(Set.of(createPermissionEntity, readPermissionEntity, updatePermissionEntity, deletePermissionEntity, refactorPermissionEntity))
					.build();
			
			UserEntity  userJhan = UserEntity.builder()
					.username("jhan")
					.password("1234")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLoked(true)
					.credentialNoExpired(true)
					.rolesList(Set.of(roleDeveloper))
					.build();
		};
	}
	
	

}
