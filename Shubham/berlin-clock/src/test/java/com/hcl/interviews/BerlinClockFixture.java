package com.hcl.interviews;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

import com.hcl.interviews.TimeConverter;

import static com.hcl.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing stories.  
 * You will notice the TimeConverter has no implementation ... (hint)
 */
public class BerlinClockFixture {

    private TimeConverter berlinClock;
    private String theTime;

    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock.story")
                .run();
    }

    @When("the time is $time")
    public void whenTheTimeIs(String time) {
        
    }

    @Then("the clock should look like $")
    public void thenTheClockShouldLookLike(String theExpectedBerlinClockOutput) {
    	
    }
}
