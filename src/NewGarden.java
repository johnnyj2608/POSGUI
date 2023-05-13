import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import net.miginfocom.swing.MigLayout;
import org.jsoup.Jsoup;

/**
 *
 * @author johnnyj2608
 */
public class NewGarden {
    
    // Initializes variables for future use
    private static Timer timer;
    private boolean prevEdit = false;
    private boolean timerCheck = false;
    private boolean riceCheck = false;
    private boolean pastLunch = false;
    private String prevTitle = "";
    private String prevCard = "";
    private String size_name = "";
    private int rowEdit = 0;
    private int order_number = 0;
    private double size_price = 0.0;
    private final double tax = 1.06;
    private final Color reddish = new Color(204, 0, 0);
    private final Color greyish = new Color(153, 153, 153);
    private final Font reg_title = new Font("Verdana", Font.PLAIN, 28);
    private final Font sub_title = new Font("Verdana", Font.PLAIN, 20);
    private final Font med_title = new Font("Verdana", Font.PLAIN, 32);
    private final Font big_title = new Font("Verdana", Font.PLAIN, 48);
    private final Font ban_title = new Font("Verdana", Font.BOLD, 64);
    private final LineBorder outline = new LineBorder(Color.BLACK, 2);
    private final Calendar cal = Calendar.getInstance();

    // Initialize variables for the home page
    private final JFrame frame = new JFrame();
    private final JPanel main = new JPanel(new CardLayout());
    private final JPanel home_page = new JPanel(new MigLayout());
    private final JLabel home_image = new JLabel();
    private final JLabel home_title = new JLabel("NEW GARDEN");
    private final JLabel home_touch = new JLabel("TOUCH TO BEGIN");
    private final JPanel home_backdrop = new JPanel(new MigLayout());
    private final JPanel home_banner = new JPanel(new MigLayout());
    private final JPanel home_bar = new JPanel(new MigLayout());

    // Initialize variables for the categ page
    private final JPanel click = new JPanel(new CardLayout());
    private final JPanel sidebar_panel = new JPanel(new MigLayout());
    private final JPanel sidebar_buttons = new JPanel(new MigLayout("", "[][]", "[]"));
    private final JLabel title = new JLabel("Categories");
    private final JLabel sidebar_title = new JLabel("NEW GARDEN");
    private final JLabel back_text = new JLabel("Back");
    private final JLabel cancel_text = new JLabel("Cancel");
    private final JPanel order_page = new JPanel(new MigLayout("", "[]", "[]"));
    private final JPanel order_banner = new JPanel(new MigLayout());
    private final JPanel order_sidebar = new JPanel(new MigLayout("", "5[]5", "5[]10"));
    private final JPanel order_categ = new JPanel(new MigLayout("fill", "[]20[]20[]20[]", "[]20[]20[]20[]10"));
    private final JPanel back_button = new JPanel(new MigLayout());
    private final JPanel cancel_button = new JPanel(new MigLayout());
    private final JPanel whitebar_section = new JPanel(new MigLayout("insets 0"));
    private final JPanel price_section = new JPanel(new MigLayout("insets 5", "[][]", "[][][]"));
    private final JLabel price_left = new JLabel("<html>Subtotal<br>Tax<br>Final Total</html>");
    private final JLabel price_sub = new JLabel("$0.00");
    private final JLabel price_tax = new JLabel("$0.00");
    private final JLabel price_ftot = new JLabel("$0.00");
    private final JTable order_list = new JTable();
    private final JScrollPane order_scroll = new JScrollPane(order_list);
    private final JTextPane[] item_names = new JTextPane[16];
    private final SimpleAttributeSet set = new SimpleAttributeSet();

    // Initialize variables for the custom page
    private final JPanel custom_page = new JPanel(new MigLayout("fill", "[][]", "[][][][]"));
    private final JPanel custom_quantity = new JPanel(new MigLayout("fill"));
    private final JPanel custom_add = new JPanel(new MigLayout());
    private final JPanel custom_sub = new JPanel(new MigLayout());
    private final JPanel custom_amt = new JPanel(new MigLayout());
    private final JPanel custom_clear = new JPanel(new MigLayout());
    private final JPanel custom_sizes = new JPanel(new CardLayout());
    private final JPanel custom_even = new JPanel(new MigLayout("", "[]25[]", "[]25[]"));
    private final JPanel custom_odd = new JPanel(new MigLayout("", "[]25[]", "[]25[]"));
    private final JPanel even1_panel = new JPanel(new MigLayout());
    private final JPanel even2_panel = new JPanel(new MigLayout());
    private final JPanel even3_panel = new JPanel(new MigLayout());
    private final JPanel even4_panel = new JPanel(new MigLayout());
    private final JPanel odd1_panel = new JPanel(new MigLayout());
    private final JPanel odd2_panel = new JPanel(new MigLayout());
    private final JPanel odd3_panel = new JPanel(new MigLayout());
    private final JPanel custom_confirm = new JPanel(new MigLayout("", "[]", "[][]"));
    private final JLabel confirm_text = new JLabel("Add To Order");
    private final JLabel confirm_price = new JLabel("$0.00");
    private final JLabel clear_text = new JLabel("Clear Selected");
    private final JLabel amt_plus = new JLabel("+");
    private final JLabel amt_minus = new JLabel("-");
    private final JLabel amt_value = new JLabel("1");
    private final JLabel even1_label = new JLabel();
    private final JLabel even2_label = new JLabel();
    private final JLabel even3_label = new JLabel();
    private final JLabel even4_label = new JLabel();
    private final JLabel odd1_label = new JLabel();
    private final JLabel odd2_label = new JLabel();
    private final JLabel odd3_label = new JLabel();
    private final JPanel custom_rice = new JPanel(new MigLayout());
    private final JLabel rice_text = new JLabel("Edit Rice Option");
    private final JLabel rice_name = new JLabel("None");
    private final JLabel ricep_text = new JLabel();
    private final JLabel eggroll2_text = new JLabel("w/ Pork Egg Roll");
    private final JLabel eggroll3_text = new JLabel("w/ Pork Egg Roll");
    private final JLabel eggroll4_text = new JLabel("w/ Pork Egg Roll");

    // Initialize variables for the continue page
    private final JPanel continue_page = new JPanel(new MigLayout("fill, insets 0", "[]", "[][0][]"));
    private final JPanel continue_comp = new JPanel(new MigLayout());
    private final JPanel continue_cont = new JPanel(new MigLayout());
    private final JPanel continue_edit = new JPanel(new MigLayout());
    private final JLabel con_comp_text = new JLabel("Complete Order");
    private final JLabel con_cont_text = new JLabel("Continue Ordering");
    private final JLabel con_edit_text = new JLabel("Edit Order");
    
    // Initialize variables for the complete page
    private final JPanel complete_page = new JPanel(new MigLayout("fill", "[]", "[][]"));
    private final JPanel complete_card = new JPanel(new MigLayout("insets 0", "[]", "[][]"));
    private final JLabel card_text = new JLabel("Order Number");
    private final JLabel card_number = new JLabel();
    private final JLabel complete_total = new JLabel();
    
    // Initialize variables for the cancel page
    private final JPanel cancel_page = new JPanel(new MigLayout("fill", "[]50[]", "[]50[]"));
    private final JPanel cancel_bann = new JPanel(new MigLayout());
    private final JPanel cancel_canc = new JPanel(new MigLayout());
    private final JPanel cancel_edit = new JPanel(new MigLayout());
    private final JPanel cancel_comp = new JPanel(new MigLayout());
    private final JPanel cancel_cont = new JPanel(new MigLayout());
    private final JLabel cbann_text = new JLabel("Are you sure?");
    private final JLabel canc_text = new JLabel("<html>Cancel<br>Order</html>");
    private final JLabel edit_text = new JLabel("<html>  Edit<br>Order</html>");
    private final JLabel comp_text = new JLabel("<html>Complete<br>Order</html>");
    private final JLabel cont_text = new JLabel("<html>Continue<br>Order</html>");
    
    // Initialize variables for the edit page
    private final JPanel edit_page = new JPanel(new MigLayout("fill", "[][][][]", "[][][]20"));
    private final JPanel edit_bann = new JPanel(new MigLayout());
    private final JPanel edit_up = new JPanel(new MigLayout());
    private final JPanel edit_down = new JPanel(new MigLayout());
    private final JPanel edit_add = new JPanel(new MigLayout());
    private final JPanel edit_sub = new JPanel(new MigLayout());
    private final JPanel edit_undo = new JPanel(new MigLayout());
    private final JPanel edit_del = new JPanel(new MigLayout());
    private final JPanel edit_save = new JPanel(new MigLayout());
    private final JLabel ebann_text = new JLabel("Edit Order");
    private final JLabel up_text = new JLabel("Up");
    private final JLabel down_text = new JLabel("Down");
    private final JLabel add_text = new JLabel("+");
    private final JLabel sub_text = new JLabel("-");
    private final JLabel undo_text = new JLabel ("Undo");
    private final JLabel del_text = new JLabel("Delete");
    private final JLabel save_text = new JLabel("Save");
    private final JLabel quan_text = new JLabel("Edit Quantity");
    private final JTable edit_list = new JTable();
    private final JScrollPane edit_scroll = new JScrollPane(edit_list);
    private final JPanel ewhitebar_section = new JPanel(new MigLayout("insets 0"));
    private final JPanel eprice_section = new JPanel(new MigLayout("insets 5", "[][]", "[][][]"));
    private final JLabel eprice_left = new JLabel("<html>Subtotal<br>Tax<br>Final Total</html>");
    private final JLabel eprice_sub = new JLabel("$0.00");
    private final JLabel eprice_tax = new JLabel("$0.00");
    private final JLabel eprice_ftot = new JLabel("$0.00");
    private final JTable undo_list = new JTable();
    
    // Initialize variables for the timer page
    private final JPanel timer_page = new JPanel(new MigLayout("fill", "[]", "[][][]"));
    private final JPanel timer_bann = new JPanel(new MigLayout());
    private final JPanel timer_here = new JPanel(new MigLayout());
    private final JLabel tbann_text = new JLabel("Inactivity Timer");
    private final JLabel timer_text = new JLabel("Are You Still Here?");
    private final JLabel here_text = new JLabel("Continue Order");
    private final JLabel timer_cd = new JLabel("10");
    
    private ArrayList<String> qtyList = new ArrayList<>();
    private ArrayList<String> sizeList = new ArrayList<>();
    private ArrayList<String> itemList = new ArrayList<>();
    private ArrayList<String> priceList = new ArrayList<>();
    private ArrayList<String> sideList = new ArrayList<>();
    URL beep; ImageIcon food; Clip clip;
        
    public NewGarden() {
        
        // Initializes the beep audio file
        try{
            beep = getClass().getResource("beep.wav");
            AudioInputStream sound = AudioSystem.getAudioInputStream(beep);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e) {
            e.printStackTrace();
        };
        
        // Initializes beep file & card layouts
        CardLayout mainCL = (CardLayout) main.getLayout();
        CardLayout clickCL = (CardLayout) click.getLayout();
        
        // Initializes the sidebar table
        String[] columns = {"",""};
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        DefaultTableModel model = new DefaultTableModel(0, columns.length);
        model.setColumnIdentifiers(columns);
        order_list.setModel(model);
        order_list.setFont(sub_title);
        order_list.setRowHeight(30);
        order_list.setEnabled(false);
        order_scroll.setBorder(createEmptyBorder());
        order_list.getColumnModel().setColumnMargin(15);
        order_list.getColumnModel().getColumn(1).setPreferredWidth(300);
        order_list.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        order_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        
        // Initializes the edit table
        DefaultTableModel model2 = new DefaultTableModel(0, columns.length);
        model2.setColumnIdentifiers(columns);
        edit_list.setModel(model2);
        edit_list.setRowHeight(40);
        edit_list.setEnabled(false);
        edit_scroll.setBorder(createEmptyBorder());
        edit_list.setFont(new Font("Verdana", Font.BOLD, 32));
        edit_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        
        // Initializes a hidden table for undo
        DefaultTableModel model3 = new DefaultTableModel(0, columns.length);
        model3.setColumnIdentifiers(columns);
        undo_list.setModel(model3);
        
        // Designs the home page
        try {
            ImageIcon tempFood = new ImageIcon(getClass().getResource("food.jpg"));
            Image image = tempFood.getImage();
            Image tempImage = image.getScaledInstance(1100, 550, java.awt.Image.SCALE_SMOOTH);
            food = new ImageIcon(tempImage);
            home_image.setIcon(food);
            home_backdrop.add(home_image, "push, align center");
        } catch (Exception e) {
            System.out.println("Image can't be found!");
        }
        home_title.setFont(ban_title);
        home_touch.setFont(big_title);
        home_banner.setBackground(reddish);
        home_bar.setBackground(reddish);
        home_backdrop.setBackground(Color.black);
        home_banner.add(home_title, "push, align center");
        home_bar.add(home_touch, "push, align center");
        home_page.add(home_banner, "north");
        home_page.add(home_bar, "south");
        home_page.add(home_backdrop, "w 100%, h 100%");
        
        // Dynamically add the panels for the categories page
        StyleConstants.setAlignment(set, StyleConstants.ALIGN_CENTER);
        StyleConstants.setFontSize(set, 28);
        StyleConstants.setFontFamily(set, "verdana");
        for (int i=0; i<item_names.length; i++) {
            item_names[i] = new JTextPane();
            item_names[i].setEditable(false);
            item_names[i].setBackground(reddish);
            item_names[i].setHighlighter(null);
            item_names[i].setMargin(new Insets(4, 0, 0, 0));
            item_names[i].setParagraphAttributes(set, true);
            if ((i+1) % 4 == 0) {
                order_categ.add(item_names[i], "wrap, w 250, h 200");
            } else {
                order_categ.add(item_names[i], "w 250, h 200");
            }
            item_names[i].setVisible(false);
        }
        
        // Designs the categ page
        price_section.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
        sidebar_title.setFont(new Font("Verdana", Font.BOLD, 48));
        title.setFont(big_title);
        back_text.setFont(reg_title); 
        cancel_text.setFont(reg_title);
        price_left.setFont(sub_title);
        price_sub.setFont(sub_title);
        price_tax.setFont(sub_title);
        price_ftot.setFont(sub_title);
        whitebar_section.setBorder(outline);
        back_button.setBorder(outline);
        cancel_button.setBorder(outline);
        order_banner.setBorder(outline);
        back_button.setBackground(reddish);
        cancel_button.setBackground(reddish);
        order_banner.setBackground(reddish);
        order_sidebar.setBackground(reddish);
        sidebar_panel.setBackground(reddish);
        sidebar_buttons.setBackground(reddish);
        price_section.setBackground(Color.WHITE);
        back_button.add(back_text, "push, align center");
        cancel_button.add(cancel_text, "push, align center");
        order_banner.add(title, "push, align center, gapbottom 10");
        price_section.add(price_left, "spany 3");
        price_section.add(price_sub, "wrap, push, align right");
        price_section.add(price_tax, "wrap, align right");
        price_section.add(price_ftot, "align right");
        whitebar_section.add(order_scroll, "h 600");
        whitebar_section.add(price_section, "south, h 50");
        sidebar_panel.add(sidebar_title, "push, align center");
        sidebar_buttons.add(back_button, "w 50%, h 100");
        sidebar_buttons.add(cancel_button, "w 50%, h 100");
        order_sidebar.add(sidebar_panel, "north");
        order_sidebar.add(whitebar_section, "gaptop 10, h 650, wrap");
        order_sidebar.add(sidebar_buttons, "south");
        order_sidebar.add(back_button, "split 2, w 50%, h 100, gapbottom 5");
        order_sidebar.add(cancel_button, "w 50%, h 100, gapbottom 5");
        order_page.add(order_sidebar, "east, w 900");
        order_page.add(order_banner, "north, h 200, gapright 5");
        order_page.add(click, "w 100%, h 100%");
        
        // Designs the custom page
        amt_value.setFont(new Font("Verdana", Font.PLAIN, 64));
        eggroll2_text.setFont(sub_title);
        eggroll3_text.setFont(sub_title);
        eggroll4_text.setFont(sub_title);
        ricep_text.setFont(sub_title);
        rice_text.setFont(sub_title);
        rice_name.setFont(reg_title);
        clear_text.setFont(reg_title);
        confirm_text.setFont(reg_title);
        confirm_price.setFont(reg_title);
        amt_plus.setFont(ban_title);
        amt_minus.setFont(ban_title);
        even1_label.setFont(reg_title);
        even2_label.setFont(reg_title);
        even3_label.setFont(reg_title);
        even4_label.setFont(reg_title);
        even1_label.setFont(reg_title);
        odd1_label.setFont(reg_title);
        odd2_label.setFont(reg_title);
        odd3_label.setFont(reg_title);
        custom_quantity.setBorder(outline);
        custom_confirm.setBorder(outline);
        custom_clear.setBorder(outline);
        even1_panel.setBorder(outline);
        even2_panel.setBorder(outline);
        even3_panel.setBorder(outline);
        even4_panel.setBorder(outline);
        custom_rice.setBorder(outline);
        custom_quantity.setBackground(Color.WHITE);
        custom_amt.setBackground(Color.WHITE);
        custom_clear.setBackground(reddish);
        custom_confirm.setBackground(greyish);
        custom_add.setBackground(reddish);
        custom_sub.setBackground(greyish);
        even1_panel.setBackground(reddish);
        even2_panel.setBackground(reddish);
        even3_panel.setBackground(reddish);
        even4_panel.setBackground(reddish);
        odd1_panel.setBackground(reddish);
        odd2_panel.setBackground(reddish);
        odd3_panel.setBackground(reddish);
        custom_rice.setBackground(greyish);
        custom_rice.add(rice_name, "push, align center");
        even1_panel.add(even1_label, "push, align center");
        even2_panel.add(even2_label, "push, align center");
        even3_panel.add(even3_label, "push, align center");
        even4_panel.add(even4_label, "push, align center");
        odd1_panel.add(odd1_label, "push, align center");
        odd2_panel.add(odd2_label, "push, align center");
        odd3_panel.add(odd3_label, "push, align center");
        custom_even.add(even1_panel, "w 200, h 150"); 
        custom_even.add(even2_panel, "wrap, w 200, h 150, id egg2");
        custom_even.add(even3_panel, "w 200, h 150"); 
        custom_even.add(even4_panel, "w 200, h 150, id egg4");
        custom_odd.add(odd1_panel, "span 2, wrap, w 200, h 150, align center");
        custom_odd.add(odd2_panel, "w 200, h 150");
        custom_odd.add(odd3_panel, "w 200, h 150, id egg3");
        custom_sub.add(amt_minus, "push, align center");
        custom_amt.add(amt_value, "push, align center");
        custom_add.add(amt_plus, "push, align center");
        custom_quantity.add(custom_add, "east, w 130, h 100");
        custom_quantity.add(custom_amt, "center, w 130, h 100");
        custom_quantity.add(custom_sub, "west, w 130, h 100");
        custom_confirm.add(confirm_text, "align center, bottom, wrap");
        custom_confirm.add(confirm_price, "push, align center, top");
        custom_clear.add(clear_text, "push, align center");
        custom_page.add(custom_sizes, "spany 3, top, left, h 400");
        custom_page.add(custom_quantity, "wrap, center align, w 400, h 100");
        custom_page.add(custom_clear, "wrap, aligny top, gaptop 20, align center, w 300, h 75");
        custom_page.add(custom_rice, "wrap, aligny top, , gaptop 10, align center, w 300, h 75, id rice");
        custom_page.add(ricep_text, "pos (rice.x2 - 80) (rice.y2 - 105)");
        custom_page.add(rice_text, "pos (rice.x) (rice.y - 30)");
        custom_page.add(custom_confirm, "span, center align, w 30%, h 100");
        custom_even.add(eggroll2_text, "pos (egg2.x + 15) (egg2.y2 + 0.5)");
        custom_even.add(eggroll4_text, "pos (egg4.x + 15) (egg4.y2 + 0.5)");
        custom_odd.add(eggroll3_text, "pos (egg3.x + 15) (egg3.y2 + 0.5)");
        
        // Designs the continue page
        con_comp_text.setFont(big_title);
        con_cont_text.setFont(big_title);
        con_edit_text.setFont(big_title);
        continue_comp.setBorder(outline);
        continue_cont.setBorder(outline);
        continue_edit.setBorder(outline);
        continue_comp.setBackground(reddish);
        continue_cont.setBackground(reddish);
        continue_edit.setBackground(reddish);
        continue_comp.add(con_comp_text, "push, center align");
        continue_cont.add(con_cont_text, "push, center align");
        continue_edit.add(con_edit_text, "push, center align");
        continue_page.add(continue_comp, "wrap, w 100%, h 125, bottom");
        continue_page.add(continue_cont, "wrap, w 100%, h 125");
        continue_page.add(continue_edit, "w 100%, h 125, top");
        
        // Designs the complete page
        card_number.setFont(new Font("Verdana", Font.PLAIN, 132));
        complete_card.setBorder(outline);
        card_text.setFont(med_title);
        complete_total.setFont(med_title);
        complete_card.setBackground(Color.WHITE);
        complete_card.add(card_text, "top, align center, wrap");
        complete_card.add(card_number, "push, align center, gapbottom 20");
        complete_page.add(complete_card, "push, align center, wrap, w 350, h 200, bottom");
        complete_page.add(complete_total, "push, align center, top");
        
        // Designs the cancel page
        cbann_text.setFont(ban_title);
        canc_text.setFont(med_title);
        edit_text.setFont(med_title);
        comp_text.setFont(med_title);
        cont_text.setFont(med_title);
        cancel_bann.setBorder(outline);
        cancel_canc.setBorder(outline);
        cancel_edit.setBorder(outline);
        cancel_comp.setBorder(outline);
        cancel_cont.setBorder(outline);
        cancel_bann.setBackground(reddish);
        cancel_canc.setBackground(reddish);
        cancel_edit.setBackground(reddish);
        cancel_comp.setBackground(reddish);
        cancel_cont.setBackground(reddish);
        cancel_bann.add(cbann_text, "push, align center");
        cancel_canc.add(canc_text, "push, align center");
        cancel_edit.add(edit_text, "push, align center");
        cancel_comp.add(comp_text, "push, align center");
        cancel_cont.add(cont_text, "push, align center");
        cancel_page.add(cancel_bann, "north");
        cancel_page.add(cancel_canc, "w 300, h 200, bottom, right");
        cancel_page.add(cancel_edit, "w 300, h 200, bottom, left, wrap");
        cancel_page.add(cancel_comp, "w 300, h 200, top, right");
        cancel_page.add(cancel_cont, "w 300, h 200, top, left");
        
        // Designs the edit page
        eprice_section.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
        quan_text.setFont(sub_title);
        eprice_left.setFont(reg_title);
        eprice_sub.setFont(reg_title);
        eprice_tax.setFont(reg_title);
        eprice_ftot.setFont(reg_title);
        ebann_text.setFont(ban_title);
        up_text.setFont(reg_title);
        down_text.setFont(reg_title);
        sub_text.setFont(big_title);
        add_text.setFont(big_title);
        undo_text.setFont(reg_title);
        del_text.setFont(reg_title);
        save_text.setFont(reg_title);
        ewhitebar_section.setBorder(outline);
        edit_bann.setBorder(outline);
        edit_up.setBorder(outline);
        edit_down.setBorder(outline);
        edit_sub.setBorder(outline);
        edit_add.setBorder(outline);
        edit_undo.setBorder(outline);
        edit_del.setBorder(outline);
        edit_save.setBorder(outline);
        edit_bann.setBackground(reddish);
        edit_up.setBackground(greyish);
        edit_down.setBackground(reddish);
        edit_sub.setBackground(reddish);
        edit_add.setBackground(reddish);
        edit_undo.setBackground(greyish);
        edit_del.setBackground(reddish);
        edit_save.setBackground(reddish);
        eprice_section.setBackground(Color.WHITE);
        eprice_section.add(eprice_left, "spany 3");
        eprice_section.add(eprice_sub, "wrap, push, align right");
        eprice_section.add(eprice_tax, "wrap, align right");
        eprice_section.add(eprice_ftot, "align right");
        ewhitebar_section.add(edit_scroll, "w 100%, h 80%");
        ewhitebar_section.add(eprice_section, "south, w 100%, h 20%");
        edit_bann.add(ebann_text, "push, align center");
        edit_up.add(up_text, "push, align center");
        edit_down.add(down_text, "push, align center");
        edit_sub.add(sub_text, "push, align center");
        edit_add.add(add_text, "push, align center");
        edit_undo.add(undo_text, "push, align center");
        edit_del.add(del_text, "push, align center");
        edit_save.add(save_text, "push, align center");
        edit_page.add(edit_bann, "north");
        edit_page.add(ewhitebar_section, "span 3 2, top, left, w 75%, h 60%, gaptop 30, gapleft 40");
        edit_page.add(edit_up, "wrap, bottom, align center, w 150, h 200, left, gaptop 60, gapleft 20");
        edit_page.add(edit_down, "wrap, top, align center, w 150, h 200, left, gapleft 20");
        edit_page.add(edit_sub, "right, w 200, h 100, top, gapleft 100, id sub");
        edit_page.add(edit_add, "left, w 200, h 100, top, gapbottom 40");
        edit_page.add(quan_text, "pos (sub.x2 - 70) (sub.y2 + 5)");
        edit_page.add(edit_undo, "w 200, h 100, top, split 2, align center");
        edit_page.add(edit_del, "w 200, h 100, top, align center");
        edit_page.add(edit_save, "w 200, h 100, top, left, gapright 60");
        
        // Designs the timer page
        timer_cd.setFont(new Font("Verdana", Font.PLAIN, 144));
        tbann_text.setFont(ban_title);
        timer_text.setFont(big_title);
        here_text.setFont(big_title);
        timer_bann.setBorder(outline);
        timer_here.setBorder(outline);
        timer_bann.setBackground(reddish);
        timer_here.setBackground(reddish);
        timer_bann.add(tbann_text, "push, align center");
        timer_here.add(here_text, "push, align center");
        timer_page.add(timer_bann, "north");
        timer_page.add(timer_text, "align center, wrap, bottom, gaptop 100");
        timer_page.add(timer_here, "align center, wrap, w 500, h 150");
        timer_page.add(timer_cd, "align center, top, gapbottom 100");
        
        // Starts the ordering process
        home_page.addMouseListener(new MouseAdapter() { 
            @Override
            public void mousePressed(MouseEvent e) {
                timerAFK(); 
                clip.setFramePosition(0); clip.start();
                mainCL.show(main, "order");
                prevCard = "home"; 
                initCategories();
                cal.setTime(new Date());
                int currentHour = cal.get(Calendar.HOUR_OF_DAY);
                pastLunch = (currentHour >= 15 && currentHour <= 23);
                // If it's after 3pm, then lunch sizes are over
            }
        });
        
        // Goes back to the previous page
        back_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset();
                if ("cont".equals(prevCard) || ("home".equals(prevCard)) && order_list.getRowCount() == 0) {
                    mainCL.show(main, "home");
                    clickCL.show(click, "categ");
                    refreshSidebar(); refreshSelected();
                } else {
                    timerAFK();
                    clip.setFramePosition(0); clip.start();
                    if ("custom".equals(prevCard)) {
                        clickCL.show(click, "custom");
                        prevCard = "food";
                        ArrayList<String> prevCateg = MenuAccess.getItemCateg(prevTitle);
                        ArrayList<MenuSource> itemArray = MenuAccess.getAllFromCateg(prevCateg.get(0));
                        initFoods(itemArray);
                        title.setText(prevTitle);
                    } else if ("food".equals(prevCard)) {
                        clickCL.show(click, "categ");
                        prevCard = "categ";
                        ArrayList<String> menuArray = MenuAccess.getItemCateg(title.getText());
                        title.setText(menuArray.get(0));
                    } else if ("categ".equals(prevCard)) {
                        initCategories();
                        prevCard = "home";
                    } else if (order_list.getRowCount() > 0) {
                        mainCL.show(main, "cancel");
                    } else {
                        mainCL.show(main, "home");
                    }
                }
            }
        });
        
        // Displays cancellation options
        cancel_button.addMouseListener(new MouseAdapter() { 
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); 
                if (("cont".equals(prevCard)) || (("home".equals(prevCard)) && (order_list.getRowCount() == 0))) {
                    mainCL.show(main, "home");
                    clickCL.show(click, "categ");
                    refreshSidebar(); refreshSelected();
                } else {
                    timerAFK(); 
                    clip.setFramePosition(0); clip.start();
                    if (order_list.getRowCount() == 0) {
                        cancel_edit.setBackground(greyish);
                        cancel_comp.setBackground(greyish);
                    } else {
                        cancel_edit.setBackground(reddish);
                        cancel_comp.setBackground(reddish);
                    }
                    mainCL.show(main, "cancel");
                }         
            }
        });
        
        // Adds the item and changes to the order
        custom_confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                clip.setFramePosition(0); clip.start();
                if (!"$0.00".equals(confirm_price.getText())) {
                    String spacing = "";
                    String rice = "w/ ";
                    String rice_item = rice_name.getText().replaceAll("\\n"," ").trim();
                    for (String s : rice_item.split(" ")) {
                        if ("None".equals(s)) {
                            rice = "             ";
                            break;
                        } else if ("Regular".equals(s)) {
                            spacing = "   ";
                        } else if ("White".equals(s)) {
                            rice += "WR";
                            spacing = "  ";
                            break;
                        } else if ("Plain".equals(s)) {
                            rice += "Pl ";
                        } else if (s.charAt(0) == 'L') {
                            rice += "Lo";
                            break;
                        } else {
                            rice += s.charAt(0);
                            if (!rice_item.contains("Plain") && (!rice_item.contains("Regular"))) {
                                spacing = " ";
                            }
                        }
                    }
                    rice += spacing + "     ";
                    
                    String topData[] = {size_name, title.getText()};
                    String botData[] = {confirm_price.getText(), rice+"x"+amt_value.getText()};
                    DefaultTableModel model = (DefaultTableModel) order_list.getModel();
                    model.addRow(topData); model.addRow(botData);
                    order_list.scrollRectToVisible(order_list.getCellRect(order_list.getRowCount()-1, 0, true));
                    // Always scrolls to the bottom for the most recent addition
                    totalCalc(order_list, price_sub, price_tax, price_ftot);
                    clickCL.show(click, "cont");
                    prevCard = "custom";
                    prevTitle = title.getText();
                    title.setText("Complete Or Continue Editing");
                    continue_comp.setBackground(reddish);
                    continue_edit.setBackground(reddish);
                }
            }
        });
        
        // Clears all customization a user may have made
        custom_clear.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                clip.setFramePosition(0); clip.start();
                amt_value.setText("1");
                if ((odd2_panel.isVisible() == false) || (odd3_panel.isVisible() == false)) {
                    confirm_price.setText("$"+String.format("%.2f", size_price));
                    // reset large to WR
                } else {
                    refreshSelected();
                }
            }
        });
        
        // Adds the quantity on the custom page
        custom_add.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                clip.setFramePosition(0); clip.start();
                quantityAdjustment(1);  
            }
        });
        
        // Subtracts the quantity on the custom page
        custom_sub.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                clip.setFramePosition(0); clip.start();
                quantityAdjustment(-1); 
            }
        });
        
        // Changes size and prices for this specific button
        even1_panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                clip.setFramePosition(0); clip.start();
                riceInit(even1_label);
                sizeButtons(even1_panel, even1_label);
            }
        });
        
        // Changes size and prices for this specific button
        even2_panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                clip.setFramePosition(0); clip.start();
                riceInit(even2_label);
                sizeButtons(even2_panel, even2_label); 
            }
        });
        
        // Changes size and prices for this specific button
        even3_panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                clip.setFramePosition(0); clip.start();
                if (pastLunch == false) {
                    riceInit(even3_label);
                    sizeButtons(even3_panel, even3_label);
                }
            }
        });
        
        // Changes size and prices for this specific button
        even4_panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                clip.setFramePosition(0); clip.start();
                riceInit(even4_label);
                sizeButtons(even4_panel, even4_label);
            }
        });
        
        // Changes size and prices for this specific button
        odd1_panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                clip.setFramePosition(0); clip.start();
                riceInit(odd1_label);
                sizeButtons(odd1_panel, odd1_label);
            }
        });
        
        // Changes size and prices for this specific button
        odd2_panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                clip.setFramePosition(0); clip.start();
                if (pastLunch == false) {
                    riceInit(odd2_label);
                    sizeButtons(odd2_panel, odd2_label);
                }
            }
        });
        
        // Changes size and prices for this specific button
        odd3_panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                clip.setFramePosition(0); clip.start();
                riceInit(odd3_label);
                sizeButtons(odd3_panel, odd3_label);
            }
        });
        
        // Initializes the categories page depending on which is needed
        for (int i=0; i<item_names.length; i++) {
            final int x = i;
            item_names[x].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    timerReset(); timerAFK();
                    clip.setFramePosition(0); clip.start();
                    if ("home".equals(prevCard)) {
                        ArrayList<MenuSource> itemArray = MenuAccess.getAllFromCateg(item_names[x].getText().trim());
                        title.setText(item_names[x].getText());
                        initFoods(itemArray);
                        prevCard = "categ";
                    } else if ("custom".equals(prevCard)) {
                        clickCL.show(click, "custom");
                        prevCard = "food";
                        title.setText(prevTitle);
                        rice_name.setText(item_names[x].getText().replaceAll("\\n"," ").trim());
                        ArrayList<MenuSides> riceArray = MenuAccess.getSidePrices(item_names[x].getText().replaceAll("\\n"," ").trim());
                        MenuSides rice_size = riceArray.get(0);
                        String price = "";
                        if ("Small".equals(size_name)) {
                            if (rice_size.getSizeOne() > 0) {
                                price = "+$"+String.format("%.2f", rice_size.getSizeOne());
                            }
                        } else if ("Large".equals(size_name)) {
                            if (rice_size.getSizeTwo() > 0) {
                                price = "+$"+String.format("%.2f", rice_size.getSizeTwo());
                            }
                        } else {
                            if (rice_size.getSizeThree() > 0) {     // Accounts for both lunch/combo
                                price = "+$"+String.format("%.2f", rice_size.getSizeThree());
                            }
                        }
                        ricep_text.setText(price);
                        double rice_price = 0;
                        if (!"".equals(ricep_text.getText())) {
                            rice_price = Double.parseDouble(ricep_text.getText().substring(ricep_text.getText().indexOf('$')+1));
                        }
                        int intQuantity = Integer.parseInt(amt_value.getText());
                        confirm_price.setText("$"+String.format("%.2f", (size_price + rice_price) * intQuantity));
                        ArrayList<String> prevCateg = MenuAccess.getItemCateg(prevTitle);
                        ArrayList<MenuSource> itemArray = MenuAccess.getAllFromCateg(prevCateg.get(0));
                        initFoods(itemArray);
                    } else {
                        if (pastLunch == true) {
                            even3_panel.setBackground(greyish);
                            odd2_panel.setBackground(greyish);
                        }
                        title.setText(item_names[x].getText().replaceAll("\\n"," ").trim());
                        clickCL.show(click, "custom");
                        refreshSelected();
                        prevCard = "food";
                        ArrayList<MenuSizes> menuArray = MenuAccess.getItemSizes(title.getText());
                        MenuSizes menuItem = menuArray.get(0);
                        double size1 = menuItem.getSizeOne();
                        double size2 = menuItem.getSizeTwo();
                        double size3 = menuItem.getSizeThree();
                        double size4 = menuItem.getSizeFour();
                        double[] sizeCount = {size1, size2, size3, size4};
                        int counter = 0;
                        for (int i=0; i < sizeCount.length; i++) {
                            if (sizeCount[i] > 0) {
                                counter++;
                            }               // Checks the item to see how many sizes exist
                        }
                        eggroll2_text.setVisible(false);
                        eggroll3_text.setVisible(false);
                        eggroll4_text.setVisible(false);
                        rice_name.setText("None");
                        custom_rice.setBackground(greyish);
                        custom_sub.setBackground(greyish);
                        confirm_price.setText("$0.00");
                        size_name = "";
                        CardLayout sizeCL = (CardLayout) custom_sizes.getLayout();
                        switch (counter) {
                            case 1:                     // Accounts for Large or Regular size
                                sizeCL.show(custom_sizes, "odd");
                                odd2_panel.setVisible(false);
                                odd3_panel.setVisible(false);
                                if (size1 > 0) {
                                    size_name = "Regular";
                                    size_price = size1;
                                    odd1_label.setText("<html>Regular<br>$"+String.format("%.2f", size1)+"</html>");
                                } else if (size2 > 0) {
                                    size_name = "Large";
                                    size_price = size2;
                                    odd1_label.setText("<html>Large<br>$"+String.format("%.2f", size2)+"</html>");
                                    rice_name.setText("White Rice");
                                    custom_rice.setBackground(reddish);
                                    riceCheck = true;
                                }
                                confirm_price.setText("$"+String.format("%.2f", size_price));
                                custom_confirm.setBackground(reddish);
                                odd1_panel.setBorder(BorderFactory.createLineBorder(Color.black, 5));
                                break;
                            case 2:                     // Accounts for Small or Large / Large or Combo size
                                sizeCL.show(custom_sizes, "even");
                                even3_panel.setVisible(false);
                                even4_panel.setVisible(false);
                                if (size1 > 0) {
                                    even1_label.setText("<html>Small<br>$"+String.format("%.2f", size1)+"</html>");
                                    even2_label.setText("<html>Large<br>$"+String.format("%.2f", size2)+"</html>");
                                } else if (size4 > 0) {
                                    even1_label.setText("<html>Large<br>$"+String.format("%.2f", size2)+"</html>");
                                    even2_label.setText("<html>Combo<br>$"+String.format("%.2f", size4)+"</html>");
                                    eggroll2_text.setVisible(true);
                                }
                                break;
                            case 3:                     // Accounts for Large, Lunch, or Combo size
                                sizeCL.show(custom_sizes, "odd");
                                odd2_panel.setVisible(true);
                                odd3_panel.setVisible(true);
                                odd1_label.setText("<html>Large<br>$"+String.format("%.2f", size2)+"</html>");
                                odd2_label.setText("<html>Lunch<br>$"+String.format("%.2f", size3)+"</html>");
                                odd3_label.setText("<html>Combo<br>$"+String.format("%.2f", size4)+"</html>");
                                eggroll3_text.setVisible(true);
                                break;
                            case 4:                     // Accounts for items that have all four sizes
                                sizeCL.show(custom_sizes, "even");
                                even3_panel.setVisible(true);
                                even4_panel.setVisible(true);
                                even1_label.setText("<html>Small<br>$"+String.format("%.2f", size1)+"</html>");
                                even2_label.setText("<html>Large<br>$"+String.format("%.2f", size2)+"</html>");
                                even3_label.setText("<html>Lunch<br>$"+String.format("%.2f", size3)+"</html>");
                                even4_label.setText("<html>Combo<br>$"+String.format("%.2f", size4)+"</html>");
                                eggroll4_text.setVisible(true);
                                break;
                            default:
                                break;
                        }
                    }
                } 
            });
        }
        
        // Allows the user to edit their items
        MouseAdapter edit_button = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK(); clip.start();
                if (order_list.getRowCount() > 0) {
                    prevEdit = true;
                    mainCL.show(main, "edit");
                    setupTable(edit_list, order_list);
                    rowEdit = 0;
                    edit_list.setRowSelectionInterval(0,1);
                    totalCalc(edit_list, eprice_sub, eprice_tax, eprice_ftot);
                    String cell2 = edit_list.getValueAt(1, 1).toString();
                    if (Integer.parseInt(cell2.replaceAll("\\D+","")) == 1) {
                        edit_sub.setBackground(greyish);
                    } else {
                        edit_sub.setBackground(reddish);
                    }
                    if (edit_list.getRowCount() == 2) {
                        edit_down.setBackground(greyish);
                    } else {
                        edit_down.setBackground(reddish);
                    }
                    edit_del.setBackground(reddish);
                    edit_up.setBackground(greyish);
                }
            }
        };
        continue_edit.addMouseListener(edit_button);
        cancel_edit.addMouseListener(edit_button);
        
        // Completes the order after custom page
        continue_comp.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerHome();
                clip.setFramePosition(0); clip.start();
                if (order_list.getRowCount() > 0) {
                    clickCL.show(click, "comp");
                    prevCard = "cont";
                    title.setText("Thank you for ordering! :)");
                    complete_total.setText("Your total is "+price_ftot.getText());
                    card_number.setText(String.valueOf(++order_number));
                    if (order_number >= 99) {
                        order_number = 1;
                    }
                    orderStats();
                    finalizeOrder();
                    printReceipt();
                }
            }
        });
        
        // Continues the order after custom page
        continue_cont.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                clip.setFramePosition(0); clip.start();
                clickCL.show(click, "categ");
                prevCard = "home";
                initCategories();
            }
        });
        
        // Cancels the order
        cancel_canc.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                clip.setFramePosition(0); clip.start();
                mainCL.show(main, "home");
                clickCL.show(click, "categ");
                refreshSidebar(); refreshSelected();
            }
        });
        
        // Completes order from cancel page
        cancel_comp.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerHome();
                clip.setFramePosition(0); clip.start();
                if (order_list.getRowCount() > 0) {
                    mainCL.show(main, "order");
                    clickCL.show(click, "comp");
                    prevCard = "cont";
                    title.setText("Thank you for ordering! :)");
                    complete_total.setText("Your total is "+price_ftot.getText());
                    card_number.setText(String.valueOf(++order_number));
                    if (order_number >= 99) {
                        order_number = 1;
                    }
                    orderStats();
                    finalizeOrder();
                    printReceipt();
                }
            }
        });
        
        // Continue ordering from cancel page
        cancel_cont.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                clip.setFramePosition(0); clip.start();
                mainCL.show(main, "order");
                if ("custom".equals(prevCard)) {
                    clickCL.show(click, "categ");
                    initCategories();
                    prevCard = "home";
                }
            }
        });
        
        // Scrolls up to the next item
        edit_up.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                if ((rowEdit-2) >= 0) {
                    rowEdit-=2;
                    edit_list.getSelectionModel().setSelectionInterval(rowEdit, rowEdit+1);
                    edit_list.scrollRectToVisible(new Rectangle(edit_list.getCellRect(rowEdit, 0, true)));
                    // If row selection out of view, adjust scrollbar
                    edit_down.setBackground(reddish);
                }
                if ((rowEdit-2) < 0) {
                    edit_up.setBackground(greyish);
                }
                String cell2 = edit_list.getValueAt(rowEdit+1, 1).toString();
                if (Integer.parseInt(cell2.replaceAll("\\D+","")) == 1) {
                    edit_sub.setBackground(greyish);
                } else {
                    edit_sub.setBackground(reddish);
                }
            }
        });
        
        // Scrolls down to the next item
        edit_down.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                if ((rowEdit+2) < edit_list.getRowCount()) {
                    rowEdit+=2;
                    edit_list.getSelectionModel().setSelectionInterval(rowEdit, rowEdit+1);
                    edit_list.scrollRectToVisible(new Rectangle(edit_list.getCellRect(rowEdit+1, 0, true)));
                    // If row selection out of view, adjust scrollbar
                    edit_up.setBackground(reddish);
                }
                if ((rowEdit+2) >= edit_list.getRowCount()) {
                    edit_down.setBackground(greyish);
                }
                String cell2 = edit_list.getValueAt(rowEdit+1, 1).toString();
                if (Integer.parseInt(cell2.replaceAll("\\D+","")) == 1) {
                    edit_sub.setBackground(greyish);
                } else {
                    edit_sub.setBackground(reddish);
                }
            }
        });
        
        // Adds a quantity of selected item
        edit_add.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                quantityAdjustmentEdits(1);
                totalCalc(edit_list, eprice_sub, eprice_tax, eprice_ftot);
            }
        });
        
        // Subtracts a quantity of selected item
        edit_sub.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                quantityAdjustmentEdits(-1);
                totalCalc(edit_list, eprice_sub, eprice_tax, eprice_ftot);
            }
        });
        
        // Deletes the selected item from the list
        edit_del.addMouseListener(new MouseAdapter() {
            @Override   // 
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                if (edit_list.getRowCount() > 0) {
                    DefaultTableModel model = (DefaultTableModel) edit_list.getModel();
                    DefaultTableModel model2 = (DefaultTableModel) undo_list.getModel();
                    for (int i=0; i < 2; i++) {
                        String cell1 = model.getValueAt(rowEdit, 0).toString();
                        String cell2 = model.getValueAt(rowEdit, 1).toString();
                        model.removeRow(rowEdit); 
                        String data[] = {cell1, cell2};
                        model2.addRow(data);
                    }
                    rowEdit = 0;
                    edit_undo.setBackground(reddish);
                    totalCalc(edit_list, eprice_sub, eprice_tax, eprice_ftot);
                    if (edit_list.getRowCount() == 0) {
                        edit_del.setBackground(greyish);
                    } else {
                        edit_list.setRowSelectionInterval(0, 1);

                    }
                }
            }
        });
        
        // Undoes any deletion the user may have made
        edit_undo.addMouseListener(new MouseAdapter() {
            @Override  
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                if (undo_list.getRowCount() > 0) {
                    DefaultTableModel model = (DefaultTableModel) undo_list.getModel();
                    DefaultTableModel model2 = (DefaultTableModel) edit_list.getModel();
                    for (int i=0; i < 2; i++) {
                        String cell1 = model.getValueAt(0, 0).toString();
                        String cell2 = model.getValueAt(0, 1).toString();
                        model.removeRow(rowEdit); 
                        String data[] = {cell1, cell2};
                        model2.addRow(data);
                    }
                    edit_list.setRowSelectionInterval(0, 1);
                    edit_del.setBackground(reddish);
                    totalCalc(edit_list, eprice_sub, eprice_tax, eprice_ftot);
                    if (undo_list.getRowCount() == 0) {
                        edit_undo.setBackground(greyish);
                    }
                }
            }
        });
        
        // Saves the changes made on the edit page
        edit_save.addMouseListener(new MouseAdapter() {
            @Override   
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                clip.setFramePosition(0); clip.start();
                prevEdit = false;
                mainCL.show(main, "order");
                clickCL.show(click, "cont");
                setupTable(order_list, edit_list);
                totalCalc(order_list, price_sub, price_tax, price_ftot);
                title.setText("Complete or Continue Editing");
                if (order_list.getRowCount() == 0) {
                    continue_comp.setBackground(greyish);
                    continue_edit.setBackground(greyish);
                }
                DefaultTableModel model = (DefaultTableModel) undo_list.getModel();
                for (int i = undo_list.getRowCount()-1; i >= 0; i--) {
                    model.removeRow(i);
                }
                edit_undo.setBackground(greyish);
            }
        });
        
        // Initializes the rice selection
        custom_rice.addMouseListener(new MouseAdapter() {
            @Override  
            public void mousePressed(MouseEvent e) {
                timerReset(); timerAFK();
                clip.setFramePosition(0); clip.start();
                if (riceCheck == true) {
                    clickCL.show(click, "categ");
                    prevCard = "custom";
                    prevTitle = title.getText();
                    title.setText("Rice Replacement");
                    ArrayList<String> sideArray = MenuAccess.getAllSides();
                    for (int i=0; i<sideArray.size(); i++) {
                        if (("Small".equals(size_name)) && (i>7) && (i != 15)) {
                            item_names[i].setVisible(false);
                        } else {
                            if (i == 15) {
                                item_names[i].setText("\n"+sideArray.get(i));
                            } else {
                                ArrayList<MenuSource> halfArray = MenuAccess.getItemHalves(sideArray.get(i));
                                MenuSource half = halfArray.get(0); 
                                    item_names[i].setText("\n"+half.getHalf1()+"\n"+half.getHalf2());
                            }
                            item_names[i].setVisible(true);
                            item_names[i].setBorder(outline);
                        }
                    }
                }
            }
        });
        
        // Ensures that the user is still active
        timer_page.addMouseListener(new MouseAdapter() {
            @Override   
            public void mousePressed(MouseEvent e) {
                timerAFK();
                clip.setFramePosition(0); clip.start();
                timerCheck = false;
                if (prevEdit == true) {
                    mainCL.show(main, "edit");
                } else {
                    mainCL.show(main, "order");
                }
            }
        });
        
        // Adds all the pages to their corresponding layouts
        custom_sizes.add(custom_even, "even");
        custom_sizes.add(custom_odd, "odd");
        click.add(order_categ, "categ");
        click.add(custom_page, "custom");
        click.add(continue_page, "cont");
        click.add(complete_page, "comp");
        main.add(home_page, "home");
        main.add(order_page, "order");
        main.add(cancel_page, "cancel");
        main.add(edit_page, "edit");
        main.add(timer_page, "timer");
        frame.add(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("New Garden");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width,screenSize.height);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
    
    // Calculates the total of order depending on the table
    private void totalCalc(JTable table, JLabel sub, JLabel taxes, JLabel ftot) {
        double subtotals = 0;
        for (int i=1; i < table.getRowCount(); i+=2) {
                subtotals += Double.parseDouble((table.getValueAt(i, 0).toString()).substring(1));
        }
        sub.setText("$"+String.format("%.2f", subtotals));
        taxes.setText("$"+String.format("%.2f", (subtotals * (tax-1))));
        ftot.setText("$"+String.format("%.2f", (subtotals * (tax))));
    }
    
    // Adjusts the quantity of item on the custom page
    private void quantityAdjustment(int posneg) {
        int intQuantity = Integer.parseInt(amt_value.getText());
        intQuantity += posneg;
        if (intQuantity > 0) {
            double rice_price = 0;
            if (!"".equals(ricep_text.getText())) {
                rice_price = Double.parseDouble(ricep_text.getText().substring(ricep_text.getText().indexOf('$')+1));
            }
            amt_value.setText(String.valueOf(intQuantity));
            confirm_price.setText("$"+String.format("%.2f", (size_price + rice_price) * intQuantity));
            if (intQuantity == 1) {
                custom_sub.setBackground(greyish);
            } else {
                custom_sub.setBackground(reddish);
            }
        }
    }
    
    // Adjusts item total and size selection
    private void sizeButtons(JPanel box, JLabel sizeprice) {
        even1_panel.setBorder(outline);
        even2_panel.setBorder(outline);
        even3_panel.setBorder(outline);
        even4_panel.setBorder(outline);
        odd1_panel.setBorder(outline);
        odd2_panel.setBorder(outline);
        odd3_panel.setBorder(outline);
        
        ricep_text.setText("");
        String tempsizeprice = Jsoup.parse(sizeprice.getText()).text();
        size_name = tempsizeprice.substring(0, tempsizeprice.indexOf(' '));
        size_price = Double.parseDouble(tempsizeprice.substring(tempsizeprice.indexOf('$')+1));
        int intQuantity = Integer.parseInt(amt_value.getText());
        confirm_price.setText("$"+String.format("%.2f", size_price * intQuantity));
        custom_confirm.setBackground(reddish);
        box.setBorder(BorderFactory.createLineBorder(Color.black, 5));
    }
    
    // Initializes category page
    private void initCategories() {
        title.setText("Categories");
        ArrayList<String> menuArray = MenuAccess.getAllCateg();
        for (int i=0; i<menuArray.size(); i++) { 
            item_names[i].setText("\n"+menuArray.get(i));
            item_names[i].setVisible(true);
            item_names[i].setBorder(outline);
        }
        for (int i=15; i>=menuArray.size(); i--) {
            item_names[i].setVisible(false);
        }
    }
    
    // Initializes foods page
    private void initFoods(ArrayList<MenuSource> itemArray) {
        for (int j=0; j<itemArray.size(); j++) {
            MenuSource item = itemArray.get(j);
            item_names[j].setText("\n"+item.getHalf1()+'\n'+item.getHalf2());
            item_names[j].setVisible(true);
            item_names[j].setBorder(outline);
        }
        for (int j=15; j>=itemArray.size(); j--) {
            item_names[j].setText("");
            item_names[j].setVisible(false);
        }
    }
    
    // Refreshes items in order
    private void refreshSidebar() {
        DefaultTableModel model = (DefaultTableModel) order_list.getModel();
        model.setRowCount(0);
        price_sub.setText("$0.00");
        price_tax.setText("$0.00");
        price_ftot.setText("$0.00");
    }
    
    // Refreshes selected sizes
    private void refreshSelected() {
        size_name = "";
        size_price = 0.00;
        amt_value.setText("1");
        confirm_price.setText("$0.00");
        custom_confirm.setBackground(greyish);
        even1_panel.setBorder(outline);
        even2_panel.setBorder(outline);
        even3_panel.setBorder(outline);
        even4_panel.setBorder(outline);
        odd1_panel.setBorder(outline);
        odd2_panel.setBorder(outline);
        odd3_panel.setBorder(outline);
        rice_name.setText("None");
        ricep_text.setText("");
        riceCheck = false;
        custom_rice.setBackground(greyish);
    }
    
    // Clears the table and restructure with the data from another table
    private void setupTable(JTable copyTo, JTable copyFrom) {
        String cell1 = ""; String cell2 = "";
        DefaultTableModel model = (DefaultTableModel) copyTo.getModel();
        for (int i = copyTo.getRowCount()-1; i >= 0; i--) {
            model.removeRow(i);
        }
        for (int x = 0; x < copyFrom.getRowCount(); x++) {
            for (int y = 0; y < copyFrom.getColumnCount(); y++) {
                if ("".equals(cell1)) {
                    cell1 = copyFrom.getValueAt(x, y).toString();                   
                } else {
                    cell2 = copyFrom.getValueAt(x, y).toString();
                }
            } 
            String data[] = {cell1, cell2};
            model.addRow(data);
            cell1 = ""; cell2 = "";
        }
    }
    
    // Adjusts the quantity of an item on the edit page
    private void quantityAdjustmentEdits(int posneg) {
        if (edit_list.getRowCount() > 0) {
            String cell2 = edit_list.getValueAt(rowEdit+1, 1).toString();
            String rice = cell2.substring(0, cell2.indexOf("x"));
            int intQuantity = Integer.parseInt(cell2.replaceAll("\\D+",""));
            intQuantity += posneg;
            if (intQuantity > 0) {
                String cell1 = edit_list.getValueAt(rowEdit+1, 0).toString();
                double dubPrice = Double.parseDouble(cell1.substring(1));
                dubPrice += (dubPrice / (intQuantity -= posneg) * posneg);
                // Gets the unit price of each item
                String data[] = {"$"+String.format("%.2f", dubPrice), rice+"x"+(intQuantity += posneg)};
                DefaultTableModel model = (DefaultTableModel) edit_list.getModel();
                model.removeRow(rowEdit+1);
                model.insertRow(rowEdit+1, data);
                edit_list.setRowSelectionInterval(rowEdit,rowEdit+1);
                if (intQuantity == 1) {
                    edit_sub.setBackground(greyish);
                } else {
                    edit_sub.setBackground(reddish);
                }
            }
        }
    }
    
    // Updates item statistics of amount of times ordered
    private void orderStats() {
        for (int i=0; i < order_list.getRowCount(); i+=2) {
            String cell = order_list.getValueAt(i+1, 1).toString();
            int quantity = Integer.parseInt(cell.replaceAll("\\D+",""));
            String item = order_list.getValueAt(i, 1).toString();
            ArrayList<Integer> menuArray = MenuAccess.getItemAmt(item);
            int newAmount = menuArray.get(0) + quantity;
            MenuAccess.updateItem(newAmount, item);
        }
    }

    // Initializes what rice corresponds to selected item
    private void riceInit(JLabel sizeLabel) {
        String sandp = Jsoup.parse(sizeLabel.getText()).text();
        String curr_size = sandp.substring(0, sandp.indexOf(' '));
        if (!size_name.equals(curr_size)) {
            rice_name.setText("None");
            riceCheck = false;
            custom_rice.setBackground(greyish);
            if (("Large".equals(curr_size)) || ("Small".equals(curr_size))) {
                ArrayList<String> menuArray = MenuAccess.getItemCateg(title.getText());
                String category = menuArray.get(0);
                if (!"Fried Rice".equals(category) && !"Soup".equals(category) && (!category.equals("Appetizer")) && (!category.equals("Side Order"))) {
                        if ((!"Lo Mein".equals(category)) && (!"Mai Fun".equals(category)) && (!"Boneless Spare Ribs".equals(title.getText()))) { 
                            rice_name.setText("White Rice");
                            custom_rice.setBackground(reddish);
                            riceCheck = true;
                        }
                    }   
            } else if (("Combo".equals(curr_size)) || ("Lunch".equals(curr_size))) {
                rice_name.setText("Pork Fried Rice");
                custom_rice.setBackground(reddish);
                riceCheck = true;
            }
        }
    }
    
    // Resets the AFK timer
    private void timerAFK() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                CardLayout mainCL = (CardLayout) main.getLayout();
                mainCL.show(main, "timer");
                timerCheck = true;
                timerFinal();
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 15000);
    }
    
    // Resets the timer
    private void timerReset() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                
            }
        };
        timer.cancel();
        timer = new Timer();
        timer.schedule(timerTask, 1000);
    }
    
    // Return to home after completing order
    private void timerHome() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                CardLayout mainCL = (CardLayout) main.getLayout();
                CardLayout clickCL = (CardLayout) click.getLayout();
                mainCL.show(main, "home");
                clickCL.show(click, "categ");
                refreshSidebar();
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 10000);
    }
    
    // The final countdown before user is sent back to home screen
    private void timerFinal() {
        try {
            for (int i = 10; i >= 0; i--) {
                timer_cd.setText(String.valueOf(i));
                Thread.sleep(1000);
                // Countdown from 10 every second
            }
        } catch (InterruptedException e) {
             e.printStackTrace();
    }
    if (timerCheck == true) {
        CardLayout mainCL = (CardLayout) main.getLayout();
        CardLayout clickCL = (CardLayout) click.getLayout();
        mainCL.show(main, "home");
        clickCL.show(click, "categ");
        refreshSidebar();
        timerCheck = false;
        }
    } 
    
    // Adds item details to arraylists for printing
    private void finalizeOrder() {
        for (int x=0; x < order_list.getRowCount(); x++) {
            for (int y=0; y < order_list.getColumnCount(); y++) {
                if (y % 2 == 0) {           // Column 1
                    if (x % 2 == 0) {       // Size
                        String tempSize = "";
                        if ("Small".equals(order_list.getValueAt(x, y).toString())) {
                            tempSize = "Sm";
                        } else if ("Large".equals(order_list.getValueAt(x, y).toString())) {
                            tempSize = "Lg";
                        } else if ("Lunch".equals(order_list.getValueAt(x, y).toString())) {
                            tempSize = "L ";
                        } else if ("Combo".equals(order_list.getValueAt(x, y).toString())) {
                            tempSize = "C ";
                        } 
                        sizeList.add(tempSize);
                    } else {                // Price
                        String spacer = "";
                        if (order_list.getValueAt(x, y).toString().length() == 5) {
                            spacer = " ";
                        }
                        priceList.add(spacer + order_list.getValueAt(x, y).toString().substring(1));
                    }
                } else {                    // Column 2
                    if (x % 2 == 0) {       // Item
                        itemList.add(order_list.getValueAt(x, y).toString());
                    } else {                // Side/Qty
                        String strSideQty = order_list.getValueAt(x, y).toString();
                        qtyList.add(strSideQty.replaceAll("\\D+", ""));
                        // Fix this
                        sideList.add(strSideQty.substring(0, strSideQty.indexOf("x")));
                    }
                }
            }
        }
    }
    
    // Method for units conversion for print
    protected static double CM_to_PP(double cm) {            
        return (cm * 0.393600787) * 72d;            
    }
    
    // Prints the receipt
    private void printReceipt() {
        Printable contentToPrint = new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {                                                      
                if (pageIndex > 0) {
                    return NO_SUCH_PAGE;
                    // A single page is zero-based
                }
                Graphics2D g2d = (Graphics2D) graphics;
                g2d.setFont(new Font("Arial", Font.BOLD, 30));
                g2d.translate(pageFormat.getImageableX(),pageFormat.getImageableY());
                // Translate X and Y values to page format to avoid clipping
                
                Date currentDate = new Date();
                SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                String time = timeFormat.format(currentDate);
                String date = dateFormat.format(currentDate);
                int y = 30;
                g2d.drawString("Order #"+order_number, 40, y); y+=10;
                g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
                g2d.drawString("------------------------------------",10,y);y+=10;
                g2d.drawString("   New Garden Chinese Restaurant",12,y);y+=10;
                g2d.drawString("       #### ******* **** **    ",12,y);y+=10;
                g2d.drawString("       *********** **, #####    ",12,y);y+=10;
                g2d.drawString("          (###) ###-####       ",12,y);y+=10;
                g2d.drawString("------------------------------------",10,y);y+=10;
                g2d.drawString(" Order #"+order_number+"          "+time+" "+date,10,y);y+=10;
                g2d.drawString(" QTY  ITEM                    TOTAL",10,y);y+=10;
                
                for (int i=0; i < itemList.size(); i++) {
                    g2d.drawString(" "+qtyList.get(i)+" "+sizeList.get(i)+" "+itemList.get(i), 10, y);
                    g2d.drawString(priceList.get(i)+" ", 160, y); y+=10;
                    if (sideList.get(i).contains("w/")) {
                        g2d.drawString("        "+sideList.get(i), 10, y); y+=10;
                    }
                } y+=10;  
                String spacer = ""; String spacer2 = "";
                if (price_sub.getText().length() == 5) {
                    spacer = " ";
                }
                if (price_ftot.getText().length() == 5) {
                    spacer2 = " ";
                }
                
                g2d.drawString(" Subtotal:", 10, y); g2d.drawString(spacer+price_sub.getText().substring(1)+" ", 160, y); y+=10;
                g2d.drawString(" Tax:", 10, y); g2d.drawString(" "+price_tax.getText().substring(1), 160, y); y+=10;
                g2d.drawString(" Final total:", 10, y); g2d.drawString(spacer2+price_ftot.getText().substring(1)+" ", 160, y); y+=10;
                g2d.drawString("------------------------------------", 10, y); y+=10;
                g2d.drawString("             THANK YOU",12,y); y+=10;
                g2d.drawString("         PLEASE COME AGAIN!", 12, y);y+=10;
                g2d.drawString("------------------------------------", 10, y);y+=10;
                return PAGE_EXISTS;
            }
        };
        int isNone = 0;
        for (int i=0; i < sideList.size(); i++) {
            if (!sideList.get(i).contains("w/")) {
                isNone++;
            }
        }
        PrinterJob job = PrinterJob.getPrinterJob();
        PageFormat pf = job.defaultPage();
        Paper paper = pf.getPaper();       
        double width = CM_to_PP(7); 
        double height = CM_to_PP(7.5+sizeList.size()-(isNone*0.5)); 
        paper.setSize(width, height);
        paper.setImageableArea(0,10,width,height - CM_to_PP(1));  // Sets margins
        pf.setOrientation(PageFormat.PORTRAIT);  
        pf.setPaper(paper); 
        Book book = new Book();
        book.append(contentToPrint, pf);
        job.setPageable(book);
        // Allows multi-page printing
        try {
            job.print();
        } catch (PrinterException e) {
            System.err.println(e.getMessage());
        }
        qtyList.clear();
        sizeList.clear();
        itemList.clear();
        priceList.clear();
        sideList.clear();
    }

    public static void main(String[] args) {
        new NewGarden();
    }
}
