package bll;

import dto.Documents;
import java.io.FileWriter;
import java.io.IOException;

public class ExportCommand implements Command {
    private IFacadeBO facade;
    private int fileId;
    private String exportPath;

    public ExportCommand(IFacadeBO facade, int fileId, String exportPath) {
        this.facade = facade;
        this.fileId = fileId;
        this.exportPath = exportPath;
    }

    @Override
    public boolean execute() {
        if (exportPath == null || exportPath.isEmpty()) {
            return false;
        }
        Documents doc = facade.getFile(fileId);
        if (doc == null) {
            return false;
        }
        try (FileWriter writer = new FileWriter(exportPath)) {
            writer.write(doc.getName());
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
