import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

class HintTextField extends JTextField implements FocusListener {

  private final String hint;
  private boolean showingHint;

  public HintTextField(final String hint) {
    super(hint);
    this.hint = hint;
    this.showingHint = true;
    super.addFocusListener(this);
  }

 
  public void focusGained(FocusEvent e) {
    if(this.getText().isEmpty()) {
      super.setText("");
      showingHint = false;
    }
  }
 
  public void focusLost(FocusEvent e) {
    if(this.getText().isEmpty()) {
      super.setText(hint);
      showingHint = true;
    }
  }

  @Override
  public String getText() {
    return showingHint ? "" : super.getText();
  }
}