package spiel;

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
 
 
public class MaxSizeDocument extends PlainDocument {
	
	private static final long serialVersionUID = -6302708300400920688L;
	int maxSize;
 
   public MaxSizeDocument(int maxSize) {
      this.maxSize = maxSize;
   }
 
   @Override
   public void insertString (final int offset, final String text,
                             final AttributeSet attributeSet) throws BadLocationException {
      if (isNewLengthOk(text))
         super.insertString (offset, text, attributeSet);
      else
         Toolkit.getDefaultToolkit().beep();
   }
 
   protected boolean isNewLengthOk(final String text) {
      if (getLength() + text.length() <= maxSize)
         return true;
      return false;
   }
 
   public static void main (final String [] ignored) {
	   //Quelle: http://javawiki.sowas.com/doku.php?id=swing:jtextfield-size
   }
}