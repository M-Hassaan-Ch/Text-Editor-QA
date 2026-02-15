package bll;

public class TransliterateCommand implements Command {
    private IFacadeBO facade;
    private int pageId;
    private String arabicText;
    private String result;

    public TransliterateCommand(IFacadeBO facade, int pageId, String arabicText) {
        this.facade = facade;
        this.pageId = pageId;
        this.arabicText = arabicText;
    }

    @Override
    public boolean execute() {
        if (arabicText == null || arabicText.isEmpty()) {
            return false;
        }
        result = facade.transliterate(pageId, arabicText);
        return result != null;
    }

    public String getResult() {
        return result;
    }
}
