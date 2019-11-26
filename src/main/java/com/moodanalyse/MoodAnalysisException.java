package com.moodanalyse;

public class MoodAnalysisException extends Exception
{
    enum ExceptionType{
        ENTERED_NULL;
    }
    ExceptionType type;
    public MoodAnalysisException(ExceptionType type,String message)
    {
        super(message);
        this.type=type;
    }
    public MoodAnalysisException(ExceptionType type,Throwable cause){
        super(cause);
        this.type=type;
    }
    public MoodAnalysisException(ExceptionType type,String message,Throwable cause){
        super(message, cause);
        this.type=type;
    }

}
