package stepsdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.util.EnvironmentVariables;
import questions.DeletedUser;
import questions.UserRegistration;
import tasks.DeleteUser;
import tasks.Register;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UsersStepsDefinition {

    @Given("the {word} wants to register a single user")
    public void theSysAdminWantsToRegisterASingleUser(String actor) {
        theActorCalled(actor).entersTheScene();
    }

    @When("the SysAdmin attempts to request user registration providing all required data")
    public void theSysAdminAttemptsToRequestUserRegistrationProvidingAllRequiredData() {
        theActorInTheSpotlight().attemptsTo(Register.aUser());
    }

    @Then("SysAdmin should receive a successful response")
    public void sysAdminShouldReceiveASuccessfulResponse() {
        theActorInTheSpotlight().should(seeThat(UserRegistration.wasSuccessful()));
    }

    @When("the SysAdmin attempts to request user registration missing all required data")
    public void theSysAdminAttemptsToRequestUserRegistrationMissingAllRequiredData() {
    }
    @Then("SysAdmin should receive a bad request response")
    public void sysAdminShouldReceiveABbadRequestResponse() {
    }

    @Given("the SysAdmin wants to create a single user")
    public void theSysAdminWantsToCreateASingleUser() {
    }
    @When("the SysAdmin attempts to request user creation providing all user data")
    public void theSysAdminAttemptsToRequestUserCreationProvidingAllUserData() {
    }
    @Then("SysAdmin should receive a user created successful response")
    public void sysAdminShouldReceiveAUserCreatedSuccessfulResponse() {
    }

    @Given("the SysAdmin wants to update all data for a single user")
    public void theSysAdminWantsToUpdateAllDataForASingleUser() {
    }
    @When("the SysAdmin attempts to request user update providing all user data")
    public void theSysAdminAttemptsToRequestUserUpdateProvidingAllUserData() {
    }

    @Given("the SysAdmin wants to update some data for a single user")
    public void theSysAdminWantsToUpdateSomeDataForASingleUser() {
    }
    @When("the SysAdmin attempts to request user update providing some user data")
    public void theSysAdminAttemptsToRequestUserUpdateProvidingSomeUserData() {
    }
    @Then("SysAdmin should receive a user updated successful response")
    public void sysAdminShouldReceiveAUserUpdatedSuccessfulResponse() {
    }

    @Given("the {word} wants to delete a single user")
    public void theSysAdminWantsToDeleteASingleUser(String actor) {
        theActorCalled(actor).entersTheScene();
        theActorInTheSpotlight().attemptsTo(Register.aUser());
    }
    @When("the SysAdmin attempts to request user deletion providing user id")
    public void theSysAdminAttemptsToRequestUserDeletionProvidingUserId() {
        theActorInTheSpotlight().attemptsTo(DeleteUser.byId());
    }
    @Then("SysAdmin should not be able to request for that user again")
    public void sysAdminShouldNotBeAbleToRequestForThatUserAgain() {
        theActorInTheSpotlight().should(seeThat(DeletedUser.shouldNotExist()));
    }
}