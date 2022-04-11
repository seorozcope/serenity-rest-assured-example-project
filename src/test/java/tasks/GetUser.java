package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUser implements Task {
    private final String userId;

    public GetUser(String userId) {
        this.userId = userId;
    }

    public static GetUser byId(String userId) {
        return instrumented(GetUser.class, userId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource("/users/{id}").with(request ->
                request.header("Content-Type", "application/json")
                        .pathParam("id",userId)));
    }
}
