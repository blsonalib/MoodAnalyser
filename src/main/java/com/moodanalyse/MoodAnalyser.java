package com.moodanalyse;

public class MoodAnalyser
{
    public String analyseMood(String message)
    {
        if(message.contains("HAPPY"))
        {
            return "SAD";
        }
        else
        {
            return "HAPPY";
        }

    }

}
