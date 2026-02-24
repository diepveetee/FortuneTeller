import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * FortuneTellerFrame represents the main GUI window for the Fortune Teller application.
 *
 * This class extends JFrame and builds a Swing-based user interface that:
 * 1) Displays a title with an image
 * 2) Shows fortunes in a scrollable text area
 * 3) Allows the user to generate random fortunes
 * 4) Prevents the same fortune from appearing twice in a row
 *
 * The window is sized to 3/4 of the screen and centered.
 */

public class FortuneTellerFrame extends JFrame {
    /** Text area where fortunes are displayed. */
    private JTextArea fortuneArea;

    /** List of fortune messages. */
    private ArrayList<String> fortunes;

    /** Random number generator for selecting fortunes. */
    private Random random = new Random();

    /** Stores the index of the previously displayed fortune. */
    private int lastIndex = -1;

    /** Fonts for the UI **/
    private Font titleFont = new Font("Comic Sans MS", Font.BOLD, 42);
    private Font fortuneFont = new Font("Comic Sans MS", Font.PLAIN, 18);
    private Font buttonFont = new Font("Comic Sans MS", Font.BOLD, 20);


    /**
     * Constructs the FortuneTellerFrame.
     *
     * Initializes layout, panels, fortunes, and frame configuration.
     */

    public FortuneTellerFrame() {
        super("Fortune Teller");

        setLayout(new BorderLayout());

        add(createTopPanel(), BorderLayout.NORTH);
        add(createMiddlePanel(), BorderLayout.CENTER);
        add(createBottomPanel(), BorderLayout.SOUTH);

        initializeFortunes();
        configureFrame();
    }

    /**
     * Creates the top panel containing the title and image.
     *
     * @return JPanel containing the formatted title label with icon
     */

    private JPanel createTopPanel() {
        JPanel panel = new JPanel();

        ImageIcon icon = new ImageIcon("resources/fortune.png");
        JLabel label = new JLabel("Fortune Teller", icon, JLabel.CENTER);

        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setFont(titleFont);

        panel.add(label);
        return panel;
    }

    /**
     * Creates the middle panel containing the scrollable text area
     * where fortunes are displayed.
     *
     * @return JPanel containing a JScrollPane with JTextArea
     */

    private JPanel createMiddlePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        fortuneArea = new JTextArea(10, 40);
        fortuneArea.setEditable(false);
        fortuneArea.setFont(fortuneFont);

        JScrollPane scrollPane = new JScrollPane(fortuneArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    /**
     * Creates the bottom panel containing the action buttons.
     *
     * @return JPanel containing "Read My Fortune" and "Quit" buttons
     */

    private JPanel createBottomPanel() {
        JPanel panel = new JPanel();

        JButton readButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");

        readButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);

        readButton.addActionListener(e -> displayFortune());
        quitButton.addActionListener(e -> System.exit(0));

        panel.add(readButton);
        panel.add(quitButton);

        return panel;
    }


    /**
     * Initializes the list of fortune messages.
     */

    private void initializeFortunes() {
        fortunes = new ArrayList<>();

        fortunes.add("It is certain.");
        fortunes.add("It is decidedly so.");
        fortunes.add("Without a doubt.");
        fortunes.add("Yes definitely.");
        fortunes.add("You may rely on it.");
        fortunes.add("Reply hazy, try again.");
        fortunes.add("Ask again later.");
        fortunes.add("Better not tell you now.");
        fortunes.add("Cannot predict now.");
        fortunes.add("Concentrate and ask again.");
        fortunes.add("Don't count on it.");
        fortunes.add("My reply is no.");
        fortunes.add("My sources say no.");
        fortunes.add("Outlook not so good.");
        fortunes.add("Very doubtful.");
        fortunes.add("As I see it, yes.");
        fortunes.add("Most likely.");
        fortunes.add("Outlook good.");
        fortunes.add("Yes.");
        fortunes.add("Signs point to yes");
        fortunes.add("Never gonna give you up\n" +
                "Never gonna let you down\n" +
                "Never gonna run around and desert you\n" +
                "Never gonna make you cry\n" +
                "Never gonna say goodbye\n" +
                "Never gonna tell a lie and hurt you");
    }

    /**
     * Randomly selects and displays a fortune.
     *
     * Ensures the same fortune is not shown twice in a row.
     */

    private void displayFortune() {
        int newIndex;

        do {
            //picks random number between 0 and size of ArrayList
            newIndex = random.nextInt(fortunes.size());

        //Keep generating a new random number as long as the new one is equal to that one
        } while (newIndex == lastIndex);

        lastIndex = newIndex;
        fortuneArea.append(fortunes.get(newIndex) + "\n");
    }

    /**
     * Configures the main application window.
     *
     * Sets window size to 3/4 of the screen
     * Centers the window
     * Sets close operation
     * Makes the frame visible
     */

    private void configureFrame() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int width = (int)(screenSize.width * 0.75);
        int height = (int)(screenSize.height * 0.75);

        setSize(width, height);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Main entry point of the Fortune Teller application.
     *
     * Ensures the GUI is created on the Event Dispatch Thread (EDT)
     * using SwingUtilities.invokeLater.
     */

    public static void main(String[] args)
    {
        // The invokeLater method ensures the GUI is created on the
        // Event Dispatch Thread (EDT) to avoid thread interference.

        SwingUtilities.invokeLater(() -> { new FortuneTellerFrame();

        });
    }
}



