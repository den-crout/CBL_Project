import javax.swing.*;
    // git add .    git commit - m "text"     git push origin main
    // git branch (see current branch)
    // git branch -a (see all local + remote branches)
    // git switch main      git pull origin main   (switch to main and pull before working)
public class JumpKing {

    private static NewJFrame myFrame;
    private static Background mainScreen;

    public static void main(String[] args) {
/*
        myFrame = new NewJFrame();
        
        myFrame.setLocationRelativeTo(null);
        
        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        */
        mainScreen = new Background();
    }
}
