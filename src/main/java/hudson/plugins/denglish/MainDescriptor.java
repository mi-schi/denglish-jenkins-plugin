
package hudson.plugins.denglish;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Publisher;


@Extension
public class MainDescriptor extends BuildStepDescriptor<Publisher> {

    public MainDescriptor() {
        super(MainRecorder.class);
    }

    @Override
    public final String getDisplayName() {
        return "Activate denglish";
    }

    @Override
    public final boolean isApplicable(
            final Class<? extends AbstractProject> clazz) {
        return true;
    }
}
