package com.TweetyPi.PyTwitter.UserInterface;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import twitter4j.Trend;

import com.TweetyPi.PyTwitter.TwitterHandler.NewsHandler;
import com.TweetyPi.PyTwitter.TwitterHandler.TweetyPi;

public class Interface {

	protected Shell shlTweetyPi;
	private Text text;
	private List list;
	private Combo combo;
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
		shlTweetyPi.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		Label label = new Label(shlTweetyPi, SWT.NONE);
		
		Composite composite = new Composite(shlTweetyPi, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(0, 153, 204));
		composite.setLayoutData(new RowData(119, 311));
		
		Label lblTopTrends = new Label(composite, SWT.NONE);
		lblTopTrends.setBounds(21, 10, 76, 18);
		lblTopTrends.setAlignment(SWT.CENTER);
		lblTopTrends.setFont(SWTResourceManager.getFont("Arial", 12, SWT.NORMAL));
		lblTopTrends.setBackground(SWTResourceManager.getColor(0, 153, 204));
		lblTopTrends.setText("Top Trends");
		
		
		list = new List(composite, SWT.BORDER);
		list.setBounds(0, 45, 119, 256);
		list.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		
		Label lblNewLabel = new Label(shlTweetyPi, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(0, 153, 204));
		lblNewLabel.setText("      ");
		
		Composite composite_1 = new Composite(shlTweetyPi, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(0, 153, 204));
		composite_1.setLayoutData(new RowData(276, 311));
		
		text = new Text(composite_1, SWT.MULTI | SWT.BORDER | SWT.WRAP );
		text.setBounds(0, 177, 276, 124);
		text.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		
		Label lblLocation = new Label(composite_1, SWT.NONE);
		lblLocation.setBackground(SWTResourceManager.getColor(0, 153, 204));
		lblLocation.setFont(SWTResourceManager.getFont("Arial", 12, SWT.NORMAL));
		lblLocation.setBounds(10, 10, 114, 15);
		lblLocation.setText("Select Location");
		
		combo = new Combo(composite_1, SWT.READ_ONLY);
		combo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		combo.setBounds(162, 10, 104, 23);
		combo.add("My Location");
		combo.add("Cardiff");
		combo.add("London");
		combo.select(0);
		
		Menu menu = new Menu(shlTweetyPi, SWT.BAR);
		shlTweetyPi.setMenuBar(menu);
		
		MenuItem mntmOptions = new MenuItem(menu, SWT.CASCADE);
		mntmOptions.setText("Options");
		
		Menu menu_1 = new Menu(mntmOptions);
		mntmOptions.setMenu(menu_1);
		
		MenuItem mntmLocation = new MenuItem(menu_1, SWT.NONE);
		mntmLocation.setText("Location Options");
		
		MenuItem mntmPreferences = new MenuItem(menu_1, SWT.NONE);
		mntmPreferences.setText("Preferences");
		
		MenuItem mntmHelp = new MenuItem(menu, SWT.NONE);
		mntmHelp.setText("Help");
		
		Composite composite_2 = new Composite(shlTweetyPi, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(0, 153, 204));
		composite_2.setLayoutData(new RowData(83, 311));
		
		
		Button btnNewButton = new Button(composite_2, SWT.NONE);
		btnNewButton.setBounds(10, 276, 73, 25);
		btnNewButton.setFont(SWTResourceManager.getFont("Arial", 9, SWT.NORMAL));
		btnNewButton.setBackground(new Color(Display.getCurrent(),255,255,255));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String location;
				try {
					list.removeAll();
					TweetyPi tp = new TweetyPi();
					if(combo.getItems()[combo.getSelectionIndex()].contains("My Location")){
						location = tp.lh.getLocation();
			
					}else{
						location = combo.getItem(combo.getSelectionIndex());
					}
					System.out.println("loc " + location);
					Trend[] trendList = tp.th.getTrendList(tp.lh.getWOEID(location));
					for(Trend t : trendList){
						list.add(t.getName());
					}
					
					NewsHandler nh = new NewsHandler();
					ArrayList<String> headlines = new ArrayList<String>();
					for(int i =0 ; i < trendList.length; i++){
						if(trendList[i].getName().contains("#")){
							
							String removeHash = trendList[i].getName().substring(1);
							headlines.add(nh.getHeadline(removeHash));

						}else{
							headlines.add(nh.getHeadline(trendList[i].getName()));

							
						}
						
					}
					int textLimit = 44;
					text.setText(headlines.get(0));
				} catch (Exception excep) {
					// TODO Auto-generated catch block
					excep.printStackTrace();
				}
			}
		});
		btnNewButton.setText("Get News!");

	}
}
