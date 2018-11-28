import nz.ac.waikato.modeljunit.*;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionCoverage;
import org.junit.Test;

public class TestGpa {
    @Test
    public void testGPA() throws Exception {
        GpaModel gpaModel = new GpaModel();
//        difference between these two tester
//        Tester tester = new RandomTester(gpaModel);
        Tester tester = new LookaheadTester(gpaModel);
//        Tester tester = new AllRoundTester(gpaModel);

        tester.buildGraph();
        tester.addListener(new VerboseListener());
        tester.addListener(new StopOnFailureListener());
        tester.addCoverageMetric(new TransitionCoverage());
        tester.addCoverageMetric(new StateCoverage());
        tester.addCoverageMetric(new ActionCoverage());

        tester.generate(20);
        tester.printCoverage();

    }

}
