package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class GSTGeraTabMA2 extends JPanel implements PropertyChangeListener {

    /**
     *
     */
    private static final long serialVersionUID = 316308848064659639L;

    // Values for the fields

    private double MAPar1 = 0.1;
    private double MAPar2 = 0.1;
    private int NumeroAmo = 50;
    private double ValorMedio = 0;
    private double VarRuido = 1;

    // Labels to identify the fields
    private JLabel MAPar1Label;
    private JLabel MAPar2Label;
    private JLabel NumeroAmoLabel;
    private JLabel ValorMedioLabel;
    private JLabel VarRuidoLabel;

    // Strings for the labels
    private static String MAPar1String = "Value of " + "\u03B8" + "1    |" + "\u03B8" + "1" + "| <1      : ";
    private static String MAPar2String = "Value of " + "\u03B8" + "2    |" + "\u03B8" + "2" + "| <1      : ";
    private static String NumeroAmoString = "Define sample size          : ";
    private static String ValorMedioString = "Define mean                 : ";
    private static String VarRuidoString = "Define noise variance       : ";

    // Fields for data entry
    private JFormattedTextField MAPar1Field;
    private JFormattedTextField MAPar2Field;
    private JFormattedTextField NumeroAmoField;
    private JFormattedTextField ValorMedioField;
    private JFormattedTextField VarRuidoField;

    // Formats to format and parse numbers
    private NumberFormat MAPar1Format;
    private NumberFormat MAPar2Format;
    private NumberFormat NumeroAmoFormat;
    private NumberFormat ValorMedioFormat;
    private NumberFormat VarRuidoFormat;

    public GSTGeraTabMA2()
	{

	    super(new MigLayout());
	    this.setUpFormats();

	    // Create the labels.

	    this.MAPar1Label = new JLabel(MAPar1String);
	    this.MAPar2Label = new JLabel(MAPar2String);
	    this.NumeroAmoLabel = new JLabel(NumeroAmoString);
	    this.ValorMedioLabel = new JLabel(ValorMedioString);
	    this.VarRuidoLabel = new JLabel(VarRuidoString);

	    // Create the text fields and set them up.

	    this.MAPar1Field = new JFormattedTextField(this.MAPar1Format);
	    this.MAPar1Field.setValue(Double.valueOf(this.MAPar1));
	    this.MAPar1Field.setColumns(5);
	    this.MAPar1Field.addPropertyChangeListener("value", this);

	    this.MAPar2Field = new JFormattedTextField(this.MAPar2Format);
	    this.MAPar2Field.setValue(Double.valueOf(this.MAPar2));
	    this.MAPar2Field.setColumns(5);
	    this.MAPar2Field.addPropertyChangeListener("value", this);

	    this.NumeroAmoField = new JFormattedTextField(this.NumeroAmoFormat);
	    this.NumeroAmoField.setValue(Double.valueOf(this.NumeroAmo));
	    this.NumeroAmoField.setColumns(3);
	    this.NumeroAmoField.addPropertyChangeListener("value", this);

	    this.ValorMedioField = new JFormattedTextField(this.ValorMedioFormat);
	    this.ValorMedioField.setValue(Double.valueOf(this.ValorMedio));
	    this.ValorMedioField.setColumns(5);
	    this.ValorMedioField.addPropertyChangeListener("value", this);

	    this.VarRuidoField = new JFormattedTextField(this.VarRuidoFormat);
	    this.VarRuidoField.setValue(Double.valueOf(this.VarRuido));
	    this.VarRuidoField.setColumns(5);
	    this.VarRuidoField.addPropertyChangeListener("value", this);

	    // Tell accessibility tools about label/textfield pairs.
	    this.MAPar1Label.setLabelFor(this.MAPar1Field);
	    this.MAPar2Label.setLabelFor(this.MAPar2Field);
	    this.NumeroAmoLabel.setLabelFor(this.NumeroAmoField);
	    this.ValorMedioLabel.setLabelFor(this.ValorMedioField);
	    this.VarRuidoLabel.setLabelFor(this.VarRuidoField);

	    this.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
	    this.add(this.MAPar1Label);
	    this.add(this.MAPar1Field, "wrap");
	    this.add(this.MAPar2Label);
	    this.add(this.MAPar2Field, "wrap");
	    this.add(this.NumeroAmoLabel);
	    this.add(this.NumeroAmoField, "wrap");
	    this.add(this.ValorMedioLabel);
	    this.add(this.ValorMedioField, "wrap");
	    this.add(this.VarRuidoLabel);
	    this.add(this.VarRuidoField, "wrap");
	}

    /** Called when a field's "value" property changes. */
    @Override
    public void propertyChange(PropertyChangeEvent e)
	{
	    Object source = e.getSource();
	    if (source == this.MAPar1Field)
		{
		    this.MAPar1 = ((Number) this.MAPar1Field.getValue()).doubleValue();
		} else if (source == this.MAPar2Field)
		{
		    this.MAPar2 = ((Number) this.MAPar2Field.getValue()).doubleValue();
		} else if (source == this.NumeroAmoField)
		{
		    this.NumeroAmo = ((Number) this.NumeroAmoField.getValue()).intValue();
		} else if (source == this.ValorMedioField)
		{
		    this.ValorMedio = ((Number) this.ValorMedioField.getValue()).doubleValue();
		} else if (source == this.VarRuidoField)
		{
		    this.VarRuido = ((Number) this.VarRuidoField.getValue()).doubleValue();
		}
	}

    // Create and set up number formats. These objects also
    // parse numbers input by user.
    private void setUpFormats()
	{
	    this.MAPar1Format = NumberFormat.getInstance(new Locale("en", "US"));
	    this.MAPar2Format = NumberFormat.getInstance(new Locale("en", "US"));
	    this.NumeroAmoFormat = NumberFormat.getInstance(new Locale("en", "US"));
	    this.ValorMedioFormat = NumberFormat.getInstance(new Locale("en", "US"));
	    this.VarRuidoFormat = NumberFormat.getInstance(new Locale("en", "US"));
	}

    public double getPAR1()
	{
	    return this.MAPar1;
	}

    public double getPAR2()
	{
	    return this.MAPar2;
	}

    public double getVarRuido()
	{
	    return this.VarRuido;
	}

    public double getValorMedio()
	{
	    return this.ValorMedio;
	}

    public int getNoAmostra()
	{
	    return this.NumeroAmo;

	}

}
