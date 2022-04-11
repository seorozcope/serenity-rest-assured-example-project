package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUser implements Task {

    public static DeleteUser byId() {
        return instrumented(DeleteUser.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String userId = actor.recall("userId");
        actor.attemptsTo(Delete.from("/users/{id}").with(request -> request.header("Content-Type", "application/json")
                .pathParam("id",userId)));
    }
}
