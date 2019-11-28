package com.moodanalyse;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector
{
    public static Constructor<?> getConstructor(Class<?>... param) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.moodanalyse.MoodAnalyser");
            try {
                return moodAnalyserClass.getConstructor(param);
            } catch (NoSuchMethodException e) {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Define proper name method");
            }
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "please enter the proper class name");
        }
    }

    public static Object createMoodAnalyser(Constructor<?> constructor, Object... message) throws MoodAnalysisException {
        try {
            return constructor.newInstance(message);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.No_ACCESS, "Mey be illegal access issue", e);
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.OBJECT_CREATION_ISSUE, "Mey be invocation issue", e);
        }
        return null;
    }
    public static Object invokeMethod(Object moodAnalyserObject,String methodName) throws MoodAnalysisException
    {
        try
        {
            return moodAnalyserObject.getClass().getMethod(methodName).invoke(moodAnalyserObject);
        }
        catch (NoSuchMethodException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Define proper name method");
        }
        catch (IllegalAccessException  e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.No_ACCESS, "Mey be illegal access issue",e);
        }
        catch (InvocationTargetException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSUE, "Mey be invocation issue",e);
        }
    }
    public static void setFieldValue(Object myObject, String fieldName, String fieldValue ) throws MoodAnalysisException
    {
        try
        {
            Field field=myObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            try
            {
                field.set(myObject,fieldValue);
            } catch (IllegalAccessException e)
            {
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.No_ACCESS, "Mey be invocation issue",e);
            }
        }
        catch (NoSuchFieldException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.No_SUCH_FIELD, "Define proper field name",e);
        }
    }
}
