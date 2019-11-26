package com.moodanalyse;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory
{
    public static MoodAnalyser createMoodAnalyse(String message) throws MoodAnalysisException
    {
        try {
            Class<?>moodAnalyseClass=Class.forName("com.moodanalyse.MoodAnalyser");
            Constructor<?> moodConstructor= null;
            try
            {
                moodConstructor = moodAnalyseClass.getConstructor(Integer.class);
            }
            catch (NoSuchMethodException e)
            {
               throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,"please enter the proper method name");
            }
            Object moodObj= null;
            try
            {
                moodObj = moodConstructor.newInstance();
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
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,"Please enter the proper class name");
        }
    }
}




