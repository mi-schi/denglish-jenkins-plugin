
package hudson.plugins.denglish;

import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Recorder;

import java.io.IOException;
import java.util.logging.Logger;

import org.kohsuke.stapler.DataBoundConstructor;

public class MainRecorder extends Recorder {

    private static final Logger LOGGER = Logger
            .getLogger(MainRecorder.class.getName());

    private FactGenerator factGenerator;

    @DataBoundConstructor
    public MainRecorder() {
        this(new FactGenerator());
    }

    public MainRecorder(final FactGenerator factGenerator) {
        this.factGenerator = factGenerator;
        LOGGER.info("denglish is activated");
    }

    @Override
    public final Action getProjectAction(final AbstractProject<?, ?> project) {
        Action action = null;
        if (project.getLastBuild() != null) {
            Style style = Style.get(project.getLastBuild().getResult());
            String fact = factGenerator.random();
            action = new MainAction(style, fact);
        }
        return action;
    }

    @Override
    public final boolean perform(final AbstractBuild<?, ?> build,
            final Launcher launcher, final BuildListener listener)
            throws InterruptedException, IOException {
        Style style = Style.get(build.getResult());
        String fact = factGenerator.random();
        build.getActions().add(new MainAction(style, fact));
        return true;
    }

    public final BuildStepMonitor getRequiredMonitorService() {
        return BuildStepMonitor.NONE;
    }
}
