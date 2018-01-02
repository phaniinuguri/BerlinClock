package com.hcl.interviews;

import static com.hcl.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Before;
import org.junit.Test;

import com.hcl.interviews.main.BerlinClockCore;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing stories.  
 * You will notice the TimeConverter has no implementation ... (hint)
 */
public class BerlinClockFixture {

    //private TimeConverter berlinClock;
    private String theTime;
    //Changed slight implemenation.Creating a reference from where core logic will start
    private BerlinClockCore coreInstance;
    
    @Before
    public void setUp(){
    	//Used Singleton pattern and within for various time unit calculation used factory pattern.
    	coreInstance = BerlinClockCore.getInstance();
    }
    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock.story")
                .run();
    }

    @When("the time is $time")
    public void whenTheTimeIs(String time) {
        theTime = time;
    }

    @Then("the clock should look like $")
    public void thenTheClockShouldLookLike(String theExpectedBerlinClockOutput) throws InstantiationException, IllegalAccessException {
    	/*assertThat(berlinClock.convertTime(theTime)).isEqualTo(theExpectedBerlinClockOutput);*/
    	assertThat(coreInstance.showBerlinClockTime(theTime)).isEqualTo(theExpectedBerlinClockOutput);
    }
    
}
