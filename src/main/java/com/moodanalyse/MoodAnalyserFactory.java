package com.moodanalyse;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory
{
    public static MoodAnalyser createMoodAnalyse(String message)
    {
        try {
            Class<?>moodAnalyseClass=Class.forName("com.moodanalyse.MoodAnalyser");
            Constructor<?> moodConstructor= null;
            try
            {
                moodConstructor = moodAnalyseClass.getConstructor(String.class);
            }
            catch (NoSuchMethodException e)
            {
                e.printStackTrace();
            }
            Object moodObj= null;
            try
            {
                moodObj = moodConstructor.newInstance(message);
            }
            catch (InstantiationException e)
            {
                e.printStackTrace();
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
            catch (InvocationTargetException e)
            {
                e.printStackTrace();
            }
            return (MoodAnalyser)moodObj;
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}




