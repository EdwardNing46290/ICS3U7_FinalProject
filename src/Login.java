/* import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener; // should take input?
import java.io.*;

public class Login implements ActionListener {

	public JTextField usernameText;
	public JPasswordField passwordText;
  
  // Times New Roman
	Font roman = new Font("TimesRoman", Font.PLAIN, 20);
	Font buttonRoman = new Font("TimesRoman", Font.PLAIN, 15);
  
	/**
    Login() {
    // Username and Password
		JFrame loginFrame = new JFrame();
		usernameText = new JUsernameField("");
		passwordText = new JPasswordField("");
		JTextField username = new JTextField("Enter your Username: ");
		JTextField password = new JTextField("Enter your Password: ");
		login = new JButton("Login");

		loginFrame.setSize(200,200);
    
    // setBounds
		JLabel username = new JLabel("Username");
		username.setBounds(__, __, __, __);
		username.setFont(TimesRoman);
		loginFrame.add(username);

		JLabel password = new JLabel("Password");
		password.setBounds(__, __, __, __);
    password.setFont(TimesRoman);
		loginFrame.add(password);
    
    // ... check if the username exists and password is correct
    boolean exists = tempFile.exists(); ?


		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
//import required classes and packages  
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception;  
  
//create CreateLoginForm class to create login form  
//class extends JFrame to create a window where our component add  
//class implements ActionListener to perform an action on button click  
class CreateLoginForm extends JFrame implements ActionListener  
{  
    //initialize button, panel, label, and text field  
    JButton b1;  
    JPanel newPanel;  
    JLabel userLabel, passLabel;  
    final JTextField  textField1, textField2;  
      
    //calling constructor  
    CreateLoginForm()  
    {     
          
        //create label for username   
        userLabel = new JLabel();  
        userLabel.setText("Username");      //set label value for textField1  
          
        //create text field to get username from the user  
        textField1 = new JTextField(15);    //set length of the text  
  
        //create label for password  
        passLabel = new JLabel();  
        passLabel.setText("Password");      //set label value for textField2  
          
        //create text field to get password from the user  
        textField2 = new JPasswordField(15);    //set length for the password  
          
        //create submit button  
        b1 = new JButton("SUBMIT"); //set label to button  
          
        //create panel to put form elements  
        newPanel = new JPanel(new GridLayout(3, 1));  
        newPanel.add(userLabel);    //set username label to panel  
        newPanel.add(textField1);   //set text field to panel  
        newPanel.add(passLabel);    //set password label to panel  
        newPanel.add(textField2);   //set text field to panel  
        newPanel.add(b1);           //set button to panel  
          
        //set border to panel   
        add(newPanel, BorderLayout.CENTER);  
          
        //perform action on button click   
        b1.addActionListener(this);     //add action listener to button  
        setTitle("LOGIN FORM");         //set title to the login form  
    }  
      
    //define abstract method actionPerformed() which will be called on button click   
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter  
    {  
        String userValue = textField1.getText();        //get user entered username from the textField1  
        String passValue = textField2.getText();        //get user entered pasword from the textField2  
          
        //check whether the credentials are authentic or not  
        if (userValue.equals("test1@gmail.com") && passValue.equals("test")) {  //if authentic, navigate user to a new page  
              
            //create instance of the NewPage  
            NewPage page = new NewPage();  
              
            //make page visible to the user  
            page.setVisible(true);  
              
            //create a welcome label and set it to the new page  
            JLabel wel_label = new JLabel("Welcome: "+userValue);  
            page.getContentPane().add(wel_label);  
        }  
        else{  
            //show error message  
            System.out.println("Please enter valid username and password");
	    // code borrowed from javatpoint
        }  
    }  
}  
//create the main class  
class LoginFormDemo  
{  
    //main() method start  
    public static void main(String arg[])  
    {  
        try  
        {  
            //create instance of the CreateLoginForm  
            CreateLoginForm form = new CreateLoginForm();  
            form.setSize(300,100);  //set size of the frame  
            form.setVisible(true);  //make form visible to the user  
        }  
        catch(Exception e)  
        {     
            //handle exception   
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
} 
*/
