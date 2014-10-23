package edu.jhu.hlt.optimize;

import org.junit.Test;

import edu.jhu.hlt.optimize.AdaGradFobos.AdaGradFobosPrm;
import edu.jhu.hlt.optimize.function.DifferentiableBatchFunction;
import edu.jhu.hlt.optimize.functions.SumSquares;
import edu.jhu.hlt.util.JUnitUtils;
import edu.jhu.hlt.util.math.Vectors;
import edu.jhu.prim.vector.IntDoubleDenseVector;

public class AdaGradFobosTest extends AbstractBatchOptimizerTest {

    @Override
    protected Optimizer<DifferentiableBatchFunction> getOptimizer() {
        AdaGradFobosPrm prm = getOptimizerPrm();
        return new AdaGradFobos(prm);
    }

    protected AdaGradFobosPrm getOptimizerPrm() {
        AdaGradFobosPrm prm = new AdaGradFobosPrm();
        prm.eta = 0.1 * 100;
        prm.sched = null;
        //prm.sched.setEta0(0.1 * 10);
        prm.numPasses = 100;
        prm.batchSize = 1;
        prm.autoSelectLr = false;
        prm.l1Lambda = 0.0;
        return prm;
    }    

    protected Optimizer<DifferentiableBatchFunction> getRegularizedOptimizer(double l1Lambda, double l2Lambda) {
        AdaGradFobosPrm prm = getOptimizerPrm();
        prm.l1Lambda = l1Lambda;
        if (l2Lambda != 0) { return super.getRegularizedOptimizer(l1Lambda, l2Lambda); }
        return new AdaGradFobos(prm);
    }

    
}