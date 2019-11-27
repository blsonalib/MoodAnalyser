package com.moodanalyse;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyseTest {
    @Test
    public void givenMessage_WhenSad_ShouldReturned() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Sad Mood");
        String mood = null;
        try {
            mood = moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("SAD", mood);
        }
    }

    @Test
    public void givenMessage_WhenHappy_ShouldReturned() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Happy Mood");
        String mood = null;
        try {
            mood = moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("HAPPY", mood);
        }
    }

    @Test
    public void givenMessage_NullMood_WhenHappy_ShouldReturned() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        String mood = null;
        try {
            mood = moodAnalyser.analyseMood("Im am in Happy Mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("HAPPY", mood);
        }
    }

    @Test
    public void givenMessage_whenthemoodnull_InMoodAnalyseException_shouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            String mood = moodAnalyser.analyseMood(null);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("please enter proper message", e.getMessage());
        }
    }

    @Test
    public void gitvenNullMoodShouldThrowException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            moodAnalyser.analyseMood(null);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL, e.type);
        }
    }

    @Test
    public void givenMessage_CheckToObjectAreEqual() {
        MoodAnalyser moodAnalyser = null;
        boolean Result = false;
        try {
            moodAnalyser = MoodAnalyserReflector.createMoodAnalyse();
            Result = moodAnalyser.equals(new MoodAnalyser("I am in a Happy"));
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(false, Result);
        }

    }

    @Test
    public void givenMessage_WhenNotproperClass_ShouldReturn_NoSuchClass_WithParameters() {
        MoodAnalyser moodAnalyser = null;
        try {
            moodAnalyser = MoodAnalyserReflector.createMoodAnalyseWithImproperClass();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Please enter the proper class name", e.getMessage());
        }
    }

    @Test
    public void givenMessage_WhenNotproperMethod_ShouldReturn_NoSuchMethod_WithParameters() {
        MoodAnalyser moodAnalyser = null;
        try {
            moodAnalyser = MoodAnalyserReflector.createMoodAnalyseWithImproperMethod();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("please enter the proper method name", e.getMessage());
        }
    }
    @Test
    public void givenMessage_CheckToObjectAreEqual_WithParameter_ReturnHappyMood() {
        MoodAnalyser moodAnalyser = null;
        boolean Result = false;
        try {
            moodAnalyser = MoodAnalyserReflector.createMoodAnalyseWithParameter("I am in a Happy");
            Result = moodAnalyser.equals(new MoodAnalyser("I am in a Happy"));
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(false, Result);
        }
    }
    @Test
    public void givenMessage_WhenNotproperClass_ShouldReturn_WithParameters() {
        MoodAnalyser moodAnalyser = null;
        try {
            moodAnalyser = MoodAnalyserReflector.createMoodAnalyseWithParameterWithImproperClassName("I am in a Happy");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("please enter the proper class name", e.getMessage());
        }
    }
    @Test
    public void givenMessage_WhenNotproperMethod_ShouldReturn_WithParameters() {
        MoodAnalyser moodAnalyser = null;
        try {
            moodAnalyser = MoodAnalyserReflector.createMoodAnalyseWithParameterWithImproperMethodName("I am in a Happy");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("please enter the proper method name", e.getMessage());
        }
    }
    @Test
    public void givenMessage_withReflection_ShouldReturnHappy() {
        Object myObject = null;
        try {
            myObject = MoodAnalyserReflector.createMoodAnalyseWithParameter1("I am in Happy Mood");
            Object mood = MoodAnalyserReflector.invokeMethod(myObject, "analyseMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenMoodAnalyser_OnChangeMood_ShouldReturnHappy() {
        try {
            Object myObject = MoodAnalyserReflector.createMoodAnalyseWithParameter1(" ");
            MoodAnalyserReflector.setFieldValue(myObject, "message", "I am in Happy Mood");
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }


}


