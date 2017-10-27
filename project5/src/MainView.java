import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The main window for playing a game of war with two players.
 * @author Chris Randall
 * @author Mark Donohue
 * @author Brian Legarth
 * @author Tommy Thetford
 */

public class MainView extends JFrame{

    private Deck gameDeck;
    private WarGame game;
    private Card cardOne;
    private Card cardTwo;
    
    /**
     * Constructor. Sets up the necessary GUI conditions for our a game of war.
     * @param deck - A deck of cards
     */
    public MainView(Deck deck){
        gameDeck = deck;
        JPanel cont1 = new JPanel();
        cont1.setSize(600, 50);
        cont1.setLayout(new GridLayout(1,3));
        JPanel cont2 = new JPanel();
        cont2.setSize(600, 250);
        cont2.setLayout(new GridLayout(1,3));
        JPanel cont3 = new JPanel();
        cont3.setSize(600, 50);
        cont3.setLayout(new GridLayout(1,2));
        
        CardPanel p1 = new CardPanel();
        p1.setSize(200,250);
        CardPanel p2 = new CardPanel();
        p2.setSize(200,250);
        JTextArea text = new JTextArea();
        text.setSize(200,250);
        cont2.add(p1);
        cont2.add(text);
        cont2.add(p2);
        
        JTextField p3 = new JTextField();
        p3.setEditable(false);
        p3.setBackground(null);
        p3.setHorizontalAlignment(JTextField.CENTER);
        p3.setText("Player 1");
        p3.setSize(200,50);
        JTextField p4 = new JTextField();
        p4.setEditable(false);
        p4.setBackground(null);
        p4.setHorizontalAlignment(JTextField.CENTER);
        p4.setText("Status");
        p4.setSize(200,50);
        JTextField p5 = new JTextField();
        p5.setEditable(false);
        p5.setBackground(null);
        p5.setHorizontalAlignment(JTextField.CENTER);
        p5.setText("Player 2");
        p5.setSize(200,50);
        cont1.add(p3);
        cont1.add(p4);
        cont1.add(p5);
        
        game = new WarGame();
        game.deal();
        JButton button = new JButton("Move");
        button.setSize(200,50);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (! game.winner()){
                    game.Step();
                    cardOne = game.playOneCard();
                    cardTwo = game.playTwoCard();
                    cardOne.turn();
                    cardTwo.turn();
                    p1.setCard(cardOne);
                    p2.setCard(cardTwo);
                    text.setText(game.toString());
                }
            }});
        JButton newGame = new JButton("New Game");
        newGame.setSize(200,50);
        newGame.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			game = new WarGame();
        			game.deal();
        			cardOne = null;
        			cardTwo = null;
        			p1.setCard(cardOne);
                p2.setCard(cardTwo);
                text.setText(game.toString());
        		}
        });
        cont3.add(button);
        cont3.add(newGame);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(cont1, BorderLayout.NORTH);
        c.add(cont2, BorderLayout.CENTER);
        c.add(cont3, BorderLayout.SOUTH);
    }
}
