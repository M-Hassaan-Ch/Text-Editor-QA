package business;

import org.junit.Test;

import bll.ExportCommand;
import bll.ImportCommand;
import bll.TransliterateCommand;

import static org.junit.Assert.*;

/**
* Command Pattern Tests - Tests execute() methods
*/
public class CommandPatternTest {

   // Test ImportCommand with null file
   @Test
   public void testImportCommandNullFile() {
       ImportCommand cmd = new ImportCommand(null, null, "test.txt");
       assertFalse(cmd.execute());
   }

   // Test ImportCommand with empty filename
   @Test
   public void testImportCommandEmptyFileName() {
       ImportCommand cmd = new ImportCommand(null, null, "");
       assertFalse(cmd.execute());
   }

   // Test ExportCommand with null path
   @Test
   public void testExportCommandNullPath() {
       ExportCommand cmd = new ExportCommand(null, 1, null);
       assertFalse(cmd.execute());
   }

   // Test ExportCommand with empty path
   @Test
   public void testExportCommandEmptyPath() {
       ExportCommand cmd = new ExportCommand(null, 1, "");
       assertFalse(cmd.execute());
   }

   // Test TransliterateCommand with null text
   @Test
   public void testTransliterateCommandNullText() {
       TransliterateCommand cmd = new TransliterateCommand(null, 1, null);
       assertFalse(cmd.execute());
   }

   // Test TransliterateCommand with empty text
   @Test
   public void testTransliterateCommandEmptyText() {
       TransliterateCommand cmd = new TransliterateCommand(null, 1, "");
       assertFalse(cmd.execute());
   }
}
