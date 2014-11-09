
package hudson.plugins.denglish;

import hudson.model.Action;


public final class MainAction implements Action {

    private Style style;

    private Style mStyle;

    private String fact;

    private String mFact;

    public MainAction(final Style style, final String fact) {
        super();
        this.mStyle = style;
        this.mFact = fact;
    }

    public String getDisplayName() {
        return "denglish";
    }

    public String getIconFileName() {
        return null;
    }

    public String getUrlName() {
        return "denglish";
    }

    public Style getStyle() {
        Style theStyle;
        if (mStyle != null) {
            theStyle = mStyle;
        } else {
            theStyle = style;
        }
        return theStyle;
    }

    public String getFact() {
        String theFact;
        if (mFact != null) {
            theFact = mFact;
        } else {
            theFact = fact;
        }
        return theFact;
    }
}
