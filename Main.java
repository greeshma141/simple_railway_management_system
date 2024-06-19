import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        Font font1 = new Font("Serif", Font.BOLD, 45);
        Font font2 = new Font("SansSerif", Font.BOLD, 25);
        Font font3 = new Font("SansSerif", Font.PLAIN, 20);
        Font font4 = new Font("sanserif", Font.BOLD, 20);
        Font font5 = new Font("sanserif", Font.BOLD, 35);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "gressy");
            Frame f1 = new Frame();
            Label l1 = new Label("Railway Management System");
            l1.setFont(font1);
            l1.setForeground(Color.white);
            Button b1 = new Button("Sign Up");
            b1.setFont(font2);
            b1.setForeground(Color.blue);
            b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Frame f2 = new Frame();
                    f2.setLayout(null);
                    f2.setBackground(Color.black);
                    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
                    f2.setSize(size.width, size.height);
                    Label rf = new Label("Registration Form");
                    rf.setForeground(Color.white);
                    rf.setFont(font5);
                    Label l2 = new Label("Username:");
                    l2.setFont(font4);
                    l2.setForeground(Color.white);
                    TextField t1 = new TextField();
                    t1.setFont(font3);
                    Label l3 = new Label("Password:");
                    l3.setFont(font4);
                    l3.setForeground(Color.white);
                    TextField t2 = new TextField();
                    t2.setEchoChar('*');
                    t2.setFont(font3);
                    Label l4 = new Label("Mobile Number:");
                    l4.setFont(font4);
                    l4.setForeground(Color.white);
                    TextField t3 = new TextField();
                    t3.setFont(font3);
                    Label l5 = new Label("Age:");
                    l5.setFont(font4);
                    l5.setForeground(Color.white);
                    TextField t4 = new TextField();
                    t4.setFont(font3);
                    Label l6 = new Label("Gender:");
                    l6.setFont(font4);
                    l6.setForeground(Color.white);
                    Button b3 = new Button("Male");
                    Button b4 = new Button("Female");
                    Button submit = new Button("Submit");
                    Button back1 = new Button("Back");
                    b3.setFont(font4);
                    b4.setFont(font4);
                    submit.setFont(font4);
                    back1.setFont(font4);
                    rf.setBounds(450, 100, 400, 50);
                    l2.setBounds(400, 200, 200, 40);
                    t1.setBounds(600, 200, 200, 40);
                    l3.setBounds(400, 250, 200, 40);
                    t2.setBounds(600, 250, 200, 40);
                    l4.setBounds(400, 300, 200, 40);
                    t3.setBounds(600, 300, 200, 40);
                    l5.setBounds(400, 350, 200, 40);
                    t4.setBounds(600, 350, 200, 40);
                    l6.setBounds(400, 400, 200, 40);
                    b3.setBounds(600, 400, 100, 40);
                    b4.setBounds(700, 400, 100, 40);
                    submit.setBounds(530, 500, 150, 50);
                    back1.setBounds(530, 600, 150, 50);
                    f2.add(rf);f2.add(l2);f2.add(t1);f2.add(l3);f2.add(t2);f2.add(l4);f2.add(t3);f2.add(l5);
                    f2.add(t4);f2.add(l6);f2.add(b3);f2.add(b4);f2.add(submit);f2.add(back1);
                    f2.setVisible(true);
                    final String[] g = {""};
                    b3.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            g[0] = "Male";
                            if (e.getSource() == b3) {
                                b3.setBackground(Color.cyan);
                                b4.setBackground(Color.white);}}
                    });
                    b4.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            g[0] = "Female";
                            if (e.getSource() == b4) {
                                b4.setBackground(Color.cyan);
                                b3.setBackground(Color.white);}}
                    });
                    submit.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            try {
                                String username = t1.getText();
                                String password = t2.getText();
                                String mobile_number = t3.getText();
                                String age = t4.getText();
                                String gender = g[0];
                                String query = "INSERT INTO register(username,password,mobile_number,age,gender)VALUES(?,?,?,?,?)";
                                PreparedStatement p1 = c.prepareStatement(query);
                                p1.setString(1, username);
                                p1.setString(2, password);
                                p1.setString(3, mobile_number);
                                p1.setString(4, age);
                                p1.setString(5, gender);
                                p1.executeUpdate();
                                t1.setText("");
                                t2.setText("");
                                t3.setText("");
                                t4.setText("");
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                                Label invalid = new Label("--- Username Already Exists!!");
                                invalid.setBounds(680, 500, 400, 40);
                                invalid.setForeground(Color.white);
                                invalid.setFont(font4);
                                f2.add(invalid);}}
                    });
                    back1.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            f2.setVisible(false);
                            f1.setVisible(true);}
                    });}
            });
            Button b2 = new Button("Sign In");
            b2.setFont(font2);
            b2.setForeground(Color.blue);
            b2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Frame f3 = new Frame();
                    f3.setLayout(null);
                    f3.setBackground(Color.BLACK);
                    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
                    f3.setSize(size.width, size.height);
                    Label l7 = new Label("Sign In");
                    l7.setForeground(Color.white);
                    l7.setFont(font5);
                    Label l8 = new Label("Username:");
                    l8.setForeground(Color.white);
                    l8.setFont(font4);
                    Label l9 = new Label("Password:");
                    l9.setForeground(Color.white);
                    l9.setFont(font4);
                    TextField t5 = new TextField();
                    t5.setFont(font3);
                    TextField t6 = new TextField();
                    t6.setEchoChar('*');
                    t6.setFont(font3);
                    Button next = new Button("Next");
                    next.setFont(font4);
                    Button back2 = new Button("Back");
                    back2.setFont(font4);
                    l7.setBounds(550, 150, 200, 40);
                    l8.setBounds(450, 250, 100, 40);
                    l9.setBounds(450, 300, 100, 40);
                    t5.setBounds(600, 250, 200, 40);
                    t6.setBounds(600, 300, 200, 40);
                    next.setBounds(500, 400, 200, 40);
                    back2.setBounds(500, 450, 200, 40);
                    f3.add(l7);f3.add(l8);f3.add(l9);f3.add(t5);f3.add(t6);
                    f3.add(back2);f3.add(next);
                    next.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            try {
                                String username = t5.getText();
                                String password = t6.getText();
                                String query = "SELECT * FROM register WHERE username = ? AND password = ?";
                                PreparedStatement p2 = c.prepareStatement(query);
                                p2.setString(1, username);
                                p2.setString(2, password);
                                ResultSet rs = p2.executeQuery();
                                if (rs.next()) {
                                    Frame f4 = new Frame();
                                    f4.setLayout(null);
                                    f4.setBackground(Color.BLACK);
                                    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
                                    f4.setSize(size.width, size.height);
                                    Button past = new Button("Travelling Details");
                                    past.setFont(font2);
                                    Button present = new Button("Ticket Booking");
                                    present.setFont(font2);
                                    Button back3 = new Button("Back");
                                    back3.setFont(font2);
                                    past.setBounds(570, 200, 300, 60);
                                    present.setBounds(570, 350, 300, 60);
                                    back3.setBounds(650, 450, 100, 40);
                                    past.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                            Frame f5 = new Frame();
                                            f5.setLayout(new BorderLayout());
                                            f5.setBackground(Color.BLACK);
                                            Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
                                            f5.setSize(size.width, size.height);
                                            TextArea ta = new TextArea();
                                            ta.setFont(font3);
                                            ta.setForeground(Color.BLACK);
                                            ta.setEditable(false);
                                            f5.add(ta, BorderLayout.CENTER);
                                            try {
                                                String pastQuery = "SELECT * FROM train WHERE username = ?";
                                                PreparedStatement p4 = c.prepareStatement(pastQuery);
                                                p4.setString(1, username);
                                                ResultSet rs = p4.executeQuery();
                                                while (rs.next()) {
                                                    String travelDetail = "Date: " + rs.getString("travel_date") + ",      " +
                                                            " From: " + rs.getString("departure") + ",       " +
                                                            " To: " + rs.getString("Destination") + "\n";
                                                    ta.append(travelDetail);}
                                                rs.close();
                                            } catch (SQLException ex) {
                                                ex.printStackTrace();}
                                            f5.setVisible(true);}
                                    });
                                    present.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                            Frame f6 = new Frame();
                                            f6.setLayout(null);
                                            f6.setBackground(Color.black);
                                            Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
                                            f6.setSize(size.width, size.height);
                                            Label tb = new Label("Ticket Booking");
                                            Label fn = new Label("First Name:");
                                            Label ln = new Label("Last Name:");
                                            Label f = new Label("From:");
                                            Label t = new Label("To:");
                                            Label date = new Label("Date:");
                                            Label price = new Label("Ticket Cost");
                                            Label ta = new Label("Trains Available:");
                                            TextField tfn = new TextField();
                                            TextField tln = new TextField();
                                            List l1 = new List(15);
                                            l1.add("visakhapatnam");l1.add("gajuwaka");l1.add("anakapalli");
                                            l1.add("guntur");l1.add("vijayawada");l1.add("kakinada");
                                            l1.add("srikakulam");l1.add("parvathipuram");l1.add("bobbili");
                                            l1.add("thagarpuvalasa");l1.add("simhachalam");l1.add("Annavaram");
                                            l1.add("narsipatnam");l1.add("tirupati");l1.add("kurnool");
                                            List l2 = new List(15);
                                            l2.add("bobbili");l2.add("visakhapatnam");l2.add("srikakulam");
                                            l2.add("gajuwaka");l2.add("kurnool");l2.add("simhachalam");
                                            l2.add("anakapalli");l2.add("vijaynagaram");l2.add("tirupati");
                                            l2.add("guntur");l2.add("vijayawada");l2.add("thagarpuvalasa");
                                            l2.add("parvathipuram");l2.add("narsipatnam");l2.add("annavaram");
                                            TextField td = new TextField("YYYY-MM-DD");
                                            Button p = new Button("Rupees 150/-");
                                            List l3 = new List(5);
                                            l3.add("Visakhapatnam Express");l3.add("Godavari Express");
                                            l3.add("Raipur Express");l3.add("Samata Express");
                                            l3.add("Nagawali Express");
                                            Button sub = new Button("Book Ticket");
                                            Button cancel = new Button("Cancel");
                                            Button back4 = new Button("Back");
                                            tb.setBounds(500, 100, 300, 40);
                                            tb.setFont(font5);
                                            tb.setForeground(Color.white);
                                            fn.setBounds(400, 200, 200, 40);
                                            fn.setFont(font4);
                                            fn.setForeground(Color.white);
                                            tfn.setBounds(600, 200, 250, 30);
                                            tfn.setFont(font3);
                                            ln.setBounds(400, 250, 200, 40);
                                            ln.setFont(font4);
                                            ln.setForeground(Color.white);
                                            tln.setBounds(600, 250, 250, 30);
                                            tln.setFont(font3);
                                            f.setBounds(400, 300, 200, 40);
                                            f.setFont(font4);
                                            f.setForeground(Color.white);
                                            l1.setBounds(600, 300, 250, 30);
                                            l1.setFont(font3);
                                            t.setBounds(400, 350, 200, 40);
                                            t.setFont(font4);
                                            t.setForeground(Color.white);
                                            l2.setBounds(600, 350, 250, 30);
                                            l2.setFont(font3);
                                            date.setBounds(400, 400, 200, 40);
                                            date.setFont(font4);
                                            date.setForeground(Color.white);
                                            td.setBounds(600, 400, 250, 30);
                                            td.setFont(font3);
                                            td.setForeground(Color.gray);
                                            td.addFocusListener(new FocusAdapter() {
                                                public void focusGained(FocusEvent e) {
                                                    if (td.getText().equals("YYYY-MM-DD")) {
                                                        td.setText("");
                                                        td.setForeground(Color.BLACK);}}
                                            });
                                            ta.setBounds(400, 450, 200, 40);
                                            ta.setFont(font4);
                                            ta.setForeground(Color.white);
                                            l3.setBounds(600, 450, 400, 30);
                                            l3.setFont(font4);
                                            price.setBounds(400, 500, 200, 40);
                                            price.setFont(font4);
                                            price.setForeground(Color.white);
                                            p.setBounds(600, 500, 250, 40);
                                            p.setFont(font4);
                                            p.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                    Label pay = new Label("--- Payment done Successfully!!");
                                                    pay.setBounds(900, 500, 400, 40);
                                                    pay.setForeground(Color.white);
                                                    pay.setFont(font4);
                                                    f6.add(pay);}
                                            });
                                            back4.setBounds(400, 600, 200, 40);
                                            back4.setFont(font4);
                                            back4.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                    f6.setVisible(false);
                                                    f4.setVisible(true);}
                                            });
                                            cancel.setBounds(650, 600, 200, 40);
                                            cancel.setFont(font4);
                                            cancel.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                    f1.setVisible(true);
                                                    f6.setVisible(false);}
                                            });
                                            sub.setBounds(550, 650, 200, 40);
                                            sub.setFont(font4);
                                            f6.add(tb);f6.add(fn);f6.add(ln);f6.add(tfn);f6.add(tln);f6.add(f);
                                            f6.add(t);f6.add(l1);f6.add(l2);f6.add(date);f6.add(td);f6.add(price);
                                            f6.add(p);f6.add(ta);f6.add(l3);f6.add(sub);f6.add(back4);f6.add(cancel);
                                            sub.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                    try {
                                                        String first_name = tfn.getText();
                                                        String last_name = tln.getText();
                                                        String departure = l1.getSelectedItem();
                                                        String destination = l2.getSelectedItem();
                                                        String travel_date = td.getText();
                                                        String train_name = l3.getSelectedItem();
                                                        String query = "INSERT INTO train(username,first_name,last_name,departure," +
                                                                "destination,travel_date,train_name)VALUES(?,?,?,?,?,?,?)";
                                                        PreparedStatement p3 = c.prepareStatement(query);
                                                        p3.setString(1, username);
                                                        p3.setString(2, first_name);
                                                        p3.setString(3, last_name);
                                                        p3.setString(4, departure);
                                                        p3.setString(5, destination);
                                                        p3.setString(6, travel_date);
                                                        p3.setString(7, train_name);
                                                        p3.executeUpdate();
                                                        tfn.setText("");
                                                        tln.setText("");
                                                        td.setText("");
                                                    } catch (SQLException ex) {
                                                        ex.printStackTrace();
                                                    }
                                                    Label bt = new Label("--- Ticket booked Successfully!!");
                                                    bt.setBounds(800, 650, 400, 40);
                                                    bt.setForeground(Color.white);
                                                    bt.setFont(font4);
                                                    f6.add(bt);}
                                            });
                                            f6.setVisible(true);}
                                    });
                                    back3.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                            f3.setVisible(true);
                                            f4.setVisible(false);}
                                    });
                                    f4.add(past);f4.add(present);f4.add(back3);f4.setVisible(true);
                                } else {
                                    Label iv = new Label("Invalid Username or Password!!");
                                    iv.setForeground(Color.white);
                                    iv.setFont(font2);
                                    iv.setBounds(430, 500, 400, 40);
                                    f3.add(iv);f3.validate();f3.repaint();}
                                rs.close();
                                p2.close();
                            } catch (SQLException ex) {
                                ex.printStackTrace();}}
                    });
                    back2.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            f3.setVisible(false);
                            f1.setVisible(true);}
                    });
                    f3.setVisible(true);}
            });
            l1.setBounds(420, 150, 700, 60);
            b1.setBounds(550, 320, 200, 40);
            b2.setBounds(550, 450, 200, 40);
            f1.add(l1);f1.add(b1);f1.add(b2);
            Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
            f1.setSize(size.width, size.height);
            f1.setBackground(Color.BLACK);
            f1.setLayout(null);
            f1.setVisible(true);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
