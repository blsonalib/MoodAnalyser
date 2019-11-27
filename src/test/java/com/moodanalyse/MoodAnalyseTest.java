package com.moodanalyse;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.text.AbstractDocument;

public class MoodAnalyseTest
{
    @Test
    public void givenMessage_WhenSad_ShouldReturned()
    {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Sad Mood");
        String mood = null;
        try
        {
            mood = moodAnalyser.analyseMood();
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals("SAD", mood);
        }
    }

    @Test
    public void givenMessage_WhenHappy_ShouldReturned()
    {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Happy Mood");
        String mood = null;
        try
        {
            mood = moodAnalyser.analyseMood();
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals("HAPPY", mood);
        }
    }

    @Test
    public void givenMessage_NullMood_WhenHappy_ShouldReturned()
    {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        String mood = null;
        try
        {
            mood = moodAnalyser.analyseMood("Im am in Happy Mood");
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals("HAPPY", mood);
        }
    }

    @Test
    public void givenMessage_whenthemoodnull_InMoodAnalyseException_shouldReturnHappy()
    {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try
        {
            String mood = moodAnalyser.analyseMood(null);
        } catch (MoodAnalysisException e)
        {
            Assert.assertEquals("please enter proper message", e.getMessage());
        }
    }

    @Test
    public void gitvenNullMoodShouldThrowException()
    {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try
        {
            moodAnalyser.analyseMood(null);
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL, e.type);
        }
    }
    @Test
    public void givenMessage_CheckToObjectAreEqual()
    {
        MoodAnalyser moodAnalyser = null;
        boolean Result = false;
        try
        {
            moodAnalyser = MoodAnalyserFactory.createMoodAnalyse();
            Result = moodAnalyser.equals(new MoodAnalyser("I am in a Happy"));
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(false, Result);
        }

    }
    @Test
    public void givenMessage_WhenNotproperClass_ShouldReturn_NoSuchClass_WithParameters()
    {
        MoodAnalyser moodAnalyser=null;
        try
        {
            moodAnalyser = MoodAnalyserFactory.createMoodAnalyse();
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals("Please enter the proper class name",e.getMessage());
        }
    }
    @Test
    public void givenMessage_WhenNotproperMethod_ShouldReturn_NoSuchMethod_WithParameters()
    {
        MoodAnalyser moodAnalyser=null;
        try
        {
            moodAnalyser = MoodAnalyserFactory.createMoodAnalyseWithParameter("I am in Happy Mood");
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals("please enter the proper method name",e.getMessage());
        }
    }
}

