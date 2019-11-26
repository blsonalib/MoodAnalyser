package com.moodanalyse;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyseTest
{
    @Test
    public void givenMessage_WhenSad_ShouldReturned()
    {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("I am in Sad Mood");
        Assert.assertEquals("SAD", mood);
    }
    @Test
    public  void givenMessage_WhenHappy_ShouldReturned()
    {
        MoodAnalyser moodAnalyser=new MoodAnalyser();
        String mood=moodAnalyser.analyseMood("I am in Any Mood");
        Assert.assertEquals("HAPPY",mood);
    }
}
