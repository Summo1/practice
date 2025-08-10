import java.awt.*;
import javax.swing.*;

public class budgetTracker extends JFrame{
    // Variables
    private double budget;
    private JTextField guessField;
    private JLabel feedbackLabel;
    private final String  SAVEFILENAME = "budget.txt";
    
    public budgetTracker(){
        setTitle("Budget Tracker");
        setSize(500,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        

        this.setFont(new Font("Arial", Font.PLAIN, 35));

    //UI

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel cardPanel = new JPanel(new CardLayout());

        // Home menu
        JPanel homeMenu = new JPanel();
        homeMenu.setLayout(new BoxLayout(homeMenu, BoxLayout.Y_AXIS));

        
        //Add menu
        JPanel addMenu = new JPanel(new FlowLayout());
        JTextField priceOfExpense = new JTextField(10);
        JComboBox<String> categoryOfExpense = new JComboBox<>(new String[]{
            "Food", "Transport", "Utilities", "Entertainment", "Other"
        });

        addMenu.setBorder(BorderFactory.createTitledBorder("Add Expense"));
        addMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        addMenu.add(priceOfExpense);
        addMenu.add(categoryOfExpense);

        //History Menu

        JPanel historyMenu = new JPanel();
        historyMenu.add(new JLabel("History"));

        // Nav
        JPanel nav = new JPanel(new FlowLayout());
        // Add btn
        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(e -> {
            
        });

        // History Btn
        JButton historyBtn = new JButton("History");
        historyBtn.addActionListener(e -> {
            
        });



        // Chart


        cardPanel.add(homeMenu, "Home");
        cardPanel.add(addMenu, "Add");
        cardPanel.add(historyMenu, "History");

        
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cl.show(cardPanel, "Add");

        mainPanel.add(nav);
        mainPanel.add(cardPanel);

        this.add(mainPanel);
    }


    public static void main(String[] args){
        budgetTracker budget1 = new budgetTracker();
        budget1.setVisible(true);
    }


}
