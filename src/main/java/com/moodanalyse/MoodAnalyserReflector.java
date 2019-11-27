package com.moodanalyse;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {
    public static MoodAnalyser createMoodAnalyse()throws MoodAnalysisException {
        try {
            Class<?> moodAnalyseClass = Class.forName("com.moodanalyse.MoodAnalyser");
            Constructor<?> moodConstructor = null;
            moodConstructor = moodAnalyseClass.getConstructor();
            Object moodObj = null;
            moodObj = moodConstructor.newInstance();
            return (MoodAnalyser) moodObj;
        } catch (ClassNotFoundException | NoSuchMethodException e) {

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MoodAnalyser createMoodAnalyseWithInproperClass() throws MoodAnalysisException {
        try {
            Class<?> moodAnalyseClass = Class.forName("com.moodanalyse.MoodAnalyser11");
            Constructor<?> moodConstructor = null;
            moodConstructor = moodAnalyseClass.getConstructor();
            Object moodObj = null;
            moodObj = moodConstructor.newInstance();
            return (MoodAnalyser) moodObj;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "Please enter the proper class name");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static MoodAnalyser createMoodAnalyseWithImproperMethod() throws MoodAnalysisException {
        try {
            Class<?> moodAnalyseClass = Class.forName("com.moodanalyse.MoodAnalyser");
            Constructor<?> moodConstructor = null;
            moodConstructor = moodAnalyseClass.getConstructor(Integer.class);
            Object moodObj = null;
            moodObj = moodConstructor.newInstance();
            return (MoodAnalyser) moodObj;
        }catch (NoSuchMethodException | ClassNotFoundException   e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "please enter the proper method name");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static MoodAnalyser createMoodAnalyseWithParameter(String message) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyseClass = Class.forName("com.moodanalyse.MoodAnalyser");
            Constructor<?> moodConstructor = null;
            moodConstructor = moodAnalyseClass.getConstructor(String.class);
            Object moodObj = null;
            moodObj = moodConstructor.newInstance(message);
            return (MoodAnalyser) moodObj;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "Please enter the proper class name");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static MoodAnalyser createMoodAnalyseWithParameterWithImproperClassName(String message) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyseClass = Class.forName("com.moodanalyse.MoodAnalyser11");
            Constructor<?> moodConstructor = null;
            moodConstructor = moodAnalyseClass.getConstructor(String.class);
            Object moodObj = null;
            moodObj = moodConstructor.newInstance(message);
            return (MoodAnalyser) moodObj;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "please enter the proper class name");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}