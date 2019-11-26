package com.moodanalyse;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyseTest
{
    @Test
    public void givenMessage_WhenSad_ShouldReturned()
    {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Sad Mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("SAD",mood);
    }
    @Test
    public  void givenMessage_WhenHappy_ShouldReturned()
    {
        MoodAnalyser moodAnalyser=new MoodAnalyser("I am in Happy Mood");
        String mood=moodAnalyser.analyseMood();
        Assert.assertEquals("HAPPY",mood);
    }

}
