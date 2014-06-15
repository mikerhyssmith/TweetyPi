package com.TweetyPi.PyTwitter.UserInterface;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import swing2swt.layout.BoxLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.layout.RowData;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;

public class Interface {

	protected Shell shlTweetyPi;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Interface window = new Interface();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlTweetyPi.open();
		shlTweetyPi.layout();
		while (!shlTweetyPi.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlTweetyPi = new Shell();
		shlTweetyPi.setBackground(SWTResourceManager.getColor(0, 153, 204));
		shlTweetyPi.setSize(535, 396);
		shlTweetyPi.setText("Tweety Pi");
		shlTweetyPi.setLayout(new GridLayout(3, false));
		
		Label lblTopTrends = new Label(shlTweetyPi, SWT.NONE);
		lblTopTrends.setFont(SWTResourceManager.getFont("Arial", 12, SWT.NORMAL));
		lblTopTrends.setBackground(SWTResourceManager.getColor(0, 153, 204));
		lblTopTrends.setText("Top Trends");
		new Label(shlTweetyPi, SWT.NONE);
		new Label(shlTweetyPi, SWT.NONE);
		
		
		List list = new List(shlTweetyPi, SWT.BORDER);
		GridData gd_list = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_list.widthHint = 119;
		gd_list.heightHint = 257;
		list.setLayoutData(gd_list);
		new Label(shlTweetyPi, SWT.NONE);
		new Label(shlTweetyPi, SWT.NONE);
		new Label(shlTweetyPi, SWT.NONE);
		
		
		Button btnNewButton = new Button(shlTweetyPi, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		btnNewButton.setBackground(new Color(Display.getCurrent(),255,255,255));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton.setText("Get News!");

	}

}
