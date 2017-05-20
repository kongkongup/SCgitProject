package GUI;



import java.awt.event.ActionListener;

import javax.swing.JFrame;

import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;




public class Seats extends JFrame {
	public Seats() {
		JDatePicker sp = new JDatePicker() {
			
			@Override
			public void removeActionListener(ActionListener arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public DateModel<?> getModel() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void addActionListener(ActionListener arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setShowYearButtons(boolean arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setDoubleClickAction(boolean arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isShowYearButtons() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isDoubleClickAction() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void setTextEditable(boolean arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setButtonFocusable(boolean arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isTextEditable() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean getButtonFocusable() {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}
	
}
