import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * GUI Version - Code Boss Quiz Battle Game
 * Rules:
 * Boss starts with 100 HP, Player starts with 100 HP
 * Correct answer: Boss HP -20, Score +10
 * Wrong answer: Player HP -10
 * Boss HP ≤ 0 → Victory; Player HP ≤ 0 → Game Over
 * Total 10 Java multiple choice questions
 */
public class QuizBattleGUI extends JFrame implements ActionListener {
    // BOSS health points
    private int bossHP = 100;
    // Player health points
    private int playerHP = 100;
    // Player score
    private int score = 0;
    // Current question index
    private int currentQIndex = 0;
    // Question list, stores all 10 questions
    private ArrayList<Questions> questionList;

    // UI Components
    private JLabel lblStatus;     // Status display (HP, score, question number)
    private JLabel lblQuestion;   // Question text
    private JButton btnA, btnB, btnC, btnD; // Four option buttons
    private JLabel lblResult;     // Answer result feedback

    public QuizBattleGUI() {
        // Basic window settings
        setTitle("Programming Quiz Battle");
        setSize(500, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        // Center the window on screen
        setLocationRelativeTo(null);

        // Initialize UI components
        initComponents();
        // Load all questions
        loadQuestions();
        // Display the first question
        updateCurrentQuestion();

        // Show the window
        setVisible(true);
    }

    /**
     * Initialize all UI components
     */
    private void initComponents() {
        // Status label
        lblStatus = new JLabel();
        lblStatus.setBounds(30, 20, 420, 30);
        lblStatus.setFont(new Font("Arial", Font.PLAIN, 14));

        // Question label
        lblQuestion = new JLabel();
        lblQuestion.setBounds(30, 60, 420, 50);
        lblQuestion.setFont(new Font("Arial", Font.BOLD, 14));
        lblQuestion.setVerticalAlignment(SwingConstants.TOP);

        // Option A button
        btnA = new JButton();
        btnA.setBounds(50, 130, 180, 40);
        btnA.addActionListener(this);

        // Option B button
        btnB = new JButton();
        btnB.setBounds(260, 130, 180, 40);
        btnB.addActionListener(this);

        // Option C button
        btnC = new JButton();
        btnC.setBounds(50, 190, 180, 40);
        btnC.addActionListener(this);

        // Option D button
        btnD = new JButton();
        btnD.setBounds(260, 190, 180, 40);
        btnD.addActionListener(this);

        // Result feedback label
        lblResult = new JLabel("Click an option to start!");
        lblResult.setBounds(30, 260, 420, 30);
        lblResult.setFont(new Font("Arial", Font.PLAIN, 14));
        lblResult.setHorizontalAlignment(SwingConstants.CENTER);

        // Add all components to the window
        add(lblStatus);
        add(lblQuestion);
        add(btnA);
        add(btnB);
        add(btnC);
        add(btnD);
        add(lblResult);
    }

    /**
     * Load 10 Java related multiple choice questions
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
     * Update the UI to display current question
     */
    private void updateCurrentQuestion() {
        Questions q = questionList.get(currentQIndex);
        // Update top status bar
        lblStatus.setText(String.format("Question %d/10 | Boss HP: %d | Your HP: %d | Score: %d",
                currentQIndex + 1, bossHP, playerHP, score));
        // Update question text
        lblQuestion.setText(q.getQuestionText());
        // Update four option button texts
        btnA.setText(q.getOptionA());
        btnB.setText(q.getOptionB());
        btnC.setText(q.getOptionC());
        btnD.setText(q.getOptionD());
    }

    /**
     * Handle button click events
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the clicked button
        JButton clickBtn = (JButton) e.getSource();
        char userAnswer = 0;

        // Determine which option the user selected
        if (clickBtn == btnA) {
            userAnswer = 'A';
        } else if (clickBtn == btnB) {
            userAnswer = 'B';
        } else if (clickBtn == btnC) {
            userAnswer = 'C';
        } else if (clickBtn == btnD) {
            userAnswer = 'D';
        }

        Questions currentQ = questionList.get(currentQIndex);
        // Check if answer is correct
        if (currentQ.isCorrect(userAnswer)) {
            bossHP -= 20;
            score += 10;
            lblResult.setText("Correct! Boss HP -20 | Score +10");
            lblResult.setForeground(new Color(0, 120, 0));
        } else {
            playerHP -= 10;
            lblResult.setText("Wrong! Player HP -10");
            lblResult.setForeground(Color.RED);
        }

        currentQIndex++;

        // Check if game is over
        if (checkGameEnd()) {
            // Game over, disable all buttons
            btnA.setEnabled(false);
            btnB.setEnabled(false);
            btnC.setEnabled(false);
            btnD.setEnabled(false);
            return;
        }

        // Update display to next question
        updateCurrentQuestion();
    }

    /**
     * Check game win/lose conditions
     * @return true = game over, false = continue
     */
    private boolean checkGameEnd() {
        String resultMsg = "";
        if (bossHP <= 0) {
            resultMsg = "Victory! You defeated the Code Boss!\nFinal Score: " + score;
            JOptionPane.showMessageDialog(this, resultMsg, "Game Over", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else if (playerHP <= 0) {
            resultMsg = "Game Over! You have been defeated...\nFinal Score: " + score;
            JOptionPane.showMessageDialog(this, resultMsg, "Game Over", JOptionPane.ERROR_MESSAGE);
            return true;
        } else if (currentQIndex >= questionList.size()) {
            resultMsg = String.format("All questions completed!\nBoss Remaining HP: %d | Your Remaining HP: %d | Final Score: %d",
                    bossHP, playerHP, score);
            JOptionPane.showMessageDialog(this, resultMsg, "Quiz Complete", JOptionPane.PLAIN_MESSAGE);
            return true;
        }
        return false;
    }

    // Main entry point
    public static void main(String[] args) {
        // Launch GUI window
        new QuizBattleGUI();
    }
}