/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * @author android1
 */
public class Tools {
    public static void setCenter(JFrame frame) {
        double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();

        int x = (int) (screenWidth - frameWidth) / 2;
        int y = (int) (screenHeight - frameHeight) / 2;

        frame.setLocation(x, y);
    }

    public static String convertPassword(char[] password) {

        String fixedPassword = "";

        for (char c : password) {

            fixedPassword += c;


        }
        return fixedPassword;
    }

    // Wrapper

    public static void show(Object msg) {

        javax.swing.JOptionPane.showMessageDialog(null, msg);

    }

}










