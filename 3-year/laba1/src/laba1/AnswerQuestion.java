package laba1;

public class AnswerQuestion
{
    protected String question;

    protected String answer;

    AnswerQuestion(String question)
    {
        this.question = question;
    }

    public String getQuestion()
    {
        return this.question;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public String getAnswer()
    {
        return this.answer;
    }
}
