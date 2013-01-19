package protobuf.compiler;

import com.intellij.compiler.CompilerWorkspaceConfiguration;
import com.intellij.openapi.compiler.CompileContext;
import com.intellij.openapi.compiler.CompileTask;
import com.intellij.openapi.compiler.GeneratingCompiler;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;

/**
 * A precompile task for the Protobuffer compiler.
 * @author Travis Cripps
 */
public class PbPrecompileTask implements CompileTask {

    private static final Logger LOG = Logger.getInstance("#protobuf.compiler.PbPrecompileTask");

    @Override
    public boolean execute(CompileContext context) {
        boolean result = true;
        final Project project = context.getProject();

        // When using the out of process build, kick off the {@PBCompiler protobuffers generating compiler}.
        // When using the internal compiler, the {@PBCompiler} is invoked directly by IDEA.
        if (CompilerWorkspaceConfiguration.getInstance(project).useOutOfProcessBuild()) {
            PbCompiler compiler = new PbCompiler(project);
            GeneratingCompiler.GenerationItem[] generationItems = compiler.getGenerationItems(context);
            compiler.generate(context, generationItems, null);
        }
        return result;
    }

}