import java.util.ArrayList;
import java.util.Scanner;

/**
 * 【控制台版】Code Boss答题对战游戏
 * 规则：
 * Boss初始血量100，玩家初始血量100
 * 答对：Boss血量-20，分数+10
 * 答错：玩家血量-10
 * Boss血量≤0 → 胜利；玩家血量≤0 → GameOver
 * 总共有10道Java选择题
 */
public class QuizBattleGUI {
    // BOSS血量
    private int bossHP = 100;
    // 玩家血量
    private int playerHP = 100;
    // 玩家得分
    private int score = 0;
    // 当前题目索引
    private int currentQIndex = 0;
    // 题目集合，存放所有10道题目
    private ArrayList<Questions> questionList;
    private Scanner scanner;

    public QuizBattleGUI() {
        scanner = new Scanner(System.in);
        loadQuestions();
        startGame();
    }

    /**
     * 加载10道Java相关选择题
     */
    private void loadQuestions() {
        questionList = new ArrayList<>();
        questionList.add(new Questions("Which keyword creates an object in Java?",
                "A. class", "B. new", "C. static", "D. void", 'B'));
        questionList.add(new Questions("Java is which type of language?",
                "A. Compiled & Interpreted", "B. Only compiled", "C. Script", "D. Machine language", 'A'));
        questionList.add(new Questions("What is the superclass of all Java classes?",
                "A. String", "B. Object", "C. Main", "D. Class", 'B'));
        questionList.add(new Questions("Which modifier makes a variable visible only inside class?",
                "A. public", "B. protected", "C. private", "D. static", 'C'));
        questionList.add(new Questions("Which loop runs at least once?",
                "A. for", "B. while", "C. do-while", "D. foreach", 'C'));
        questionList.add(new Questions("Method overloading requires different?",
                "A. return type", "B. parameter list", "C. method name", "D. access modifier", 'B'));
        questionList.add(new Questions("Which cannot be used inside method body?",
                "A. if", "B. class", "C. switch", "D. for", 'B'));
        questionList.add(new Questions("'this' keyword refers to?",
                "A. static variable", "B. current object", "C. parent class", "D. method", 'B'));
        questionList.add(new Questions("Array index starts from?",
                "A. 1", "B. 0", "C. -1", "D. random", 'B'));
        questionList.add(new Questions("Which is not a primitive type?",
                "A. int", "B. boolean", "C. String", "D. char", 'C'));
    }

    /**
     * 游戏主循环
     */
    private void startGame() {
        System.out.println("==== Code Boss 答题对战开始 ====");
        while (currentQIndex < questionList.size()) {
            // 打印状态
            System.out.println("\nBoss HP: " + bossHP + " | 玩家HP: " + playerHP + " | 分数: " + score);
            Questions q = questionList.get(currentQIndex);

            // 输出题目
            System.out.println("\n题目 " + (currentQIndex + 1) + "：" + q.getQuestionText());
            System.out.println(q.getOptionA());
            System.out.println(q.getOptionB());
            System.out.println(q.getOptionC());
            System.out.println(q.getOptionD());
            System.out.print("请输入你的答案(A/B/C/D)：");

            // 获取输入
            String input = scanner.nextLine().trim().toUpperCase();
            char userAnswer = input.charAt(0);

            // 判断对错
            if (userAnswer == q.getCorrectAnswer()) {
                bossHP -= 20;
                score += 10;
                System.out.println("✅ 回答正确！Boss HP -20 | 分数 +10");
            } else {
                playerHP -= 10;
                System.out.println("❌ 回答错误！玩家 HP -10");
            }

            currentQIndex++;

            // 检查游戏结束条件
            if (checkGameEnd()) {
                break;
            }
        }
        scanner.close();
    }

    /**
     * 检测游戏胜负条件
     * @return true=游戏结束 false=继续答题
     */
    private boolean checkGameEnd() {
        if (bossHP <= 0) {
            System.out.println("\n🎉 You won! You successfully defeated Code Boss! Final score: " + score);
            return true;
        } else if (playerHP <= 0) {
            System.out.println("\n💀 Game over! You lost. Final score: " + score);
            return true;
        } else if (currentQIndex >= questionList.size()) {
            System.out.println("\n📝 All questions have been answered！");
            System.out.println("Boss HP:" + bossHP + " | Player HP:" + playerHP + " | Score:" + score);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new QuizBattleGUI();
    }
}