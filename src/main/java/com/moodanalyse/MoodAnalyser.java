package com.moodanalyse;

public class MoodAnalyser
{
    private String message;
    public MoodAnalyser(String message)
    {
        this.message=message;
    }

    public MoodAnalyser()
    {
    }
    public  String analyseMood(String message) throws MoodAnalysisException
    {
        this.message=message;
        return  analyseMood();
    }

    public String analyseMood() throws MoodAnalysisException
    {
        try
        {
            if(message.length()==0)
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,"please enter proper mood");
            if (message.contains("Sad"))
            {
                return "SAD";
            }
            else
            {
                return "HAPPY";
            }
        }
        catch(NullPointerException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL,"please enter proper message");
        }
    }


    @Override
    public boolean equals(Object another)
    {
        if (this.message.equals(((MoodAnalyser)another).message))
            return true;
        return false;
    }
}
