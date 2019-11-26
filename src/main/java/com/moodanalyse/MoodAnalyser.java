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
                throw new MoodAnalysisException("I am in happy mood");
            if (message.contains("SAD"))
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
            throw new MoodAnalysisException("please enter proper message");
        }
    }
}
