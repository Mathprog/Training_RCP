import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import com.opcoach.training.rental.Customer;
import com.sogeti.training.rental.ui.cmd.CmdActivator;

public class CustomerCopyHandler extends AbstractHandler {


	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
        ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
        if( currentSelection instanceof IStructuredSelection) {
        	Object selectObject = ((IStructuredSelection) currentSelection).getFirstElement();
        	if( selectObject instanceof Customer) {
        		Customer customer = (Customer) selectObject;
        		Clipboard clipboard = new Clipboard(Display.getCurrent());
    	        String textData = customer.getDisplayName();
    	        String rtfData = "{\\rtf1\\b\\i "+ customer.getDisplayName() + "}";
    	        TextTransfer textTransfer = TextTransfer.getInstance();
    	        RTFTransfer rtfTransfer = RTFTransfer.getInstance();
    	        Transfer[] transfers = new Transfer[]{textTransfer, rtfTransfer};
    	        Object[] data = new Object[]{textData, rtfData};
    	        clipboard.setContents(data, transfers);
    	        clipboard.dispose();
        	}
        }
		return null;
	}

}
