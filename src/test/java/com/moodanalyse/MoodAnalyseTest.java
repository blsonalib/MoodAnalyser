package com.moodanalyse;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyseTest
{
    @Test
    public void givenMessage_WhenSad_ShouldReturned()
    {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("This is a sad Message");
        Assert.assertEquals("SAD", mood);
    }
}
