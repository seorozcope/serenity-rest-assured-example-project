package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;

public class UserRegistration implements Question<Boolean> {

    public static UserRegistration wasSuccessful() {
        return new UserRegistration();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse
                (response -> response.statusCode(201)
                        .body("name", is(equalTo("morpheus")))
                        .body("job", is(equalTo("leader")))
                        .body("id", is(Matchers.not(emptyString())))
                        .body("createdAt", is(Matchers.not(emptyString())))
                )
        );
        return true;
    }
}
