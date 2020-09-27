package com.verizon.lambda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.verizon")
@EnableMongoRepositories("com.verizon")
public class App {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class);
		// IEmployeeService employeeService =
		// context.getBean(IEmployeeService.class);
		// ITeamService teamService = context.getBean(ITeamService.class);
		//
		// String teamID = "ee6";
		//
		// ArrayList<String> members = new ArrayList<String>();
		//
		// members.add("e-5");
		// members.add("e-6");
		//
		// Team t1 = new Team(teamID, "alpha", "e-5", members);
		//
		// Team addedteam = teamService.addTeam(t1);
		//
		// System.out.println("id " + addedteam.getId() + "managerId " +
		// addedteam.getManagerId() + "team name"
		// + addedteam.getTeamName());
		//
		// System.out.println("the members of the team");
		//
		// ArrayList<String> adddedTeamMembers = new ArrayList<String>();
		//
		// adddedTeamMembers = addedteam.getMemberIds();
		//
		// for (String s : adddedTeamMembers) {
		// System.out.println(" the member id is" + s);
		// }
		//
		// ArrayList<String> newMembers = new ArrayList<String>();
		//
		// newMembers.add("11");
		//
		// newMembers.add("22");
		//
		// newMembers.add("55");
		//
		// Team t11 = teamService.addMembers(teamID, newMembers);
		//
		// ArrayList<String> adddedTeamMembers1 = new ArrayList<String>();
		//
		// adddedTeamMembers1 = t11.getMemberIds();
		//
		// for (String s : adddedTeamMembers1) {
		// System.out.println(" the member id is" + s);
		// }
		//
		// /********************
		// * code to remove the members of the list
		// *****************/
		//
		// Team t22 = teamService.deleteMembers(teamID, "55");
		//
		// ArrayList<String> adddedTeamMembers2 = new ArrayList<String>();
		//
		// adddedTeamMembers2 = t22.getMemberIds();
		//
		// for (String s : adddedTeamMembers2) {
		// System.out.println(" the member id is" + s);
		// }
		//
		//
		//
		//
		//
		//// Team t32 = teamService.deleteMembers(teamID, "22");
		////
		//// ArrayList<String> adddedTeamMembers32 = new ArrayList<String>();
		////
		//// adddedTeamMembers32 = t32.getMemberIds();
		////
		//// for (String s : adddedTeamMembers32) {
		//// System.out.println(" the member id is" + s);
		//// }
		//
		// /***************************
		// * code to display the team members
		// ***************/
		//
		// System.out.println("The number of people in the team ");
		//
		// ArrayList<Member> teamMembers = teamService.getTeamMembers(teamID);
		//
		// for (Member m : teamMembers) {
		//
		// System.out.println("The member of the team is");
		//
		// System.out.println(m.getName());
		// System.out.println(m.getDepartment());
		// System.out.println(m.getDesignation());
		//
		// }
		// System.out.println();

	}
}
