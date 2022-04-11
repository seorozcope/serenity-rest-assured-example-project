package tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Register implements Task {
    public static Register aUser() {
        return instrumented(Register.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/users")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("{" +
                                        "    \"name\": \"morpheus\"," +
                                        "    \"job\": \"leader\"\n" +
                                        "}")
                        )
        );
        String id= SerenityRest.lastResponse().jsonPath().get("id");
        actor.remember("userId", id);
    }
}
