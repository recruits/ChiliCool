package com.zzc.convertsql2xls;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * 
	Shell类的不同样式 
	SWT.TITLE: 只显示 标题栏 
	SWT.CLOSE: 只显示 关闭 
	SWT.MIN: 只显示 最小化 和 关闭 
	SWT.MAX: 只显示 最大化 和 关闭 
	SWT.BORDER: 只显示边框 
	SWT.RESIZE: 窗口的大小可以通过鼠标手动来设定 
	SWT.NO_TRIM: 既无边框也无标题 
	SWT.SHELL_TRIM: 相当于CLOSE TITLE MIN MAX RESIZE同时显示 
	SWT.DIALOG_TRIM:  相当于 CLOSE TITLE BORDER同时显示
	
	文本框的样式：
	SWT.SINGLE：单行文本框
	SWT.NONE：没有边框的文本框
	SWT.BORDER：带边框的文本框
	SWT.LEFT：文本框的字符靠左对齐，默认样式
	SWT.CENTER：文本框的字符居中对齐
	SWT.RIGHT：文本框的字符靠右对齐
	SWT.READ_ONLY：只读文本框
	SWT.PASSWORD：密码输入框
	SWT.MULTI：可输入多行文本的文本框
	SWT.WRAP：多行文本框，并且自动换行
	SWT.H_SCROLL：带有水平滚动条的多行文本框
	SWT.V_SCROLL：带有垂直滚动条的多行文本框
	
	消息图标类型：style属性，有：
	SWT.ICON_ERROR，
	SWT.ICON_INFORMATION，
	SWT.ICON_QUESTION，
	SWT.ICON_WARNING，
	SWT.ICON_WORKING 
	
	按钮类型：style属性，有：
	SWT.OK，SWT.OK | SWT.CANCEL，
	SWT.YES | SWT.NO，
	SWT.YES | SWT.NO | SWT.CANCEL，
	SWT.RETRY | SWT.CANCEL，
	SWT.ABORT | SWT.RETRY | SWT.IGNORE 
 * @author zhangzechen
 *
 */
public class Convertsql2xlsApp {

	protected Shell shlSqlexcel;
	private Text text;
	private Text text_1;

	public Text getText_1() {
		return text_1;
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Convertsql2xlsApp window = new Convertsql2xlsApp();
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
		shlSqlexcel.open();
		shlSqlexcel.layout();
		while (!shlSqlexcel.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSqlexcel = new Shell(SWT.MIN);
		shlSqlexcel.setSize(453, 236);
		shlSqlexcel.setText("Sql2Excel");
		shlSqlexcel.setVisible(false);
		shlSqlexcel.setLayout(new GridLayout(5, false));
		shlSqlexcel.setMaximized(false);

		Menu menu = new Menu(shlSqlexcel, SWT.BAR);
		shlSqlexcel.setMenuBar(menu);

		MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
		menuItem.setText("文件");

		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText("帮助");

		Menu menu_2 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_2);

		MenuItem mntmNewItem_4 = new MenuItem(menu_2, SWT.NONE);
		mntmNewItem_4.setText("说明");
		mntmNewItem_4.addSelectionListener(new SelectionListener() {  
            public void widgetSelected(SelectionEvent arg0) { 
                MessageBox msgbox=new MessageBox(Convertsql2xlsApp.this.shlSqlexcel,SWT.ICON_INFORMATION);
                msgbox.setMessage(Convertsql2xlsProxy.getUseingMeghod()); //设置消息内容
                msgbox.open();
            }  
            public void widgetDefaultSelected(SelectionEvent arg0) {  
            }  
        });  
		

		MenuItem mntmNewItem_5 = new MenuItem(menu_2, SWT.NONE);
		mntmNewItem_5.setText("退出");

		Label lblNewLabel = new Label(shlSqlexcel, SWT.NONE);
		GridData gd_lblNewLabel = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblNewLabel.widthHint = 60;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		lblNewLabel.setText("SQL文件：");

		text = new Text(shlSqlexcel, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gd_text.widthHint = 240;
		text.setLayoutData(gd_text);

		Button btnNewButton = new Button(shlSqlexcel, SWT.NONE);
		GridData gd_btnNewButton = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_btnNewButton.widthHint = 55;
		btnNewButton.setLayoutData(gd_btnNewButton);
		btnNewButton.setText("打开");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				text_1.setText("");
				
				FileDialog fd = new FileDialog(new Shell(), SWT.OPEN);
				fd.setFilterPath("c:\\");
				fd.setFilterExtensions(new String[] { "*.sql" });
				fd.setFilterNames(new String[] { "Text Files(*.sql)" });
				String fileName = fd.open();
				
				if(StringUtils.isNotEmpty(fileName)){
					text.setText(fileName);
				}
			}
		});

		Button btnNewButton_2 = new Button(shlSqlexcel, SWT.NONE);
		GridData gd_btnNewButton_2 = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_btnNewButton_2.widthHint = 55;
		btnNewButton_2.setLayoutData(gd_btnNewButton_2);
		btnNewButton_2.setText("清除");
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				text.setText("");
				text_1.setText("");
			}
		});

		Label label = new Label(shlSqlexcel, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 5,
				1);
		gd_label.widthHint = 426;
		label.setLayoutData(gd_label);

		text_1 = new Text(shlSqlexcel, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		GridData gd_text_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 5,
				3);
		gd_text_1.heightHint = 80;
		text_1.setLayoutData(gd_text_1);
		text_1.setEditable(false);

		Button btnNewButton_1 = new Button(shlSqlexcel, SWT.NONE);
		GridData gd_btnNewButton_1 = new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1);
		gd_btnNewButton_1.widthHint = 55;
		btnNewButton_1.setLayoutData(gd_btnNewButton_1);
		btnNewButton_1.setText("转换");
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				String inFilePath = text.getText();
				text_1.setText("=====================================================" +  ConstTools.SplitConst.SP_NEW_LINE);
				if(StringUtils.isEmpty(inFilePath)){
					text_1.setText("===== 文件路径无效，请重新选择! ======================");
				} else {
					text_1.setText("===== start to deal :" +  ConstTools.SplitConst.SP_NEW_LINE);
					Convertsql2xlsProxy.startConvert(Convertsql2xlsApp.this, inFilePath);
					text_1.append("===== finish !" +  ConstTools.SplitConst.SP_NEW_LINE);
				}
			}
		});
		
		new Label(shlSqlexcel, SWT.NONE);
		new Label(shlSqlexcel, SWT.NONE);
		new Label(shlSqlexcel, SWT.NONE);
		new Label(shlSqlexcel, SWT.NONE);

	}
	
}
