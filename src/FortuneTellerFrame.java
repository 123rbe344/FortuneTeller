import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl;
    JPanel topPnl;
    JPanel middlePnl;
    JPanel bottomPnl;

    JLabel titleLbl;
    ImageIcon icon;

    JTextArea displayTA;
    JScrollPane scroller;

    JButton readBtn;
    JButton quitBtn;

    Font titleFont = new Font("Serif", Font.BOLD | Font.ITALIC, 48);
    Font fortuneFont = new Font("Georgia", Font.PLAIN, 18);
    Font buttonFont = new Font("SansSerif", Font.BOLD, 16);

    ArrayList<String> fortunes = new ArrayList<>();
    Random rnd = new Random();
    int lastIndex = -1;

    public FortuneTellerFrame()
    {
        loadFortunes();

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTopPanel();
        mainPnl.add(topPnl, BorderLayout.NORTH);

        createMiddlePanel();
        mainPnl.add(middlePnl, BorderLayout.CENTER);

        createBottomPanel();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        add(mainPnl);
    }

    private void createTopPanel()
    {
        topPnl = new JPanel();
        icon = new ImageIcon("fortuneteller.png");
        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLbl.setFont(titleFont);
        // put the text below the image
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        topPnl.add(titleLbl);
    }

    private void createMiddlePanel()
    {
        middlePnl = new JPanel();
        middlePnl.setLayout(new BorderLayout());
        displayTA = new JTextArea(10, 50);
        displayTA.setFont(fortuneFont);
        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        middlePnl.add(scroller, BorderLayout.CENTER);
    }

    private void createBottomPanel()
    {
        bottomPnl = new JPanel();
        bottomPnl.setLayout(new GridLayout(1, 2));

        readBtn = new JButton("Read My Fortune!");
        readBtn.setFont(buttonFont);
        readBtn.addActionListener((ae) -> readFortune());

        quitBtn = new JButton("Quit");
        quitBtn.setFont(buttonFont);
        quitBtn.addActionListener((ae) -> System.exit(0));

        bottomPnl.add(readBtn);
        bottomPnl.add(quitBtn);
    }

    private void readFortune()
    {
        int index;
        // never give the same fortune twice in a row
        do
        {
            index = rnd.nextInt(fortunes.size());
        } while (index == lastIndex);
        lastIndex = index;

        displayTA.append(fortunes.get(index) + "\n");
    }

    private void loadFortunes()
    {
        fortunes.add("You will find a forgotten twenty in your winter coat. Spend it wisely.");
        fortunes.add("A semicolon will ruin your day. Check line 42.");
        fortunes.add("Your code will compile on the first try... in a parallel universe.");
        fortunes.add("Beware of low-flying pigeons near the library.");
        fortunes.add("You will soon have an urge to eat pizza. Resistance is futile.");
        fortunes.add("A great fortune awaits you. Unfortunately it belongs to someone else.");
        fortunes.add("Today is a good day to stay in bed. Too late now.");
        fortunes.add("Someone will compliment your socks. Wear the good ones.");
        fortunes.add("Your Wi-Fi will drop at the worst possible moment.");
        fortunes.add("You will be hungry again in one hour.");
        fortunes.add("The cat is plotting something. Keep one eye open.");
        fortunes.add("Help! I'm trapped inside a Java program!");
        fortunes.add("An exciting opportunity lies ahead... right after this nap.");
        fortunes.add("You will step on a LEGO. Soon.");
    }
}
