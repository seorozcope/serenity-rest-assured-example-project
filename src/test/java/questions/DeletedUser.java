package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import tasks.GetUser;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class DeletedUser implements Question<Boolean> {
    public static DeletedUser shouldNotExist() {
        return new DeletedUser();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse("deletion should return successful result status code", response -> response.statusCode(204) ));
        String userId = actor.recall("userId");
        actor.attemptsTo(GetUser.byId(userId));
        actor.should(seeThatResponse("expected user should not exist", response -> response.statusCode(404) ));
        return true;
    }
}
