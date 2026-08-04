/**
 * 题目实体类
 * 存储每一道选择题的题干、4个选项、正确答案
 */
public class Questions {
    // 题目文本
    private String questionText;
    // A选项
    private String optionA;
    // B选项
    private String optionB;
    // C选项
    private String optionC;
    // D选项
    private String optionD;
    // 正确答案(A/B/C/D)
    private char correctAnswer;

    /**
     * 构造方法：初始化一道题目
     * @param q 题干
     * @param a A选项
     * @param b B选项
     * @param c C选项
     * @param d D选项
     * @param ans 正确答案字符
     */
    public Questions(String q, String a, String b, String c, String d, char ans) {
        this.questionText = q;
        this.optionA = a;
        this.optionB = b;
        this.optionC = c;
        this.optionD = d;
        this.correctAnswer = ans;
    }

    // 获取题干
    public String getQuestionText() {
        return questionText;
    }

    // 获取A选项
    public String getOptionA() {
        return optionA;
    }

    // 获取B选项
    public String getOptionB() {
        return optionB;
    }

    // 获取C选项
    public String getOptionC() {
        return optionC;
    }

    // 获取D选项
    public String getOptionD() {
        return optionD;
    }

    // 获取正确答案
    public char getCorrectAnswer() {
        return correctAnswer;
    }

    // 校验用户选择是否正确
    public boolean isCorrect(char userChoice) {
        return userChoice == correctAnswer;
    }
}