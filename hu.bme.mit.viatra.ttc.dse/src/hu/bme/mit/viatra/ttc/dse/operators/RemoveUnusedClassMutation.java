/*******************************************************************************
 * Copyright (c) 2010-2016, Andras Szabolcs Nagy and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Andras Szabolcs Nagy - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.viatra.ttc.dse.operators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.viatra.dse.base.DesignSpaceManager;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.designspace.api.TrajectoryInfo;
import org.eclipse.viatra.dse.evolutionary.GeneticHelper;
import org.eclipse.viatra.dse.evolutionary.TrajectoryWithStateFitness;
import org.eclipse.viatra.dse.evolutionary.interfaces.IMutation;
import org.eclipse.viatra.dse.objectives.Fitness;
import org.eclipse.viatra.dse.objectives.TrajectoryFitness;

public class RemoveUnusedClassMutation implements IMutation {

    @Override
    public TrajectoryFitness mutate(TrajectoryFitness parent, ThreadContext context) {

        DesignSpaceManager dsm = context.getDesignSpaceManager();

        int classes = 0;
        int highestUsedTaskId = -1;
        int lastIndex = 0;

        Object[] trajectory = parent.trajectory;
        for (int i = 0; i < trajectory.length; i++) {
            Object t = trajectory[i];
            if ("CX".equals(t)) {
                classes++;
                lastIndex = i;
            } else {
                Matcher matcher = Pattern.compile("\\d+").matcher(t.toString());
                matcher.find();
                int assignedToTask = Integer.valueOf(matcher.group());
                if (assignedToTask > highestUsedTaskId) {
                    highestUsedTaskId = assignedToTask;
                }
            }
        }

        if (classes <= highestUsedTaskId + 1) {
            return null;
        }

        for (int i = 0; i < trajectory.length; i++) {
            Object t = trajectory[i];
            if (i < lastIndex) {
                dsm.fireActivation(t);
            } else if (i > lastIndex) {
                GeneticHelper.tryFireRightTransition(dsm, t);
            }
        }

        Fitness calculateFitness = context.calculateFitness();
        TrajectoryInfo trajectoryInfo = dsm.getTrajectoryInfo();
        TrajectoryFitness child = new TrajectoryWithStateFitness(trajectoryInfo, calculateFitness);

        dsm.undoUntilRoot();

        return child;
    }

}
