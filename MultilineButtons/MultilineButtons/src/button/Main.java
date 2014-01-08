package button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Main {

  Display display;

  Shell shell;

  public Main() {
    display = new Display();
    shell = new Shell(display);

    shell.setText("Menu Example");
    shell.setSize(1024, 768);

    FillLayout fillLayout = new FillLayout();
    fillLayout.type = SWT.VERTICAL;
    shell.setLayout(fillLayout);

    MultilineRadioButton radio1 = new MultilineRadioButton(shell, 0);
    radio1.setText("RadioButton1");
    radio1.pack();

    MultilineRadioButton radio2 = new MultilineRadioButton(shell, 0);
    radio2.setText("RadioButton2");
    radio2.pack();

    MultilineRadioButton radio3 = new MultilineRadioButton(shell, 0);
    radio3.setText("RadioButton3\nsome more\ntext");
    radio3.pack();

    MultilineCheckbox check1 = new MultilineCheckbox(shell, 0);
    check1.setText("CheckBox1");
    check1.pack();

    MultilineCheckbox check2 = new MultilineCheckbox(shell, 0);
    check2.setText("CheckBox2");
    check2.pack();

    MultilineCheckbox check3 = new MultilineCheckbox(shell, 0);
    check3.setText("CheckBox3\nsome more\ntext");
    check3.pack();

    shell.pack();
	shell.open ();

    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    display.dispose();
  }

  public static void main(String[] args) {
	    Main example = new Main();
	}

}
