package stepsdefinition;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class Hooks {
    private EnvironmentVariables environmentVariables;

    @Before(order = 0)
    public void setup(){
        String theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl").orElse("https://fake.url/api");
        OnStage.setTheStage(OnlineCast.whereEveryoneCan(CallAnApi.at(theRestApiBaseUrl)));
    }

}
