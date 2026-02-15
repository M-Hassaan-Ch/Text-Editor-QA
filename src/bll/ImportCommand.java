package bll;

import java.io.File;

public class ImportCommand implements Command {
    private IFacadeBO facade;
    private File file;
    private String fileName;

    public ImportCommand(IFacadeBO facade, File file, String fileName) {
        this.facade = facade;
        this.file = file;
        this.fileName = fileName;
    }

    @Override
    public boolean execute() {
        if (file == null || fileName == null || fileName.isEmpty()) {
            return false;
        }
        return facade.importTextFiles(file, fileName);
    }
}
