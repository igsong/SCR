package kr.ac.kaist.se.interactionmodel.idl.diagram.features.interaction;
import kr.ac.kaist.se.interaction.idl.Choreography;
import kr.ac.kaist.se.interaction.idl.IdlFactory;
import kr.ac.kaist.se.interaction.idl.Participant;

import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * A simple input dialog for soliciting an input string from the user.
 * <p>
 * This concrete dialog class can be instantiated as is, or further subclassed as
 * required.
 * </p>
 */
public class InteractionInputDialog extends Dialog {
    /**
     * The title of the dialog.
     */
    private String title;

    private Choreography choreography;
    /**
     * The input value; the empty string by default.
     */
    private String interactionName = "";//$NON-NLS-1$

    /**
     * 
     */
    private Participant sender = null;
    
    private Combo senderCombo;
    /**
     * 
     */
    private Participant receiver = null;
   
    private Combo receiverCombo;
    /**
     * Ok button widget.
     */
    private Button okButton;

    /**
     * Input text widget.
     */
    private Text interactionNameText;

    public InteractionInputDialog(Shell parentShell, Choreography choreography) {
    	this(parentShell, choreography, null, null, null);
    }

    public InteractionInputDialog(Shell parentShell, Choreography choreography,
			String curName, Participant curSender, Participant curReceiver) {
        super(parentShell);
        this.title = "Adding Interaction";
        this.choreography = choreography;	
        interactionName = curName;
        sender = curSender;
        receiver = curReceiver;
    }

	/*
     * (non-Javadoc) Method declared on Dialog.
     */
    protected void buttonPressed(int buttonId) {
        if (buttonId == IDialogConstants.OK_ID) {
            interactionName = interactionNameText.getText();
        } else {
        	interactionName = null;
        }
        super.buttonPressed(buttonId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
     */
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        if (title != null) {
			shell.setText(title);
		}
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
     */
    protected void createButtonsForButtonBar(Composite parent) {
        // create OK and Cancel buttons by default
        okButton = createButton(parent, IDialogConstants.OK_ID,
                IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID,
                IDialogConstants.CANCEL_LABEL, false);
        //do this here because setting the text will set enablement on the ok
        // button
        interactionNameText.setFocus();
        if (interactionName != null) {
            interactionNameText.setText(interactionName);
            interactionNameText.selectAll();
        }
        
        if( sender != null )
        {
        	senderCombo.select(choreography.getParticipants().indexOf(sender));
        }
        
        if( receiver != null )
        {
        	receiverCombo.select(choreography.getParticipants().indexOf(receiver));
        }
    }

    /*
     * (non-Javadoc) Method declared on Dialog.
     */
    protected Control createDialogArea(Composite parent) {
        // create composite
        Composite dialogArea = (Composite) super.createDialogArea(parent);
        // create message
		Composite inputArea = new Composite(dialogArea, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		inputArea.setLayout(layout);
		inputArea.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		
		Label t1 = new Label(inputArea, SWT.NONE);
		t1.setText("Name");
        interactionNameText = new Text(inputArea, getInputTextStyle());
        interactionNameText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
                | GridData.HORIZONTAL_ALIGN_FILL));
        
        Label t2 = new Label(inputArea, SWT.NONE);
		t2.setText("Sender");
        senderCombo = new Combo(inputArea, getInputTextStyle());
        for( Participant p : choreography.getParticipants() )
        {
        	senderCombo.add(p.getName());
       
        }
        senderCombo.add("New participant...");
     	senderCombo.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				if( choreography.getParticipants().size() <= senderCombo.getSelectionIndex() )
				{
					String newParticipantName = ExampleUtil.askString("Enter the new participant", "What is the name of new participant?", "");
					if (newParticipantName == null || newParticipantName.trim().length() == 0) {
						senderCombo.select(0);
						return;
					}
					
					sender = IdlFactory.eINSTANCE.createParticipant();
					sender.setName(newParticipantName);
					choreography.getParticipants().add(sender);
				
					int idx = senderCombo.getItemCount() - 1;
					senderCombo.add(newParticipantName, idx);
					receiverCombo.add(newParticipantName, idx);
					
					senderCombo.select(idx);
				}
				else
				{
					sender = choreography.getParticipants().get(senderCombo.getSelectionIndex());
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
        senderCombo.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
                | GridData.HORIZONTAL_ALIGN_FILL));
        
        
        Label t3 = new Label(inputArea, SWT.NONE);
		t3.setText("Receiver");
        receiverCombo = new Combo(inputArea, getInputTextStyle());
        for( Participant p : choreography.getParticipants() )
        {
        	receiverCombo.add(p.getName());
        }
        receiverCombo.add("New participant...");
    	receiverCombo.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				if( choreography.getParticipants().size() <= receiverCombo.getSelectionIndex() )
				{
					String newParticipantName = ExampleUtil.askString("Enter the new participant", "What is the name of new participant?", "");
					if (newParticipantName == null || newParticipantName.trim().length() == 0) {
						receiverCombo.select(0);
						return;
					}
					
					receiver = IdlFactory.eINSTANCE.createParticipant();
					receiver.setName(newParticipantName);
					choreography.getParticipants().add(receiver);
				
					int idx = receiverCombo.getItemCount() - 1;
					receiverCombo.add(newParticipantName, idx);
					receiverCombo.add(newParticipantName, idx);
					
					receiverCombo.select(idx);
				}
				else
				{
					receiver = choreography.getParticipants().get(receiverCombo.getSelectionIndex());
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
    		
    	});
        receiverCombo.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
                | GridData.HORIZONTAL_ALIGN_FILL));        
        
 
        applyDialogFont(inputArea);
        return inputArea;
    }
    

    /**
     * Returns the ok button.
     * 
     * @return the ok button
     */
    protected Button getOkButton() {
        return okButton;
    }

    /**
     * Returns the text area.
     * 
     * @return the text area
     */
    protected Text getInteractionNameText() {    	
        return interactionNameText;
    }

    /**
     * Returns the string typed into this input dialog.
     * 
     * @return the input string
     */
    public String getInteractionName() {
        return interactionName;
    }
    
    public Participant getSender()
    {
    	return sender;
    }
    
    public Participant getReceiver()
    {
    	return receiver;
    }
    
	/**
	 * Returns the style bits that should be used for the input text field.
	 * Defaults to a single line entry. Subclasses may override.
	 * 
	 * @return the integer style bits that should be used when creating the
	 *         input text
	 * 
	 * @since 3.4
	 */
	protected int getInputTextStyle() {
		return SWT.SINGLE | SWT.BORDER;
	}
}